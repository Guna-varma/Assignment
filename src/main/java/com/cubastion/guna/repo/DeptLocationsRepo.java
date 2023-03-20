package com.cubastion.guna.repo;

import com.cubastion.guna.entity.Dependent;
import com.cubastion.guna.entity.DeptLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptLocationsRepo extends JpaRepository<DeptLocations, Integer> {

}
