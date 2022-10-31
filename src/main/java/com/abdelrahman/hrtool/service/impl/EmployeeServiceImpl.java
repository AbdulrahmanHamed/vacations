package com.abdelrahman.hrtool.service.impl;

import com.abdelrahman.hrtool.exception.EmployeeNotFoundException;
import com.abdelrahman.hrtool.exception.InvalidDatesException;
import com.abdelrahman.hrtool.exception.InvalidVacationTypeException;
import com.abdelrahman.hrtool.exception.NoAvailableBalanceException;
import com.abdelrahman.hrtool.model.Employee;
import com.abdelrahman.hrtool.repository.EmployeeRepo;
import com.abdelrahman.hrtool.service.EmployeeService;
import com.abdelrahman.openapi.model.Balance;
import com.abdelrahman.openapi.model.Vacation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        balance.setSickness(employee.getRemainingSickness());
        return balance;
    }

    @Override
    public Balance createVacation(int id, String vacationType, LocalDate startDate, LocalDate endDate) {
        Optional<Employee> employeeOptional = employeeRepo.findById((long) id);
        Employee employee = employeeOptional.orElseThrow(EmployeeNotFoundException::new);
        if (startDate.isAfter(endDate))
            throw new InvalidDatesException();
        long requestedDaysCount = ChronoUnit.DAYS.between(startDate, endDate);
        computeVacationBasedOnType(vacationType, employee, requestedDaysCount);
        Balance balance = new Balance();
        balance.setAnnual(employee.getRemainingAnnual());
        balance.setSickness(employee.getRemainingSickness());
        return balance;
    }

    private void computeVacationBasedOnType(String vacationType, Employee employee, long requestedDaysCount) {
        //TODO: Consider weekends
        if (Vacation.TypesEnum.fromValue(vacationType).equals(Vacation.TypesEnum.ANNUAL)) {
            if (requestedDaysCount <= employee.getRemainingAnnual()) {
                employee.setRemainingAnnual((int) (employee.getRemainingAnnual() - requestedDaysCount));
                employeeRepo.save(employee);
            } else {
                throw new NoAvailableBalanceException();
            }
        } else if (Vacation.TypesEnum.fromValue(vacationType).equals(Vacation.TypesEnum.CASUAL)) {
            if (requestedDaysCount <= employee.getRemainingAnnual()) {
                employee.setRemainingAnnual((int) (employee.getRemainingAnnual() - requestedDaysCount));
                employeeRepo.save(employee);
            } else {
                throw new NoAvailableBalanceException();
            }
        } else if (Vacation.TypesEnum.fromValue(vacationType).equals(Vacation.TypesEnum.SICKNESS)) {
            if (requestedDaysCount <= employee.getRemainingSickness()) {
                employee.setRemainingSickness((int) (employee.getRemainingSickness() - requestedDaysCount));
                employeeRepo.save(employee);
            } else {
                throw new NoAvailableBalanceException();
            }
        } else {
            throw new InvalidVacationTypeException();
        }
    }
}
