package com.ideaco.dia;

import javax.persistence.*;

@Entity
@Table(name = "tab_job")
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //ini adalah nama kolom di mysql
    @Column(name = "job_id")
    private int job_id;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_desc")
    private String jobDesc;
    @Column(name = "job_salary")
    private int jobSalary;

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
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
