package com.ideaco.dia.controller;

import com.ideaco.dia.dto.JobDTO;
import com.ideaco.dia.model.JobModel;
import com.ideaco.dia.response.DataResponse;
import com.ideaco.dia.response.HandlerResponse;
import com.ideaco.dia.service.FirstService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public JobDTO getJob(@PathVariable("jobId") int jobId){
        return firstService.getJobById(jobId);
    }

    //get data by name
    @GetMapping("/job/name/{jobName}")
    public JobModel getJobByName(@PathVariable("jobName") String jobName){
        JobModel jobByName = firstService.getJobByName(jobName);
        if (jobByName != null){
            return jobByName;
        }else{
            return new JobModel();
        }
    }

    //get data by salary greater than
    @GetMapping("/job/salary/{salary}")
    public List<JobModel> getJobBySalary(@PathVariable("salary") int salary){
        return firstService.getJobsBySalary(salary);
    }

    @GetMapping("/jobs")
    public List<JobDTO> getAllJobs(){
        return firstService.findAllJobs();
    }

    @PostMapping("/job")
    public JobModel createJob(@RequestParam("jobName") String jobName,
                              @RequestParam("jobDesc") String jobDesc,
                              @RequestParam("jobSalary") int jobSalary){
        return firstService.createJob(jobName, jobDesc, jobSalary);
    }

    @PostMapping("/job/body")
    public JobModel createJobWithBody(@RequestBody JobModel jobModel){
        return firstService.createJobWithBody(jobModel);
    }

    @GetMapping("/job/name/salary")
    public JobModel getJobByNameAndSalary(@RequestParam("jobName") String jobName,
                                          @RequestParam("jobSalary") int jobSalary){
        JobModel jobByName = firstService.getJobBySalaryAndName(jobName, jobSalary);
        if (jobByName != null){
            return jobByName;
        }else{
            return new JobModel();
        }
    }

    @GetMapping("/job/search")
    public List<JobModel> searchJob(@RequestParam("jobName") String jobName){
        return firstService.searchJob(jobName);
    }

    @GetMapping("/job/filter")
    public List<JobModel> filterJob(@RequestParam("jobSalary") int jobSalary){
        return firstService.filterJob(jobSalary);
    }

    @PutMapping("/job/{jobId}")
    public JobModel updateJob(@PathVariable("jobId") int jobId,
                              @RequestBody JobModel jobModel){
        JobModel updatedJob = firstService.updateJob(jobId, jobModel);
        if (updatedJob != null){
            return updatedJob;
        }else{
            return new JobModel();
        }
    }

    @PatchMapping("/job/update")
    public JobModel updateJobName(@RequestParam("jobId") int jobId,
                                  @RequestParam("jobName") String jobName){
        JobModel updatedJob = firstService.updateJobName(jobId, jobName);
        if (updatedJob != null){
            return updatedJob;
        }else{
            return new JobModel();
        }
    }

    @DeleteMapping("/job/{jobId}")
    public boolean deleteJob(@PathVariable("jobId") int jobId){
        return firstService.deleteJob(jobId);
    }

    @GetMapping("/job/response")
    public void getJobWithResponse(HttpServletResponse request, HttpServletResponse response,
                                   @RequestParam("jobId") int jobId){
        JobDTO jobDTO = firstService.getJobById(jobId);

        DataResponse<JobDTO> data = new DataResponse<>();
        data.setData(jobDTO);
        HandlerResponse.responseSuccessWithData(response, data);

//        HandlerResponse.responseBadRequest(response, "001", "Job Id not found");
//        HandlerResponse.responseInternalServerError(response, "Something wrong");
//        HandlerResponse.responseSuccessOK(response, "success get job");
//        HandlerResponse.responseUnauthorized(response, "user not authorized");
    }


}
