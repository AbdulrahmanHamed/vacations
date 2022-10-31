package com.abdelrahman.hrtool.service.impl;

import com.abdelrahman.hrtool.service.VacationService;
import com.abdelrahman.openapi.model.Vacation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacationServiceImpl implements VacationService {

    @Override
    public Vacation getVacation() {
        Vacation vacation =new Vacation();
        vacation.setTypes(List.of(Vacation.TypesEnum.values()));
        return vacation;
    }
}
