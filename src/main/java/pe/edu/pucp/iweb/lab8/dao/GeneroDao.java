package pe.edu.pucp.iweb.lab8.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pe.edu.pucp.iweb.lab8.beans.Cancion;
import pe.edu.pucp.iweb.lab8.beans.Genero;

import static java.sql.DriverManager.getConnection;

public class GeneroDao { // TODO: heredar de BaseDao

    /**
     * Ejercicio 2: todos los géneros ordenados por nombre.
     */
    public ArrayList<Genero> listar() {
        public boolean listar() {
            ArrayList<Genero> lista = new ArrayList<>();
            String sql = "SELECT genero, nombre"
                    + "FROM genero  ";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Genero gen = new Cancion();
                    gen.setGenero(rs.getString("genero"));

                    lista.add(gen);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return lista;
        }
        // TODO
        return new ArrayList<>();
    }
}
