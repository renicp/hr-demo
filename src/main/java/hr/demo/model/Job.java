package hr.demo.model;

import javax.persistence.*;

@Entity
@Table(name="mst_jobs")
public class Job {
    @Id
    @Column(name="job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    @Column(name="job_desc")
    private String jobDesc;
    public Job(){}

    public Job(String jobDesc){
        this.jobDesc =jobDesc;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
}
