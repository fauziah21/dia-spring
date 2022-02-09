package com.ideaco.dia.dto;

public class JobDTO {
    private String jobName;
    private int jobSalary;

    public JobDTO(String jobName, int jobSalary) {
        this.jobName = jobName;
        this.jobSalary = jobSalary;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(int jobSalary) {
        this.jobSalary = jobSalary;
    }
}
