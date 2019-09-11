package com.company.jobjet.service;

import com.company.jobjet.dao.JobDao;
import com.company.jobjet.dto.Job;
import com.company.jobjet.viewmodel.JobViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public JobViewModel getJob(int jobId){
        Job job = jobDao.getJob(jobId);
        JobViewModel jobViewModel = new JobViewModel();
        jobViewModel.setJobId(job.getJobId());
        jobViewModel.setJobDescription(job.getJobDescription());
        jobViewModel.setPostedDate(job.getPostedDate());
        jobViewModel.setStatus(job.getStatus());

        return jobViewModel;
    }

    public List<JobViewModel> getAllJobs(){
        List<Job> jobList = jobDao.getAllJobs();
        List<JobViewModel> jobViewModelList = new ArrayList<>();
        for(Job job : jobList){
            JobViewModel jobViewModel = new JobViewModel();
            jobViewModel.setJobId(job.getJobId());
            jobViewModel.setJobTitle(job.getJobTitle());
            jobViewModel.setJobDescription(job.getJobDescription());
            jobViewModel.setPostedDate(job.getPostedDate());
            jobViewModel.setStatus(job.getStatus());

            jobViewModelList.add(jobViewModel);
        }
        return jobViewModelList;
    }


    public JobViewModel updateJob(JobViewModel jobViewModel){
        Job job = new Job();
        job.setJobTitle(jobViewModel.getJobTitle());
        job.setJobDescription(jobViewModel.getJobDescription());
        job.setPostedDate(jobViewModel.getPostedDate());
        job.setStatus(jobViewModel.getStatus());
        job.setJobId(jobViewModel.getJobId());
        jobDao.updateJob(job);
        return jobViewModel;
    }

    public void deleteJob(int jobId){
        jobDao.deleteJob(jobId);
    }
}
