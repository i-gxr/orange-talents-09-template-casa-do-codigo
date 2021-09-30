package br.com.zup.casa_do_codigo.controllers.dto;

public class SimpleErrorOutputDto {

    private String message;

    public SimpleErrorOutputDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
