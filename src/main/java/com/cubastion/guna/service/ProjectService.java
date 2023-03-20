package com.cubastion.guna.service;

import com.cubastion.guna.csv.CsvHelperEmployee;
import com.cubastion.guna.csv.CsvHelperProject;
import com.cubastion.guna.entity.Employee;
import com.cubastion.guna.entity.Project;
import com.cubastion.guna.repo.DeptLocationsRepo;
import com.cubastion.guna.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo repo;

    public void save(MultipartFile file) {

        try {
            List<Project> projectList = CsvHelperProject.csvToProject(file.getInputStream());
            repo.saveAll(projectList);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public Collection<Map<String, Object>> getq3() {
        return repo.getq3();
    }

    public Collection<Map<String, Object>> getq4() {
        return repo.getq4();
    }
}
