/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Modelo.*;
import Controlador.seguridad.Facultades;
import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class FacultadesDAO {

    private static final String SQL_SELECT = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades";
    private static final String SQL_INSERT = "INSERT INTO facultades(nombre_facultad, estatus_facultad) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE facultades SET nombre_facultad=?, estatus_facultad=? WHERE codigo_facultad = ?";
    private static final String SQL_DELETE = "DELETE FROM facultades WHERE codigo_facultad=?";
    private static final String SQL_QUERY = "SELECT codigo_facultad, nombre_facultad, estatus_facultad FROM facultades WHERE nombre_facultad = ?";

    public List<Facultades> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Facultades facultades = null;
        List<Facultades> facultadess = new ArrayList<Facultades>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_facultad = rs.getInt("codigo_facultad");
                String nombre_facultad = rs.getString("nombre_facultad");
                String estatus_facultad = rs.getString("estatus_facultad");

                facultades = new Facultades();
                facultades.setcodigo_facultad(codigo_facultad);
                facultades.setnombre_facultad(nombre_facultad);
                facultades.setestatus_facultad(estatus_facultad);

                facultadess.add(facultades);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return facultadess;
    }

    public int insert(Facultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, facultades.getnombre_facultad());
            stmt.setString(2, facultades.getestatus_facultad());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Facultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, facultades.getnombre_facultad());
            stmt.setString(2, facultades.getestatus_facultad());
            stmt.setInt(3, facultades.getcodigo_facultad());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Facultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, facultades.getcodigo_facultad());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public Facultades query(Facultades facultades) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, facultades.getnombre_facultad());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo_facultad = rs.getInt("codigo_facultad");
                String nombre_facultad = rs.getString("nombre_facultad");
                String estatus_facultad = rs.getString("estatus_facultad");

                facultades = new Facultades();
                facultades.setcodigo_facultad(codigo_facultad);
                facultades.setnombre_facultad(nombre_facultad);
                facultades.setestatus_facultad(estatus_facultad);
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return facultades;
    }
}