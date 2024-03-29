package com.codegym.cms.service;

import com.codegym.cms.model.Employee;
import com.codegym.cms.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByNameDeparment(String name, Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void remove(Long id);

    Iterable<Employee> findAllByDeparment(Department department);
}