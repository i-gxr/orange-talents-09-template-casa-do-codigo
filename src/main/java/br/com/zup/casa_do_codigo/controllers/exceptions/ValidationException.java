package br.com.zup.casa_do_codigo.controllers.exceptions;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

}
