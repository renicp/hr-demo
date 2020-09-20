package hr.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name="employee_job")
public class EmployeeJob {

    @Id
    @Column(name="empl_job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emplJobId;

    @Column(name="empl_id_fk")
    private int employeeId;

    @Column(name="job_id_fk")
    private int jobId;

    public EmployeeJob(){}

    public EmployeeJob(int employeeId, int jobId){
        this.employeeId = employeeId;
        this.jobId= jobId;
    }
    public int getEmplJobId() {
        return emplJobId;
    }

    public void setEmplJobId(int emplJobId) {
        this.emplJobId = emplJobId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
