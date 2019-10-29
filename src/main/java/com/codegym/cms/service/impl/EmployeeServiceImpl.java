package com.codegym.cms.service.impl;

import com.codegym.cms.model.Employee;
import com.codegym.cms.model.Department;
import com.codegym.cms.repository.EmployeeRepository;
import com.codegym.cms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByNameDeparment(String name, Pageable pageable) {
        return employeeRepository.findAllByNameDepartment(name, pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public Iterable<Employee> findAllByDeparment(Department department) {
        return employeeRepository.findAllByDepartment(department);
    }

}


