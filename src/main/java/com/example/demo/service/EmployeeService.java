package com.example.demo.service;

import com.example.demo.exeption.UserNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;


    public Employee addEmplyee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employeeRepo.save(employee);
        return employee;
    }
    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }
    public Employee updateEmploye(Employee employee){
        return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployerById(id).orElseThrow(()-> new UserNotFoundException("user by id "+id+"was not found"));
    }
    public void deLeteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
