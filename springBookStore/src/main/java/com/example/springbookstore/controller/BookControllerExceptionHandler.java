package com.example.springbookstore.controller;

import com.example.springbookstore.exceptions.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Iterator;

@ControllerAdvice
public class BookControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity handleNotFoundException(BookNotFoundException ex, WebRequest request) {
        final HttpHeaders httpHeaders = new HttpHeaders();

        final Iterator<String> headersIterator = request.getHeaderNames();
        while (headersIterator.hasNext()) {
            final String headerName = headersIterator.next();
            httpHeaders.add(headerName, request.getHeader(headerName));
        }
        return handleExceptionInternal(ex, "Book not found", httpHeaders, HttpStatus.NOT_FOUND,request);

    }
}
