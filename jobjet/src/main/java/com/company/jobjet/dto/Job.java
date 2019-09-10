package com.company.jobjet.dto;

import java.time.LocalDate;
import java.util.Objects;

public class Job {
    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private LocalDate postedDate;
    private String status;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return jobId == job.jobId &&
                Objects.equals(jobTitle, job.jobTitle) &&
                Objects.equals(jobDescription, job.jobDescription) &&
                Objects.equals(postedDate, job.postedDate) &&
                Objects.equals(status, job.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobTitle, jobDescription, postedDate, status);
    }
}

