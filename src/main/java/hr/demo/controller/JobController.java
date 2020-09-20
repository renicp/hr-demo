package hr.demo.controller;

import hr.demo.model.Job;
import hr.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/list")
    public ResponseEntity<List<Job>> getAllJob(){
        List<Job> list = jobService.listJob();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // inserting employee
    @PostMapping("/add")
    public ResponseEntity<String> addJob(@RequestBody Job job){
        Boolean result = jobService.addJob(job);
        if(result){
            return new ResponseEntity<>("Add Job Berhasil", HttpStatus.OK);
        }
        return new ResponseEntity<>("Add Job Gagal", HttpStatus.BAD_REQUEST);
    }

    @PutMapping({"/edit/{id}"})
    public ResponseEntity<String> editJob(@RequestBody Job param, @PathVariable int id) {
        Boolean result = jobService.editJob(param, id);
        if(result){
            return new ResponseEntity<>("Edit Job Berhasil", HttpStatus.OK);
        }
        return new ResponseEntity<>("Edit Job Gagal", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping({"delete/{id}"})
    public ResponseEntity<String> deleteJobById(@PathVariable int id) {
        Boolean result = jobService.deleteJob(id);
        if(result){
            return new ResponseEntity<>("Delete Job Berhasil", HttpStatus.OK);
        }
        return new ResponseEntity<>("Delete Job Gagal", HttpStatus.BAD_REQUEST);
    }

}
