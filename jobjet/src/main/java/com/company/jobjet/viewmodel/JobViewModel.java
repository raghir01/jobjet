package com.company.jobjet.viewmodel;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Objects;

public class JobViewModel {
    private int jobId;
    @NotEmpty(message = "JobTitle cannot be empty.")
    private String jobTitle;
    @NotEmpty(message = "JobDescription cannot be empty.")
    private String jobDescription;
    @NotEmpty(message = "PostedDate cannot be empty.")
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
        JobViewModel that = (JobViewModel) o;
        return jobId == that.jobId &&
                Objects.equals(jobTitle, that.jobTitle) &&
                Objects.equals(jobDescription, that.jobDescription) &&
                Objects.equals(postedDate, that.postedDate) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobTitle, jobDescription, postedDate, status);
    }
}
