package hr.demo.repositories;

import hr.demo.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Integer> {
}
