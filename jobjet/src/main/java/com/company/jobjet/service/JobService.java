package com.company.jobjet.service;

import com.company.jobjet.dao.JobDao;
import com.company.jobjet.dto.Job;
import com.company.jobjet.viewmodel.JobViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JobService {
    JobDao jobDao;

    @Autowired
    public JobService(JobDao jobDao){
        this.jobDao = jobDao;
    }
    @Transactional
    public JobViewModel addJob(JobViewModel jobViewModel){
        Job job = new Job();
        job.setJobTitle(jobViewModel.getJobTitle());
        job.setJobDescription(jobViewModel.getJobDescription());
        job.setPostedDate(jobViewModel.getPostedDate());
        job.setStatus(jobViewModel.getStatus());

        job = jobDao.addJob(job);
        jobViewModel.setJobId(job.getJobId());
        return jobViewModel;
    }
}
