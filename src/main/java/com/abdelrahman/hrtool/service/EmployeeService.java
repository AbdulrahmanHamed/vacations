package com.abdelrahman.hrtool.service;

import com.abdelrahman.openapi.model.Balance;

import java.time.LocalDate;

public interface EmployeeService {
    Balance getEmployeeVacationsBalance(int id);

    Balance createVacation(int id, String vacationType, LocalDate startDate, LocalDate endDate);
}
