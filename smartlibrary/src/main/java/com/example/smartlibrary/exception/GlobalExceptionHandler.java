package com.example.smartlibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourseNotFoundException(ResourceNotFoundException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("statusCode", HttpStatus.NOT_FOUND.value());
        return "error";
    }
    @ExceptionHandler(BusinessException.class)
    public String handleBusinessException(BusinessException e, Model model){
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("statusCode", HttpStatus.BAD_REQUEST.value());
        return "error";
    }
//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e, Model model){
//        model.addAttribute("errorMessage", e.getMessage());
//        model.addAttribute("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
//        return "error";
//    }
}
