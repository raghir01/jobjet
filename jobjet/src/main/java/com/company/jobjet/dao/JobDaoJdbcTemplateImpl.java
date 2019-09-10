package com.company.jobjet.dao;

import com.company.jobjet.dto.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JobDaoJdbcTemplateImpl implements JobDao{

    // Constructor
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobDaoJdbcTemplateImpl(JdbcTemplate newjdbcTemplate){
        this.jdbcTemplate = newjdbcTemplate;
    }

    //Prepared Statement
    private static final String INSERT_JOB_SQL =
            "insert into job (job_title, job_description, posted_date, status) values (?, ?, ?, ?)";

    private static final String SELECT_JOB_SQL =
            "select * from job where job_id = ?";

    private static final String SELECT_ALL_JOB_SQL =
            "select * from job";

    private static final String DELETE_JOB_SQL =
            "delete from job where job_id = ?";

    private static final String UPDATE_JOB_SQL =
            "update job set job_title = ?, job_description = ?, posted_date = ?, status = ? where job_id = ?";

    //Mapper
    private Job mapRowToJob(ResultSet rs, int rowNum) throws SQLException {
        Job job = new Job();
        job.setJobId(rs.getInt("job_id"));
        job.setJobTitle(rs.getString("job_title"));
        job.setJobDescription(rs.getString("job_description"));
        job.setPostedDate(rs.getDate("posted_date").toLocalDate());
        job.setStatus(rs.getString("status"));

        return job;
    }

    //Implementations
    @Override
    @Transactional
    public Job addJob(Job job) {
        jdbcTemplate.update(
                INSERT_JOB_SQL,
                job.getJobTitle(),
                job.getJobDescription(),
                job.getPostedDate(),
                job.getStatus());

        int id = jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        job.setJobId(id);
        return job;
    }

    @Override
    public Job getJob(int jobId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_JOB_SQL, this::mapRowToJob, jobId);
        } catch (EmptyResultDataAccessException e){
            // if there is no match for this job id, return null
            return null;
        }
    }

    @Override
    public List<Job> getAllJobs() {
        return jdbcTemplate.query(SELECT_ALL_JOB_SQL, this::mapRowToJob);

    }

    @Override
    public Job updateJob(Job job) {
        jdbcTemplate.update(
                UPDATE_JOB_SQL,
                job.getJobTitle(),
                job.getJobDescription(),
                job.getPostedDate(),
                job.getStatus(),
                job.getJobId());
        return job;
    }

    @Override
    public void deleteJob(int jobId) {
        jdbcTemplate.update(DELETE_JOB_SQL, jobId);

    }
}
