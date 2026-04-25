package com.taller.dao;

import com.taller.config.ConexionMySQLDatabase;
import com.taller.modelo.InscripcionCurso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionCursoDao {
    private Connection conexion;

    public InscripcionCursoDao() throws SQLException {
        this.conexion = ConexionMySQLDatabase.getConnection();
    }

    public void crear(InscripcionCurso ins) {
        String sql = "INSERT INTO inscripcion_curso (id_estudiante, id_grupo, nota_final, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, ins.getIdEstudiante());
            ps.setInt(2, ins.getIdGrupo());
            ps.setFloat(3, ins.getNotaFinal());
            ps.setString(4, ins.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<InscripcionCurso> listar() {
        List<InscripcionCurso> lista = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion_curso";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new InscripcionCurso(
                    rs.getInt("id_inscripcion"),
                    rs.getInt("id_estudiante"),
                    rs.getInt("id_grupo"),
                    rs.getFloat("nota_final"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public InscripcionCurso buscarPorId(int id) {
        String sql = "SELECT * FROM inscripcion_curso WHERE id_inscripcion = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new InscripcionCurso(
                    rs.getInt("id_inscripcion"),
                    rs.getInt("id_estudiante"),
                    rs.getInt("id_grupo"),
                    rs.getFloat("nota_final"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizar(InscripcionCurso ins) {
        String sql = "UPDATE inscripcion_curso SET id_estudiante=?, id_grupo=?, nota_final=?, estado=? WHERE id_inscripcion=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, ins.getIdEstudiante());
            ps.setInt(2, ins.getIdGrupo());
            ps.setFloat(3, ins.getNotaFinal());
            ps.setString(4, ins.getEstado());
            ps.setInt(5, ins.getIdInscripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM inscripcion_curso WHERE id_inscripcion=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}