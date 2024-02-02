package com.josuegarcia.poo.form;

import com.josuegarcia.poo.form.elementos.*;
import com.josuegarcia.poo.form.elementos.select.Opcion;
import com.josuegarcia.poo.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {

    public static void main(String[] args) {

        // Instancias del form
        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador());
        password.addValidador(new LargoValidador(6,12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 5);

        // Opciones del select form
        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");

        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "JavaScript"))
                .addOpcion(new Opcion("4", "TypeScript").setSelected(true))
                .addOpcion(new Opcion("5", "Php"));

        // Clase anonima
        ElementoForm saludar = new ElementoForm("saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='"+ this.nombre + "' value='" + this.valor  + "'>";
            }
        };

        // Estableciendo valores
        saludar.setValor("Hola que tal, este campo esta deshabilitado");
        username.setValor(""); // Username no valido
        password.setValor("a1b2c3");
        email.setValor("john.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("... mas de 10 años de experiencia");

        // Asignando valores a la lista
        List<ElementoForm> elementos = Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);

        // Imprimiendo los datos
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if (!e.esValido()) {
                e.getErrores().forEach(System.out::println);
            }
        });
    
    }
}
