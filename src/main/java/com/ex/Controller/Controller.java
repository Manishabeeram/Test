package com.ex.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ex.Services.Services;
import com.ex.Table.EmployeeTable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class Controller {
    private final Services employeeService;

    @Autowired
    public Controller(Services employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeTable>> getAllEmployees() {
        List<EmployeeTable> employees = employeeService.getAllEmployees();
        return new ResponseEntity<List<EmployeeTable>>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeTable> getEmployeeById(@PathVariable int id) {
        Optional<EmployeeTable> employee = employeeService.getEmployeeById(id);
        return (ResponseEntity<EmployeeTable>) employee.map(value -> new ResponseEntity<EmployeeTable>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<EmployeeTable>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<EmployeeTable> createEmployee(@RequestBody EmployeeTable employee) {
    	EmployeeTable savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<EmployeeTable>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeTable> updateEmployee(@PathVariable int id, @RequestBody EmployeeTable employee) {
        if (!employeeService.getEmployeeById(id).isPresent()) {
            return new ResponseEntity<EmployeeTable>(HttpStatus.NOT_FOUND);
        }
        employee.setEid(id);
        EmployeeTable updatedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<EmployeeTable>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        if (!employeeService.getEmployeeById(id).isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}

