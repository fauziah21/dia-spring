package com.ideaco.dia.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_job")
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ini adalah nama kolom di mysql
    @Column(name = "job_id")
    private int jobId;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_desc")
    private String jobDesc;
    @Column(name = "job_salary")
    private int jobSalary;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public int getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(int jobSalary) {
        this.jobSalary = jobSalary;
    }
}
