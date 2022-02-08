package com.ideaco.dia;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class FirstController {

    private FirstService firstService;

    public FirstController(FirstService firstService){
        this.firstService = firstService;
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello Wolrd";
    }

    @GetMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message){
        return firstService.sendMessage(message);
    }

    //get data by id
    @GetMapping("/job/{jobId}")
    public JobModel getJob(@PathVariable("jobId") int jobId){
        return firstService.getJobById(jobId);
    }

    //get data by name
    @GetMapping("/job/name/{jobName}")
    public JobModel getJobByName(@PathVariable("jobName") String jobName){
        return firstService.getJobByName(jobName);
    }

    //get data by salary greater than
    @GetMapping("/job/salary/{salary}")
    public List<JobModel> getJobBySalary(@PathVariable("salary") int salary){
        return firstService.getJobsBySalary(salary);
    }

    @GetMapping("/jobs")
    public List<JobModel> getAllJobs(){
        return firstService.findAllJobs();
    }

    @PostMapping("/job")
    public JobModel createJob(@RequestParam("jobName") String jobName,
                              @RequestParam("jobDesc") String jobDesc,
                              @RequestParam("jobSalary") int jobSalary){
        return firstService.createJob(jobName, jobDesc, jobSalary);
    }
}
