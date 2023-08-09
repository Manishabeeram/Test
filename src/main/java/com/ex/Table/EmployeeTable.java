package com.ex.Table;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class EmployeeTable {
    @Id
    @Column(name="eid")
    private int eid;
    @Column(name="name")
    private String Name;
    @Column(name="salary")
    private String salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
    
		
	
	
    
}
