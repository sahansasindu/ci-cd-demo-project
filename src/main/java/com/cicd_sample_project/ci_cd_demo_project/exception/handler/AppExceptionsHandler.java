package com.cicd_sample_project.ci_cd_demo_project.exception.handler;

import com.cicd_sample_project.ci_cd_demo_project.exception.dto.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Log4j2
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { CustomServiceException.class })
    public ResponseEntity<ErrorMessageResponse> handleServiceException(CustomServiceException ex,
            WebRequest webRequest) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorMessageResponse(false, ex.getMessage(), ex.getCode()), HttpStatus.OK);
    }

    @ExceptionHandler(value = { OtpValidException.class })
    public ResponseEntity<ErrorMessageResponse> handleOtpException(OtpValidException ex, WebRequest webRequest) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorMessageResponse(true, ex.getMessage(), ex.getCode()), HttpStatus.OK);
    }

    @ExceptionHandler(value = { CustomAuthenticationException.class })
    public ResponseEntity<ErrorMessageResponse> handleAuthenticationException(CustomAuthenticationException ex,
            WebRequest webRequest) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ErrorMessageResponse(false, ex.getMessage(), HttpStatus.UNAUTHORIZED.value()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<?> handleAllExceptions(MethodArgumentTypeMismatchException ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ErrorMessageResponse(false, ex.getMessage(), HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST);
    }

//    @Override
//    public ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ex.printStackTrace();
//        return new ResponseEntity<>(new ErrorMessageResponse(false, ex.getMessage(), HttpStatus.BAD_REQUEST.value()),
//                HttpStatus.BAD_REQUEST);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
//            HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ex.printStackTrace();
//        return new ResponseEntity<>(new ErrorMessageResponse(false, ex.getMessage(), HttpStatus.BAD_REQUEST.value()),
//                HttpStatus.BAD_REQUEST);
//    }
}
