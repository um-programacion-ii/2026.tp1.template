package com.bibliotech.model;

public abstract class Socio {
    private final int id;
    private final String nombre;
    private final String email;
    private final String dni;

    public Socio(int id, String nombre, String email, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public abstract int getLimitePrestamos();
}