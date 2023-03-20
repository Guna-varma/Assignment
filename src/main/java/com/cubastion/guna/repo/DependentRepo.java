package com.cubastion.guna.repo;

import com.cubastion.guna.entity.Department;
import com.cubastion.guna.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependentRepo extends JpaRepository<Dependent, Integer> {

}
