package com.taller.dao;

import com.taller.config.ConexionMySQLDatabase;
import com.taller.modelo.Docente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDao {
    private Connection conexion;

    public DocenteDao() {
        try {
            this.conexion = ConexionMySQLDatabase.getConnection();
        } catch (Exception e) {
            throw new RuntimeException("Error conexión: " + e.getMessage());
        }
    }

    public void crear(Docente docente) {
        String sql = "INSERT INTO docente (nombre, especialidad) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, docente.getNombre());
            ps.setString(2, docente.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Docente> listar() {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT * FROM docente";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Docente(
                    rs.getInt("id_docente"),
                    rs.getString("nombre"),
                    rs.getString("especialidad")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Docente buscarPorId(int id) {
        String sql = "SELECT * FROM docente WHERE id_docente = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Docente(
                    rs.getInt("id_docente"),
                    rs.getString("nombre"),
                    rs.getString("especialidad")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void actualizar(Docente docente) {
        String sql = "UPDATE docente SET nombre=?, especialidad=? WHERE id_docente=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, docente.getNombre());
            ps.setString(2, docente.getEspecialidad());
            ps.setInt(3, docente.getIdDocente());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM docente WHERE id_docente=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}