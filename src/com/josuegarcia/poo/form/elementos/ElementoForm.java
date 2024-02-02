package com.josuegarcia.poo.form.elementos;

import com.josuegarcia.poo.form.validador.LargoValidador;
import com.josuegarcia.poo.form.validador.Validador;
import com.josuegarcia.poo.form.validador.mensaje.IMensajeFormateable;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoForm {

    protected String valor;
    protected String nombre;
    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<String> getErrores() {
        return this.errores;
    }

    public String getNombre() {
        return nombre;
    }

    public ElementoForm addValidador(Validador validador) {
        this.validadores.add(validador);

        return this;
    }

    public boolean esValido() {
        for(Validador v : this.validadores) {
            if (!v.esValido(this.valor)) {
                if (v instanceof IMensajeFormateable) {
                    this.errores.add(((IMensajeFormateable) v).getMensajeFormateado(this.nombre));
                } else {
                    this.errores.add(String.format(v.getMensaje(), this.nombre));
                }
            }
        }

        return this.errores.isEmpty();
    }

    abstract public String dibujarHtml();

}
