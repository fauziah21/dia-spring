package com.ideaco.dia.service;

import com.ideaco.dia.dto.JobDTO;
import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FirstService {

    //koneksi dengan jobRepository, membuat objek
    @Autowired
    private JobRepository jobRepository;
    //membuat konstraktor
//


    public String sendMessage(String message){
        return "Sending message "+message;
    }

    //fungsi untuk mengambil data job berdasarkan ID
//    public JobModel getJobById(int jobId ){
//        return jobRepository.findById(jobId).get();
//    }

    public JobDTO getJobById(int jobId){
        return convertJob(jobRepository.findById(jobId).get());
    }

    private JobDTO convertJob(JobModel jobModel){
        return new JobDTO(jobModel.getJobName(), jobModel.getJobSalary());
    }

    //mengambil data berdasarkan nama
    public JobModel getJobByName(String jobName){
        Optional<JobModel> jobOpt = jobRepository.findByJobName(jobName);
        if (jobOpt.isEmpty()){
            return null;
        }
        return jobOpt.get();
    }

    //mengambil data berdasarkan salary lebih besar dari
    public List<JobModel> getJobsBySalary(int salary){
        return jobRepository.findByJobSalaryGreaterThan(salary);
    }

    public List<JobDTO> findAllJobs(){
        List<JobModel> jobModels = jobRepository.findAll();
        return jobModels.stream().map(this::convertJob)
                .collect(Collectors.toList());
    }

    public JobModel createJob(String jobName, String jobDesc, int jobSalary){
        //validasi apakah nama job alr exists
        JobModel newJob = new JobModel();
        newJob.setJobName(jobName);

    newJob.setJobDesc(jobDesc);
        newJob.setJobSalary(jobSalary);

        return jobRepository.save(newJob);
    }

    public JobModel createJobWithBody(JobModel jobModel){
        return jobRepository.save(jobModel);
    }

    public JobModel getJobBySalaryAndName(String jobName, int salary){
        Optional<JobModel> jobOpt = jobRepository.findByJobNameAndJobSalary(jobName, salary);

        if (jobOpt.isEmpty()){
            return null;
        }

        return jobOpt.get();
    }

    public List<JobModel> searchJob(String jobName){
        return jobRepository.searchJob(jobName);
    }

    public List<JobModel> filterJob(int jobSalary){
        return jobRepository.filterJob(jobSalary);
    }

    public JobModel updateJob(int jobId, JobModel jobModel){
        Optional<JobModel> currentJobOpt = jobRepository.findById(jobId);

        if (currentJobOpt.isEmpty()){
            return null;
        }

        return jobRepository.save(jobModel);
    }

    public JobModel updateJobName(int jobId, String jobName){
        Optional<JobModel> currentJobOpt = jobRepository.findById(jobId);

        if (currentJobOpt.isEmpty()){
            return null;
        }

        JobModel currentJob = currentJobOpt.get();
        currentJob.setJobName(jobName);

        return jobRepository.save(currentJob);
    }

    public boolean deleteJob(int jobId){
        Optional<JobModel> currentJobOpt = jobRepository.findById(jobId);

        if (currentJobOpt.isEmpty()){
            return false;
        }

        jobRepository.deleteById(jobId);
//        jobRepository.delete(currentJobOpt.get());
        return true;
    }


}
