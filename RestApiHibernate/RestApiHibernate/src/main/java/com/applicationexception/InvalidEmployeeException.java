package com.applicationexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This employee is not found !")
public class InvalidEmployeeException extends Exception {

}
