package com.cubastion.guna.repo;

import com.cubastion.guna.entity.Employee;
import com.cubastion.guna.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

import static com.cubastion.guna.Utils.QUERIES.*;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

    @Query(value = GET_Q3_QUERY,nativeQuery = true)
    Collection<Map<String, Object>> getq3();

    @Query(value = GET_Q4_QUERY,nativeQuery = true)
    Collection<Map<String, Object>> getq4();



}