package com.cubastion.guna.controller;

import com.cubastion.guna.csv.CsvHelperEmployee;
import com.cubastion.guna.csv.ResponseMessage;
import com.cubastion.guna.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/upload-data-employee")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CsvHelperEmployee.hasCSVFormat(file)) {
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

    @GetMapping("/q5")
    private Collection<Map<String, Object>> getq5(){
        return service.getq5();
    }


}
