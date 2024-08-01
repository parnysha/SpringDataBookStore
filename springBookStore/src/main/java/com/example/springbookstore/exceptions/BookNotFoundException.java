package com.example.springbookstore.exceptions;

import lombok.extern.java.Log;


@Log //при пробрассовании исключений указывает сообщение исключения
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {super();}

    public BookNotFoundException(final String message, final Throwable cause) {
        super(message,cause);

        log.warning(message);
        log.warning(cause.toString());
    }

    public BookNotFoundException(final String message) {
        super(message);

        log.warning(message);
    }
    public BookNotFoundException(final Throwable cause) {
        super(cause);

        log.warning(cause.toString());
    }
}
