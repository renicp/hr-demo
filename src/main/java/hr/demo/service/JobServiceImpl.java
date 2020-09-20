package hr.demo.service;

import hr.demo.model.Job;
import hr.demo.repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepo jobRepo;

    @Override
    public Boolean addJob(Job job) {
        Boolean result = false;
        try {
            jobRepo.save(job);
            result = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Boolean editJob(Job job, int id) {
        Boolean result = false;
        try {
            Job jobLocal = jobRepo.getOne(id);
            Job jobNew = new Job(job.getJobDesc());
            jobNew.setJobId(jobLocal.getJobId());
            jobRepo.save(jobNew);
            result = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Boolean deleteJob(int id) {
        Boolean result = false;
        try {
            jobRepo.deleteById(id);
            result = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Job> listJob() {
        return jobRepo.findAll();
    }
}
