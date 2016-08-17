package com.pea.it.mysql.service;

import com.pea.it.mysql.domain.Employee;
import com.pea.it.mysql.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by selina on 2016/8/16.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable(value = "emp_cache", key = "''+ #empNo")
    public Employee findById(final Long empNo) {
        return employeeRepository.findOne(empNo);
    }
}
