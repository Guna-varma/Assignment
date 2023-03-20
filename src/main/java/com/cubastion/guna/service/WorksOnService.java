package com.cubastion.guna.service;

import com.cubastion.guna.csv.CsvHelperDeptLocations;
import com.cubastion.guna.csv.CsvHelperWorksOn;
import com.cubastion.guna.entity.DeptLocations;
import com.cubastion.guna.entity.WorksOn;
import com.cubastion.guna.repo.DeptLocationsRepo;
import com.cubastion.guna.repo.WorksOnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class WorksOnService {

    @Autowired
    private WorksOnRepo repo;

    public void save(MultipartFile file) {
        try {
            List<WorksOn> worksOnList = CsvHelperWorksOn.csvToWorksOn(file.getInputStream());
            repo.saveAll(worksOnList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
