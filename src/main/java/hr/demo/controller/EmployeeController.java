package hr.demo.controller;

import hr.demo.model.Employee;
import hr.demo.service.EmployeeService;
import hr.demo.vo.EmployeeJobVo;
import hr.demo.vo.EmployeeVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "View a list of Employee", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> list = employeeService.listEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @ApiOperation(value = "Get employee by Id", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Employee"),
            @ApiResponse(code = 500, message = "Id employee not found")
    }
    )
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        Employee list = employeeService.getEmplById(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/employeeJob/{id}")
    public ResponseEntity<EmployeeJobVo> getEmployeeWithJob(@PathVariable int id){
        EmployeeJobVo list = employeeService.getEmplWithJob(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // inserting employee
    @PostMapping("/employees")
    public ResponseEntity<String> addEmployees(@RequestBody EmployeeVo employee){
        Boolean result = employeeService.addEmployee(employee);
        if(result){
            return new ResponseEntity<>("Add Employee Berhasil", HttpStatus.OK);
        }
        return new ResponseEntity<>("Add Employee Gagal", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Update employee by Id", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Employee"),
            @ApiResponse(code = 500, message = "Id employee not found")
    }
    )
    @PutMapping({"/employees/{id}"})
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeVo param, @PathVariable int id) {
        Employee local = employeeService.getEmplById(id);
        if(local != null){
            Boolean result = employeeService.editEmployee(param, id);
            if(result){
                return new ResponseEntity<>("Edit Empoyee Berhasil", HttpStatus.OK);
            }
            return new ResponseEntity<>("Edit Employee Gagal", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("Edit Employee Gagal", HttpStatus.resolve(500));
        }
    }

    @ApiOperation(value = "Delete employee by Id", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Employee"),
            @ApiResponse(code = 500, message = "Id employee not found")
    }
    )
    @DeleteMapping({"employees/{id}"})
    public ResponseEntity<String> deleteEmployeeByID(@PathVariable int id) {
        Employee local = employeeService.getEmplById(id);
        if(local != null) {
            Boolean result = employeeService.deleteEmployee(id);
            if (result) {
                return new ResponseEntity<>("Delete Employee Berhasil", HttpStatus.OK);
            }
            return new ResponseEntity<>("Delete Employee Gagal", HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>("Edit Employee Gagal", HttpStatus.resolve(500));
        }
    }

}
