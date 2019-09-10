package com.company.jobjet.controller;

import com.company.jobjet.dao.JobDao;
import com.company.jobjet.dto.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {

    @Autowired
    private JobDao jobDao;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    Job addJob(@RequestBody @Valid Job job){
        return jobDao.addJob(job);
    }
}
