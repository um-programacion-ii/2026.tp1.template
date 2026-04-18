package com.bibliotech.repository;

import com.bibliotech.model.Socio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SocioRepositoryMemoria implements Repository<Socio, String> {

    // Usamos el DNI como clave
    private final Map<String, Socio> baseDeDatos = new HashMap<>();

    @Override
    public void guardar(Socio socio) {
        baseDeDatos.put(socio.dni(), socio);
    }

    @Override
    public Optional<Socio> buscarPorId(String dni) {
        return Optional.ofNullable(baseDeDatos.get(dni));
    }

    @Override
    public List<Socio> buscarTodos() {
        return new ArrayList<>(baseDeDatos.values());
    }
}