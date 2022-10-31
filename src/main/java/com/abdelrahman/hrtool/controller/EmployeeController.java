package com.abdelrahman.hrtool.controller;

import com.abdelrahman.hrtool.service.EmployeeService;
import com.abdelrahman.openapi.api.EmployeeApi;
import com.abdelrahman.openapi.model.Balance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
@RestController
public class EmployeeController implements EmployeeApi {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<Balance> getEmployeeVacationsBalance(Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeeVacationsBalance(id));
    }

    @Override
    public ResponseEntity<Balance> createEmployeeVacation(Integer id, String vacationType, LocalDate start, LocalDate end) {
        return ResponseEntity.created(null).body(employeeService.createVacation(id,vacationType,start,end));
    }
}
