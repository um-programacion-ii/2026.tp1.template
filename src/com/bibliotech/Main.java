package com.bibliotech;

import com.bibliotech.model.*;
import com.bibliotech.repository.RecursoRepositoryMemoria;
import com.bibliotech.repository.Repository;
// OJO: Acá deberías tener un SocioRepositoryMemoria creado igual que el de recursos
import com.bibliotech.repository.SocioRepositoryMemoria;
import com.bibliotech.service.PrestamoService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando BiblioTech...\n");

        // 1. Instanciar los Repositorios (Nuestra base de datos en memoria)
        Repository<Recurso, String> recursoRepo = new RecursoRepositoryMemoria();

        // Simulo el repo de socios (asumiendo que ya lo creaste o lo vas a crear muy parecido al otro)
        Repository<Socio, String> socioRepo = new SocioRepositoryMemoria(); // CASTEO TEMPORAL SOLO PARA QUE COMPILE, CAMBIAR LUEGO

        // 2. Instanciar el Servicio inyectando las dependencias
        PrestamoService prestamoService = new PrestamoService(recursoRepo, socioRepo);

        // 3. Crear datos de prueba (Usando nuestros Records)
        LibroFisico libro = new LibroFisico("978-123", "Clean Code", "Robert C. Martin", 2008, "Programación", "Estante A1");
        Socio estudiante = new Socio("40123456", "Josías", "Vilches", "josias@email.com", TipoSocio.ESTUDIANTE);

        // 4. Guardar los datos en los repositorios
        recursoRepo.guardar(libro);
        socioRepo.guardar(estudiante); // Descomentar cuando tengas el SocioRepositoryMemoria

        // 5. Probar el caso de uso
        try {
            System.out.println("Intentando realizar préstamo...");
            // prestamoService.realizarPrestamo("978-123", "40123456");
            System.out.println("Préstamo registrado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error en el préstamo: " + e.getMessage());
        }
    }
}