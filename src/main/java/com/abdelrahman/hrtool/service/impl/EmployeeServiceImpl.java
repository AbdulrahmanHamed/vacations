package com.abdelrahman.hrtool.service.impl;

import com.abdelrahman.hrtool.exception.EmployeeNotFoundException;
import com.abdelrahman.hrtool.model.Employee;
import com.abdelrahman.hrtool.repository.EmployeeRepo;
import com.abdelrahman.hrtool.service.EmployeeService;
import com.abdelrahman.openapi.model.Balance;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @Override
    public Balance getEmployeeVacationsBalance(int id) {
        Optional<Employee> employeeOptional = employeeRepo.findById((long) id);
        Employee employee = employeeOptional.orElseThrow(EmployeeNotFoundException::new);
        Balance balance = new Balance();
        balance.setAnnual(employee.getRemainingAnnual());
        balance.setSickness(employee.getGetRemainingSickness());
        return balance;
    }
}
