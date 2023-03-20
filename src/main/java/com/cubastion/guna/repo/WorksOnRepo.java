package com.cubastion.guna.repo;

import com.cubastion.guna.entity.Project;
import com.cubastion.guna.entity.WorksOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorksOnRepo extends JpaRepository<WorksOn, Integer> {

}
