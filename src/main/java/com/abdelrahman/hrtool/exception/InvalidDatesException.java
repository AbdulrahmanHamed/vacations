package com.abdelrahman.hrtool.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid start/end dates")
public class InvalidDatesException extends RuntimeException {

}
