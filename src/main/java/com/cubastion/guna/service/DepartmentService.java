package com.cubastion.guna.service;

import com.cubastion.guna.csv.CsvHelperDepartment;
import com.cubastion.guna.csv.CsvHelperEmployee;
import com.cubastion.guna.entity.Department;
import com.cubastion.guna.entity.Employee;
import com.cubastion.guna.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    public Collection<Map<String, Object>> getq1() {

        return (Collection<Map<String, Object>>) repo.getq1();
    }

    public Collection<Map<String,Object>> getq2() {
        return repo.getq2();
    }

    public void save(MultipartFile file) {

        try {
            List<Department> departmentList = CsvHelperDepartment.csvToDepartment(file.getInputStream());
            repo.saveAll(departmentList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

}
