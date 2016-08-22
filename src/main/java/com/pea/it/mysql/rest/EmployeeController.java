package com.pea.it.mysql.rest;

import com.pea.it.mysql.domain.Employee;
import com.pea.it.mysql.service.EmployeeService;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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
        long l = RandomUtils.nextLong(10000, 310000);
        return employeeService.findById(empNo);
    }

    @RequestMapping(value = "/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee getRandomEmp() {
        long empNo = RandomUtils.nextLong(10000, 310000);
        return employeeService.findById(empNo);
    }

    public static void main(String[] args) {
        System.out.println(RandomUtils.nextLong(10000, 310000));
    }
}
