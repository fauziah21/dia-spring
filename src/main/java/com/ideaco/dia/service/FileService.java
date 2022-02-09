package com.ideaco.dia.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private final Path root = Paths.get("D:\\Upload");

    public boolean saveFile(MultipartFile file){
        try {
            //kalau folder belum exists, create folder dulu
            if(!Files.exists(root)){
                Files.createDirectory(root);
            }

            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));

            return true;

        }catch (Exception e){
            return false;
        }

    }
}
