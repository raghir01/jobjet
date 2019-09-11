package com.company.jobjet.controller;

import com.company.jobjet.dao.JobDao;
import com.company.jobjet.dto.Job;
import com.company.jobjet.service.JobService;
import com.company.jobjet.viewmodel.JobViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    JobViewModel addJob(@RequestBody @Valid JobViewModel jobViewModel){
        return jobService.addJob(jobViewModel);
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    JobViewModel getJob(@PathVariable int id){
        return jobService.getJob(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<JobViewModel> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    JobViewModel updateJob(@RequestBody @Valid JobViewModel jobViewModel){
        return jobService.updateJob(jobViewModel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    void deleteJob(@PathVariable int id){
         jobService.deleteJob(id);
    }


}
