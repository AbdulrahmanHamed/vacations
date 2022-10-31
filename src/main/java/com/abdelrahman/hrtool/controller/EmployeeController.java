package com.abdelrahman.hrtool.controller;

import com.abdelrahman.openapi.api.EmployeeApi;
import com.abdelrahman.openapi.model.Balance;
import org.springframework.http.ResponseEntity;

public class EmployeeController implements EmployeeApi {

    @Override
    public ResponseEntity<Balance> getEmployeeVacationsBalance(Integer id) {
        return EmployeeApi.super.getEmployeeVacationsBalance(id);
    }
}
