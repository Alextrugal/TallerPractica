package com.taller.dao;

import com.taller.config.ConexionMySQLDatabase;
import com.taller.modelo.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {
    private Connection conexion;

    public MateriaDao() throws SQLException {
        this.conexion = ConexionMySQLDatabase.getConnection();
    }

    public void crear(Materia materia) {
        String sql = "INSERT INTO materia (nombre_materia, creditos) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getCreditos());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Materia> listar() {
        List<Materia> lista = new ArrayList<>();
        String sql = "SELECT * FROM materia";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Materia(
                    rs.getInt("id_materia"),
                    rs.getString("nombre_materia"),
                    rs.getInt("creditos")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Materia buscarPorId(int id) {
        String sql = "SELECT * FROM materia WHERE id_materia = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Materia(
                    rs.getInt("id_materia"),
                    rs.getString("nombre_materia"),
                    rs.getInt("creditos")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizar(Materia materia) {
        String sql = "UPDATE materia SET nombre_materia=?, creditos=? WHERE id_materia=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getCreditos());
            ps.setInt(3, materia.getIdMateria());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM materia WHERE id_materia=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}