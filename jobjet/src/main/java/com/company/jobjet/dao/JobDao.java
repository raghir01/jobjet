package com.company.jobjet.dao;

import com.company.jobjet.dto.Job;

import java.util.List;

public interface JobDao {
    Job addJob(Job job);

    Job getJob(int jobId);

    List<Job> getAllJobs();

    Job updateJob(Job job);

    void deleteJob(int jobId);

}
