package com.cubastion.guna.controller;

import com.cubastion.guna.csv.CsvHelperDepartment;
import com.cubastion.guna.csv.ResponseMessage;
import com.cubastion.guna.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping("/upload-data-department")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CsvHelperDepartment.hasCSVFormat(file)) {
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

    @GetMapping("/q1")
    private Collection<Map<String, Object>> q1() {
        return (Collection<Map<String, Object>>) service.getq1();
    }

    @GetMapping("/q2")
    private Collection<Map<String, Object>> q2() {
        return (Collection<Map<String, Object>>) service.getq2();
    }

}
