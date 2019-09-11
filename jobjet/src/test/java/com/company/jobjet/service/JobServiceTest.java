package com.company.jobjet.service;

import com.company.jobjet.dao.JobDao;
import com.company.jobjet.dao.JobDaoJdbcTemplateImpl;
import com.company.jobjet.dto.Job;
import com.company.jobjet.viewmodel.JobViewModel;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class JobServiceTest {

    JobService jobService;
    JobDao jobDao;

    @Before
    public void setUp() throws Exception{
        setUpJobDaoMock();

        jobService = new JobService(jobDao);
    }

    @Test
    public void saveFindUpdateJob() {
        JobViewModel jvm = new JobViewModel();
        jvm.setJobTitle("Java Developer");
        jvm.setJobDescription("Java Microservice");
        jvm.setPostedDate(LocalDate.of(2019, 8,3));
        jvm.setStatus("Available");

        //Add Job
        jvm = jobService.addJob(jvm);

        //Find Job
        JobViewModel jobFromService = jobService.getJob(jvm.getJobId());

        assertEquals(jvm, jobFromService);

        //Update Job
        jvm.setStatus("Not Available");
        JobViewModel updatedJobFromService = jobService.updateJob(jvm);

        assertEquals(jvm, updatedJobFromService);
    }


    private void setUpJobDaoMock() {
        jobDao = mock(JobDaoJdbcTemplateImpl.class);

        //Request Job
        Job job0 = new Job();
        job0.setJobTitle("Java Developer");
        job0.setJobDescription("Java Microservice");
        job0.setPostedDate(LocalDate.of(2019, 8,3));
        job0.setStatus("Available");

        //Response Job
        Job job1 = new Job();
        job1.setJobTitle("Java Developer");
        job1.setJobDescription("Java Microservice");
        job1.setPostedDate(LocalDate.of(2019, 8,3));
        job1.setStatus("Available");
        job1.setJobId(21);

        //Updated Job
        Job job1Updated = new Job();
        job1Updated.setJobTitle("Java Developer");
        job1Updated.setJobDescription("Java Springboot");
        job1Updated.setPostedDate(LocalDate.of(2019, 8,3));
        job1Updated.setStatus("Available");
        job1Updated.setJobId(21);

        //Adding 2nd Job
        Job job2 = new Job();
        job2.setJobTitle("Python Developer");
        job2.setJobDescription("Java Microservice");
        job2.setPostedDate(LocalDate.of(2019, 8,3));
        job2.setStatus("Available");
        job2.setJobId(22);

        List<Job> jobs = new ArrayList<>();

        jobs.add(job1);
        jobs.add(job2);

        doReturn(job1).when(jobDao).addJob(job0);
        doReturn(job1).when(jobDao).getJob(21);
        doReturn(job1Updated).when(jobDao).updateJob(job1Updated);
        doReturn(jobs).when(jobDao).getAllJobs();
    }
}