package com.hellokoding.account.service;

import com.hellokoding.account.model.Employee;

public interface EmployeeService {
    void save(Employee emp);

    Employee findById(long id);
}
