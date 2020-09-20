package hr.demo.service;

import hr.demo.model.Employee;
import hr.demo.vo.EmployeeJobVo;
import hr.demo.vo.EmployeeVo;

import java.util.List;

public interface EmployeeService {
    List<Employee> listEmployee();
    Employee getEmplById(int id);
    EmployeeJobVo getEmplWithJob(int id);
    Boolean addEmployee(EmployeeVo param);
    Boolean deleteEmployee(int id);
    Boolean editEmployee(EmployeeVo param, int id);
}
