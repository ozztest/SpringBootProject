package com.example.repository;

import com.example.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ozgen.gures on 05.04.2017.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
