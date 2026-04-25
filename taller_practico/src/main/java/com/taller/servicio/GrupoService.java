package com.taller.servicio;

import com.taller.dao.GrupoDao;
import com.taller.modelo.Grupo;
import java.util.List;

public class GrupoService {
    private GrupoDao dao;

    public GrupoService() {
        try {
            this.dao = new GrupoDao();
        } catch (Exception e) {
            throw new RuntimeException("Error conexión: " + e.getMessage());
        }
    }

    public void crearGrupo(int idMateria, int idDocente, String aula, String horario) {
        if (aula == null || aula.isBlank()) throw new IllegalArgumentException("El aula no puede estar vacía");
        dao.crear(new Grupo(0, idMateria, idDocente, aula, horario));
    }

    public List<Grupo> listarGrupos() { return dao.listar(); }

    public Grupo buscarGrupo(int id) { return dao.buscarPorId(id); }

    public void actualizarGrupo(int id, int idMateria, int idDocente, String aula, String horario) {
        dao.actualizar(new Grupo(id, idMateria, idDocente, aula, horario));
    }

    public void eliminarGrupo(int id) { dao.eliminar(id); }
}