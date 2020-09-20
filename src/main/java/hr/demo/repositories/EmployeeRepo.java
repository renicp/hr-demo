package hr.demo.repositories;

import hr.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Override
    Optional<Employee> findById(Integer integer);
}
