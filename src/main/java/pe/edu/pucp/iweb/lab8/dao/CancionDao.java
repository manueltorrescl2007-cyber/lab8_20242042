package pe.edu.pucp.iweb.lab8.dao;
import java.util.ArrayList;
import pe.edu.pucp.iweb.lab8.beans.Cancion;
import pe.edu.pucp.iweb.lab8.beans.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CancionDao extends BaseDao { // TODO: heredar de BaseDao

    /**
     * Ejercicio 2: todas las canciones (con el nombre de su género, JOIN),
     * ordenadas por título. Use PreparedStatement.
     */
    public boolean listar() {
        ArrayList<Cancion> lista = new ArrayList<>();
        String sql = "SELECT c.titulo, c.artista, g.nombre , g"
                + "FROM cancion c "
                + "INNER JOIN genero g ON c.idGenero = g.idGenero"
                + "ORDER BY c.idGenero";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Cancion can = new Cancion();
                can.setTitulo(rs.getString("titulo"));
                can.setArtista(rs.getString("artista"));
                Genero gen = new Genero();
                gen.setNombre(rs.getString("nombre"));
                can.setIdGenero(gen);
                lista.add(can);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }



        // TODO



    /**
     * Ejercicio 2: la canción con ese id, o null si no existe.
     */
    public Cancion buscarPorId(int idCancion) {
        // TODO
        return null;
    }

    /**
     * Ejercicio 2: INSERT de una canción nueva (PreparedStatement).
     */
    public void crear(String titulo, String artista, String duracion_seg, String anio ){
            String sql1 = "INSERT INTO Cancion (titulo, artista, duracion_seg , anio ) VALUES (?, ?, ?, ?)";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql1)) {
                pstmt.setString(1, titulo);
                pstmt.setString(2, artista);
                pstmt.setObject(3, duracion_seg);
                pstmt.setObject(4, anio);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    /**
     * Ejercicio 2: UPDATE de una canción existente (PreparedStatement).
     */
    public boolean actualizar(String titulo, String artista, String duracion_seg, String anio){
                String sql2 = "UPDATE Cancion SET titulo = ?, artista = ?, duracion_seg = ?, "
                        + "anio = ? WHERE id_cancion = ?";
                try (Connection conn = getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(sql2)) {
                    pstmt.setString(1, titulo);
                    pstmt.setString(2, artista);
                    pstmt.setInt(3, duracion_seg);
                    pstmt.setInt(4, anio);
                    pstmt.executeUpdate();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
    }




    /**
     * Ejercicio 3: DELETE por id (PreparedStatement).
     */
    public void eliminar(int idCancion) {
        String sql = "DELETE FROM cancion WHERE idcancion = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCancion);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        // ============ 5) BORRAR ============

        public void borrarEmpleado(int employeeId) {
            String sql = "DELETE FROM employees WHERE employee_id = ?";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, employeeId);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // TODO
    }
}
