package hr.demo.repositories;

import hr.demo.model.EmployeeJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJobRepo extends JpaRepository<EmployeeJob, Integer>{

    EmployeeJob findByEmployeeId(int id);
}
