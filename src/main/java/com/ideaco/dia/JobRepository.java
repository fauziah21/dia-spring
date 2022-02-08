package com.ideaco.dia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//JobModel -> model yang kita buat, Integer -> tipe data primary key dari si JobModel
public interface JobRepository extends JpaRepository<JobModel, Integer> {
    //mencari data berdasarkan nama
    Optional<JobModel> findByJobName(String jobName);

    //mencari data berdasarkan salary
    List<JobModel> findByJobSalaryGreaterThan(int salary);
}
