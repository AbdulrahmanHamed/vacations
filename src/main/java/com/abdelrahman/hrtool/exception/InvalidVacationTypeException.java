package com.abdelrahman.hrtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid vacation type")
public class InvalidVacationTypeException extends RuntimeException {

}
