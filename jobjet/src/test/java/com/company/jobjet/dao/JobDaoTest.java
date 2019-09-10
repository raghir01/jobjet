package com.company.jobjet.dao;

import com.company.jobjet.dto.Job;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JobDaoTest {

    @Autowired
    JobDao jobDao;

    @Before
    public void setUp() throws Exception {
        List<Job> jobList = jobDao.getAllJobs();
        for(Job job : jobList){
            jobDao.deleteJob(job.getJobId());
        }
    }

    @Test
    public void addJob() {
        Job job = new Job();
        job.setJobTitle("Java Developer");
        job.setJobDescription("Junior Level");
        job.setPostedDate(LocalDate.of(2018,01,20));
        job.setStatus("Available");
        job = jobDao.addJob(job);

        Job job1 = jobDao.getJob(job.getJobId());
        assertEquals(job1, job);
    }

    @Test
    public void getJob() {
        Job job1 = new Job();
        job1.setJobTitle("Java Developer");
        job1.setJobDescription("Junior Level");
        job1.setPostedDate(LocalDate.of(2018,01,20));
        job1.setStatus("Available");
        job1 = jobDao.addJob(job1);

        Job job2 = new Job();
        job2.setJobTitle("Python Developer");
        job2.setJobDescription("Mid Level");
        job2.setPostedDate(LocalDate.of(2018,01,20));
        job2.setStatus("Available");
        job2 = jobDao.addJob(job2);

        Job job3 = jobDao.getJob(job1.getJobId());
        assertEquals(job1, job3);
        job3 = jobDao.getJob(job2.getJobId());
        assertEquals(job2, job3);
    }

    @Test
    public void getAllJobs() {
        Job job1 = new Job();
        job1.setJobTitle("Java Developer");
        job1.setJobDescription("Junior Level");
        job1.setPostedDate(LocalDate.of(2018,01,20));
        job1.setStatus("Available");
        job1 = jobDao.addJob(job1);

        Job job2 = new Job();
        job2.setJobTitle("Python Developer");
        job2.setJobDescription("Mid Level");
        job2.setPostedDate(LocalDate.of(2018,01,20));
        job2.setStatus("Available");
        job2 = jobDao.addJob(job2);

        List<Job> jobList = jobDao.getAllJobs();
        assertEquals(jobList.size(), 2);
    }

    @Test
    public void updateJob() {
        Job job = new Job();
        job.setJobTitle("Java Developer");
        job.setJobDescription("Junior Level");
        job.setPostedDate(LocalDate.of(2018,01,20));
        job.setStatus("Available");
        job = jobDao.addJob(job);

        job.setJobTitle("Junior Java Developer");
        job.setStatus("Not Available");
        jobDao.updateJob(job);

        Job job1 = jobDao.getJob(job.getJobId());
        assertEquals(job1, job);
    }

    @Test
    public void deleteJob() {
        Job job = new Job();
        job.setJobTitle("Java Developer");
        job.setJobDescription("Junior Level");
        job.setPostedDate(LocalDate.of(2018,01,20));
        job.setStatus("Available");
        job = jobDao.addJob(job);

        jobDao.deleteJob(job.getJobId());
        Job job1 = jobDao.getJob(job.getJobId());
        assertNull(job1);
    }
}