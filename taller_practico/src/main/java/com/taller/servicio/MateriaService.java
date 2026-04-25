package com.taller.servicio;

import com.taller.dao.MateriaDao;
import com.taller.modelo.Materia;
import java.util.List;

public class MateriaService {
    private MateriaDao dao;

    public MateriaService() {
        try {
            this.dao = new MateriaDao();
        } catch (Exception e) {
            throw new RuntimeException("Error conexión: " + e.getMessage());
        }
    }

    public void crearMateria(String nombre, int creditos) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío");
        if (creditos <= 0) throw new IllegalArgumentException("Los créditos deben ser mayores a 0");
        dao.crear(new Materia(0, nombre, creditos));
    }

    public List<Materia> listarMaterias() { return dao.listar(); }

    public Materia buscarMateria(int id) { return dao.buscarPorId(id); }

    public void actualizarMateria(int id, String nombre, int creditos) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío");
        dao.actualizar(new Materia(id, nombre, creditos));
    }

    public void eliminarMateria(int id) { dao.eliminar(id); }
}