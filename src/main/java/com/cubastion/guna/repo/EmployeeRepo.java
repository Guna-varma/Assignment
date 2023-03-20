package com.cubastion.guna.repo;

import com.cubastion.guna.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

import static com.cubastion.guna.Utils.QUERIES.*;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

    @Query(value = GET_Q5_QUERY,nativeQuery = true)
    Collection<Map<String, Object>> getq5();

}
