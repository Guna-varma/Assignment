package com.cubastion.guna.service;

import com.cubastion.guna.csv.CsvHelperDependant;
import com.cubastion.guna.csv.CsvHelperDeptLocations;
import com.cubastion.guna.entity.Dependent;
import com.cubastion.guna.entity.DeptLocations;
import com.cubastion.guna.repo.DependentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DependentService {

    @Autowired
    private DependentRepo repo;


    public void save(MultipartFile file) {
        try {
            List<Dependent> dependentList = CsvHelperDependant.csvToDependent(file.getInputStream());
            repo.saveAll(dependentList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
