package com.josuegarcia.poo.form.validador;

public class EmailValidador extends Validador {

    String mensaje = "El campo %s tiene un formato de correo inválido";
    private final static String EMAIL_REGEX = "^(.+)@(.+)$";

    @Override
    public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return this.mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        return valor.matches(EmailValidador.EMAIL_REGEX);
    }
}
