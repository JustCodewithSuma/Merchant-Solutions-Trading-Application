package com.code.challenge.trading.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.TimeoutException;

/**
 * ExceptionHandler class for handling the ResponseEntityException .
 * Different Methods have been defined to handle HttpClientErrorException,IllegalArgumentException and
 * HttpServerErrorException.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Method for handling the HttpClientErrorException.Unauthorized
     */
    @ExceptionHandler(value = { HttpClientErrorException.Unauthorized.class })
    protected ResponseEntity<Object> handleUnauthorizedException(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    /**
     * Method for handling the HttpClientErrorException.Forbidden
     */
    @ExceptionHandler(value = { HttpClientErrorException.Forbidden.class })
    protected ResponseEntity<Object> handleForbiddenException(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    /**
     * Method for handling the HttpClientErrorException.TooManyRequests
     */
    @ExceptionHandler(value = { HttpClientErrorException.TooManyRequests.class })
    protected ResponseEntity<Object> handleTooManyRequestsException(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex,ex.getMessage(),
                new HttpHeaders(), HttpStatus.TOO_MANY_REQUESTS, request);
    }

    /**
     * Method for handling the TimeoutException
     */
    @ExceptionHandler(value
            = { TimeoutException.class})
    protected ResponseEntity<Object> handleTimeOutException(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.REQUEST_TIMEOUT, request);
    }

    /**
     * Method for handling the HttpClientErrorException.UnprocessableEntity
     */
    @ExceptionHandler(value
            = {HttpClientErrorException.UnprocessableEntity.class })
    protected ResponseEntity<Object> handleBadFormatRequest(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, request);
    }

    /**
     * Method for handling the IllegalArgumentException
     */
    @ExceptionHandler(value
            = { IllegalArgumentException.class})
    protected ResponseEntity<Object> handleIllegalArgumentException(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_IMPLEMENTED, request);
    }

    /**
     * Method for handling the HttpClientErrorException.BadRequest
     */
    @ExceptionHandler(value
            = { HttpClientErrorException.BadRequest.class})
    protected ResponseEntity<Object> handleBadRequestException(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /**
     * Method for handling the HttpServerErrorException.InternalServerError
     */
    @ExceptionHandler(value
            = { HttpServerErrorException.InternalServerError.class})
    protected ResponseEntity<Object> handleInternalServerException(
            RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
