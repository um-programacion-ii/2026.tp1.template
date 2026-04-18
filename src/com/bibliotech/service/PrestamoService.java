package com.bibliotech.service;

import com.bibliotech.exception.BiblioTechException;
import com.bibliotech.model.Recurso;
import com.bibliotech.model.Socio;
import com.bibliotech.repository.Repository;

public class PrestamoService {

    private final Repository<Recurso, String> recursoRepository;
    private final Repository<Socio, String> socioRepository;

    public PrestamoService(Repository<Recurso, String> recursoRepository, Repository<Socio, String> socioRepository) {
        this.recursoRepository = recursoRepository;
        this.socioRepository = socioRepository;
    }

    public void realizarPrestamo(String isbn, String dniSocio) throws BiblioTechException {
        // 1. Buscar al socio instanciando TU propia excepción
        Socio socio = socioRepository.buscarPorId(dniSocio)
                .orElseThrow(() -> new BiblioTechException("Socio no encontrado con DNI: " + dniSocio));

        // 2. Buscar el recurso instanciando TU propia excepción
        Recurso recurso = recursoRepository.buscarPorId(isbn)
                .orElseThrow(() -> new BiblioTechException("Recurso no encontrado con ISBN: " + isbn));

        // 3. Acá iría la lógica de validación (límites según tipo de socio, stock, etc.)
        System.out.println("Validando préstamo de '" + recurso.titulo() + "' para el socio " + socio.nombre());

        // TODO: Registrar el préstamo en un historial/objeto Prestamo
    }
}