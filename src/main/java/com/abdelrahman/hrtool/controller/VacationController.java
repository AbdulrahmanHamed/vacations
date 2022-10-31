package com.abdelrahman.hrtool.controller;

import com.abdelrahman.hrtool.service.VacationService;
import com.abdelrahman.openapi.api.VacationApi;
import com.abdelrahman.openapi.model.Vacation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationController implements VacationApi {

    private final VacationService vacationService;

    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @Override
    public ResponseEntity<Vacation> getVacationTypes() {
        return ResponseEntity.ok(vacationService.getVacation());
    }
}
