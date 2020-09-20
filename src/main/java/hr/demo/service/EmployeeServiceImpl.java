package hr.demo.service;

import hr.demo.model.Employee;
import hr.demo.model.EmployeeJob;
import hr.demo.repositories.EmployeeJobRepo;
import hr.demo.repositories.EmployeeRepo;
import hr.demo.repositories.JobRepo;
import hr.demo.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeJobRepo employeeJobRepo;

    @Autowired
    private JobRepo jobRepo;

    @Override
    public List<Employee> listEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmplById(int id) {
        return employeeRepo.findById(id).get();
    }

    @Override
    public Boolean addEmployee(EmployeeVo param) {
        Boolean result = false;
        Employee employee= new Employee(param.getFirstName(), param.getLastName());
        try {
            Employee empl = employeeRepo.save(employee);
            EmployeeJob emplJob = new EmployeeJob(empl.getEmployeeID(), param.getEmplJobId());
            employeeJobRepo.save(emplJob);
            result =true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Boolean deleteEmployee(int id) {
        Boolean result= false;
        try {
            employeeRepo.deleteById(id);
            result =true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Boolean editEmployee(EmployeeVo param, int id) {
        Boolean result = false;
        try {
            Employee emplLocal = employeeRepo.getOne(id);
            emplLocal.setFirstName(param.getFirstName());
            emplLocal.setLastName(param.getLastName());
            EmployeeJob emplJobLocal = employeeJobRepo.findByEmployeeId(id);
            emplJobLocal.setJobId(param.getEmplJobId());
            employeeRepo.save(emplLocal);
            employeeJobRepo.save(emplJobLocal);
            result = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
