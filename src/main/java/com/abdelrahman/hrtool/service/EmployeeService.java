package com.abdelrahman.hrtool.service;

import com.abdelrahman.openapi.model.Balance;

public interface EmployeeService {
    Balance getEmployeeVacationsBalance(int id);
}
