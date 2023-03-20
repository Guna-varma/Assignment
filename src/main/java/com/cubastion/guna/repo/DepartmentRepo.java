package com.cubastion.guna.repo;

import com.cubastion.guna.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

import static com.cubastion.guna.Utils.QUERIES.*;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    @Query(value = GET_Q1_QUERY,nativeQuery = true)
    Collection<Map<String, Object>> getq1();

    @Query(value = GET_Q2_QUERY,nativeQuery = true)
    Collection<Map<String, Object>> getq2();

}
