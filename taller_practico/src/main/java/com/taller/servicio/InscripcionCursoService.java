package com.taller.servicio;

import com.taller.dao.InscripcionCursoDao;
import com.taller.modelo.InscripcionCurso;
import java.util.List;

public class InscripcionCursoService {
    private InscripcionCursoDao dao;

    public InscripcionCursoService() {
        try {
            this.dao = new InscripcionCursoDao();
        } catch (Exception e) {
            throw new RuntimeException("Error conexión: " + e.getMessage());
        }
    }

    public void crearInscripcion(int idEstudiante, int idGrupo, float nota, String estado) {
        if (estado == null || estado.isBlank()) throw new IllegalArgumentException("El estado no puede estar vacío");
        dao.crear(new InscripcionCurso(0, idEstudiante, idGrupo, nota, estado));
    }

    public List<InscripcionCurso> listarInscripciones() { return dao.listar(); }

    public InscripcionCurso buscarInscripcion(int id) { return dao.buscarPorId(id); }

    public void actualizarInscripcion(int id, int idEst, int idGrupo, float nota, String estado) {
        dao.actualizar(new InscripcionCurso(id, idEst, idGrupo, nota, estado));
    }

    public void eliminarInscripcion(int id) { dao.eliminar(id); }
}