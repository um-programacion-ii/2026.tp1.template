package com.bibliotech.model;
import java.util.Optional;
import java.time.LocalDate;

public class Prestamo {

    private final Libro libro;
    private final Socio socio;
    private final LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, Socio socio, LocalDate fechaPrestamo) {
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Optional<LocalDate> getFechaDevolucion() {
        return Optional.ofNullable(fechaDevolucion);
    }

    public void registrarDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}