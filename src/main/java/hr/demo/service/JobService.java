package hr.demo.service;

import hr.demo.model.Job;

import java.util.List;

public interface JobService {
    Boolean addJob(Job job);
    Boolean editJob(Job job, int id);
    Boolean deleteJob(int id);
    List<Job> listJob();
}
