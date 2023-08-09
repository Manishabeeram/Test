package com.ex.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.Table.EmployeeTable;



@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTable, Integer> {
}

