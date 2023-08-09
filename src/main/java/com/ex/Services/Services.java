package com.ex.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.Repository.EmployeeRepository;
import com.ex.Table.EmployeeTable;

import java.util.List;
import java.util.Optional;

@Service
public class Services {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public Services(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeTable> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeTable> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public EmployeeTable saveEmployee(EmployeeTable employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

}

