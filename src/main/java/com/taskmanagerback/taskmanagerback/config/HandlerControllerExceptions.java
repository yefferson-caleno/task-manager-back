package com.taskmanagerback.taskmanagerback.config;

import com.taskmanagerback.taskmanagerback.util.exception.*;
import com.taskmanagerback.taskmanagerback.util.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class HandlerControllerExceptions {

    private String errorToString(ObjectError error) {
        return error.getDefaultMessage();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Response<Object>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().getAllErrors().stream().map(this::errorToString)
                .collect(Collectors.toList());
        Response<Object> response = Response.builder().status(HttpStatus.BAD_REQUEST.value())
                .message("¡Parametros de entrada invalidaos!").errors(errors).build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({RoleNotFoundException.class})
    public ResponseEntity<Response<Object>> handlerRoleNotFoundException(RoleNotFoundException e) {
        Response<Object> response = Response.builder().status(HttpStatus.NOT_FOUND.value()).message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({StateNotFoundException.class})
    public ResponseEntity<Response<Object>> handlerStateNotFoundException (StateNotFoundException e) {
        Response<Object> response = Response.builder().status(HttpStatus.NOT_FOUND.value()).message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({StatusNotFoundException.class})
    public ResponseEntity<Response<Object>> handlerStatusNotFoundException (StatusNotFoundException e) {
        Response<Object> response = Response.builder().status(HttpStatus.NOT_FOUND.value()).message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({TaskNotFoundException.class})
    public ResponseEntity<Response<Object>> handlerTaskNotFoundException (TaskNotFoundException e) {
        Response<Object> response = Response.builder().status(HttpStatus.NOT_FOUND.value()).message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({TeamNotFoundException.class})
    public ResponseEntity<Response<Object>> handlerTeamNotFoundException (TeamNotFoundException e) {
        Response<Object> response = Response.builder().status(HttpStatus.NOT_FOUND.value()).message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Response<Object>> handlerUserNotFoundException (UserNotFoundException e) {
        Response<Object> response = Response.builder().status(HttpStatus.NOT_FOUND.value()).message(e.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
