package com.josuegarcia.poo.form.validador;

public class NoNuloValidador extends Validador {

    protected String mensaje = "El campo %s no puede ser nulo";

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
        return (valor != null);
    }
}
