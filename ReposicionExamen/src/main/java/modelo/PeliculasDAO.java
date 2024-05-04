/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Peliculas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author alumno
 */
public class PeliculasDAO {
    
    private static final String SQL_SELECT = "SELECT nombre, clasificacion, subtitulado, idioma, tipo, precio FROM peliculas";
    private static final String SQL_INSERT = "INSERT INTO peliculas(nombre, clasificacion, subtitulado, idioma, tipo, precio) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE peliculas SET clasificacion=?, subtitulado=?, idioma=?, tipo=?, precio=? WHERE nombre=?";
    private static final String SQL_DELETE = "DELETE FROM peliculas WHERE nombre=?";
    private static final String SQL_QUERY = "SELECT nombre, clasificacion, subtitulado, idioma, tipo, precio FROM peliculas WHERE nombre = ?";
    
    public List<Peliculas> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Peliculas pelicula = null;
        List<Peliculas> peliculas = new ArrayList<Peliculas>();

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String clasificacion = rs.getString("clasificacion");
            String subtitulado = rs.getString("subtitulado");
            String idioma = rs.getString("idioma");
            String tipo = rs.getString("tipo");
            String precio = rs.getString("precio");
            
            pelicula = new Peliculas();
            pelicula.setNombre(nombre);
            pelicula.setClasificacion(clasificacion);
            pelicula.setSubtitulado(subtitulado);
            pelicula.setIdioma(idioma);
            pelicula.setTipo(tipo);
            pelicula.setPrecio(precio);
            
            peliculas.add(pelicula);
        }

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return peliculas;
}

public int insert(Peliculas pelicula) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;
    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_INSERT);
        stmt.setString(1, pelicula.getNombre());
        stmt.setString(2, pelicula.getClasificacion());
        stmt.setString(3, pelicula.getSubtitulado());
        stmt.setString(4, pelicula.getIdioma());
        stmt.setString(5, pelicula.getTipo());
        stmt.setString(6, pelicula.getPrecio());
        System.out.println("Ejecutando query:" + SQL_INSERT);
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

public int update(Peliculas pelicula) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query: " + SQL_UPDATE);
        stmt = conn.prepareStatement(SQL_UPDATE);
        stmt.setString(1, pelicula.getClasificacion());
        stmt.setString(2, pelicula.getSubtitulado());
        stmt.setString(3, pelicula.getIdioma());
        stmt.setString(4, pelicula.getTipo());
        stmt.setString(5, pelicula.getPrecio());
        stmt.setString(6, pelicula.getNombre());

        rows = stmt.executeUpdate();
        System.out.println("Registros actualizados:" + rows);

    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}

public int delete(Peliculas pelicula) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query:" + SQL_DELETE);
        stmt = conn.prepareStatement(SQL_DELETE);
        stmt.setString(1, pelicula.getNombre());
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

public Peliculas query(Peliculas pelicula) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        conn = Conexion.getConnection();
        System.out.println("Ejecutando query:" + SQL_QUERY);
        stmt = conn.prepareStatement(SQL_QUERY);
        stmt.setString(1, pelicula.getNombre());
        rs = stmt.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String clasificacion = rs.getString("clasificacion");
            String subtitulado = rs.getString("subtitulado");
            String idioma = rs.getString("idioma");
            String tipo = rs.getString("tipo");
            String precio = rs.getString("precio");
            
            pelicula.setNombre(nombre);
            pelicula.setClasificacion(clasificacion);
            pelicula.setSubtitulado(subtitulado);
            pelicula.setIdioma(idioma);
            pelicula.setTipo(tipo);
            pelicula.setPrecio(precio);
    
        }
        //System.out.println("Registros buscados:" + vendedor);
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        Conexion.close(rs);
        Conexion.close(stmt);
        Conexion.close(conn);
    }
    return pelicula;
}
    
    
}
