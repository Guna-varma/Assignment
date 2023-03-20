package com.cubastion.guna.service;

import com.cubastion.guna.csv.CsvHelperEmployee;
import com.cubastion.guna.entity.Employee;
import com.cubastion.guna.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    public void save(MultipartFile file) {

        try {
            List<Employee> tutorials = CsvHelperEmployee.csvToEmployee(file.getInputStream());
            repo.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public Collection<Map<String, Object>> getq5() {
        return repo.getq5();
    }
}
