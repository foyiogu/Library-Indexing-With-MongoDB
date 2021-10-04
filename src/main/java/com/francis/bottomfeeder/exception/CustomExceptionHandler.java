package com.francis.bottomfeeder.exception;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class CustomExceptionHandler {

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(prepareErrorJSON(status, exception), status);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<?> badRequestException(BadRequestException exception){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(prepareErrorJSON(status, exception), status);
    }


    public static String prepareErrorJSON(HttpStatus status, Exception ex) {
        JSONObject errorJSON = new JSONObject();
        try {
            errorJSON.put("status", status.value());
            errorJSON.put("error", status.getReasonPhrase());
            errorJSON.put("message", ex.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorJSON.toString();
    }
}
