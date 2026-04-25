package com.taller.servicio;

import com.taller.dao.DocenteDao;
import com.taller.modelo.Docente;
import java.util.List;

public class DocenteService {
    private DocenteDao dao;

    public DocenteService() {
        try {
            this.dao = new DocenteDao();
        } catch (Exception e) {
            throw new RuntimeException("Error al conectar DAO: " + e.getMessage());
        }
    }
    public void crearDocente(String nombre, String especialidad) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío");
        dao.crear(new Docente());
    }

    public List<Docente> listarDocentes() { return dao.listar(); }

    public Docente buscarDocente(int id) { return dao.buscarPorId(id); }

    public void actualizarDocente(int id, String nombre, String especialidad) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío");
        dao.actualizar(new Docente());
    }

    public void eliminarDocente(int id) { dao.eliminar(id); }
}