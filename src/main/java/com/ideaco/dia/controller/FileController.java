package com.ideaco.dia.controller;

import com.ideaco.dia.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public boolean uploadFile(@RequestParam("file")MultipartFile file){
        return fileService.saveFile(file);
    }
}
