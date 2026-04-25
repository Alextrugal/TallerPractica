package com.taller.dao;

import com.taller.config.ConexionMySQLDatabase;
import com.taller.modelo.Grupo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoDao {
    private Connection conexion;

    public GrupoDao() throws SQLException {
        this.conexion = ConexionMySQLDatabase.getConnection();
    }

    public void crear(Grupo grupo) {
        String sql = "INSERT INTO grupo (id_materia, id_docente, aula, horario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, grupo.getIdMateria());
            ps.setInt(2, grupo.getIdDocente());
            ps.setString(3, grupo.getAula());
            ps.setString(4, grupo.getHorario());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Grupo> listar() {
        List<Grupo> lista = new ArrayList<>();
        String sql = "SELECT * FROM grupo";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Grupo(
                    rs.getInt("id_grupo"),
                    rs.getInt("id_materia"),
                    rs.getInt("id_docente"),
                    rs.getString("aula"),
                    rs.getString("horario")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Grupo buscarPorId(int id) {
        String sql = "SELECT * FROM grupo WHERE id_grupo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Grupo(
                    rs.getInt("id_grupo"),
                    rs.getInt("id_materia"),
                    rs.getInt("id_docente"),
                    rs.getString("aula"),
                    rs.getString("horario")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizar(Grupo grupo) {
        String sql = "UPDATE grupo SET id_materia=?, id_docente=?, aula=?, horario=? WHERE id_grupo=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, grupo.getIdMateria());
            ps.setInt(2, grupo.getIdDocente());
            ps.setString(3, grupo.getAula());
            ps.setString(4, grupo.getHorario());
            ps.setInt(5, grupo.getIdGrupo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM grupo WHERE id_grupo=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}