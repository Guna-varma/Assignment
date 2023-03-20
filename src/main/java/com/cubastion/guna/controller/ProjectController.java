package com.cubastion.guna.controller;

import com.cubastion.guna.csv.CsvHelperProject;
import com.cubastion.guna.csv.ResponseMessage;
import com.cubastion.guna.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/upload-data-project")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CsvHelperProject.hasCSVFormat(file)) {
            try {
                service.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));

    }

    @GetMapping("/q3")
    private Collection<Map<String,Object>> getq3(){
        return service.getq3();
    }

    @GetMapping("/q4")
    private Collection<Map<String, Object>> getq4(){
        return service.getq4();
    }

}
