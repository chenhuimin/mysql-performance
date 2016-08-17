package com.pea.it.mysql.rest;

import com.pea.it.mysql.domain.Employee;
import com.pea.it.mysql.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by selina on 2016/8/17.
 */
@RestController
@RequestMapping("/rest/v1/emp")
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/{empNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee getById(@PathVariable("empNo") Long empNo) {
        return employeeService.findById(empNo);
    }
}
