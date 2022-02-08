package com.ideaco.dia;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirstService {

    //koneksi dengan jobRepository, membuat objek
    private JobRepository jobRepository;
    //membuat konstraktor
    public FirstService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }



    public String sendMessage(String message){
        return "Sending message "+message;
    }

    //fungsi untuk mengambil data job berdasarkan ID
    public JobModel getJobById(int jobId ){
        return jobRepository.findById(jobId).get();
    }

    //mengambil data berdasarkan nama
    public JobModel getJobByName(String jobName){
        return jobRepository.findByJobName(jobName).get();
    }

    //mengambil data berdasarkan salary lebih besar dari
    public List<JobModel> getJobsBySalary(int salary){
        return jobRepository.findByJobSalaryGreaterThan(salary);
    }

    public List<JobModel> findAllJobs(){
        return jobRepository.findAll();
    }

    public JobModel createJob(String jobName, String jobDesc, int jobSalary){
        //validasi apakah nama job alr exists
        JobModel newJob = new JobModel();
        newJob.setJobName(jobName);
        newJob.setJobDesc(jobDesc);
        newJob.setJobSalary(jobSalary);

        return jobRepository.save(newJob);
    }


}
