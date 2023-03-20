package com.cubastion.guna.service;

import com.cubastion.guna.csv.CsvHelperDeptLocations;
import com.cubastion.guna.entity.DeptLocations;
import com.cubastion.guna.repo.DeptLocationsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DeptLocationsService {

    @Autowired
    private DeptLocationsRepo repo;

    public void save(MultipartFile file) {
        try {
            List<DeptLocations> deptLocationsList = CsvHelperDeptLocations.csvToDeptLocation(file.getInputStream());
            repo.saveAll(deptLocationsList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
