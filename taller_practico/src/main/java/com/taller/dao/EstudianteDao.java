package com.taller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.taller.config.ConexionMySQLDatabase;
import com.taller.modelo.Estudiante;

public class EstudianteDao {

    public void guardar(Estudiante estudiante) {

        String sql = "INSERT INTO \"practica-mvc\".estudiantes (name, lastname, email) VALUES (?, ?, ?)";

        try (Connection conn = ConexionMySQLDatabase.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, estudiante.getNombre());
            pstmt.setString(2, estudiante.getApellido());
            pstmt.setString(3, estudiante.getEmail());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Estudiante> obtenerTodos() {
        List<Estudiante> estudiantes = new ArrayList<>();

        String sql = "SELECT id, name, lastname, email FROM \"practica-mvc\".estudiantes";

        try (Connection conn = ConexionMySQLDatabase.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt("id"));
                estudiante.setNombre(rs.getString("name"));
                estudiante.setApellido(rs.getString("lastname"));
                estudiante.setEmail(rs.getString("email"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }

}
