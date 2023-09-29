
package bdestudiantes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class estudiante {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    conexion acceso = new conexion();

    public void listar() {

        String sql = "select * from alumnos";

        try {
            //Inicializa la base de datos
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5) + " - " + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void crear(String nombre, String apellido, String nivel, String grado, String seccion) {

        String sql = "insert into alumnos(nombre,apellido,nivel,grado,seccion) values (?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(2, apellido);
            ps.setString(1, nombre);
             ps.setString(3, nivel);
             ps.setString(4, grado);
             ps.setString(5, seccion);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void modificar(int codigo, String nombre, String apellido, String nivel, String grado, String seccion) {

        String sql = "update alumnos set nombre=?, apellido=?, nivel=?, grado=?, seccion =? where id=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, nivel);
            ps.setString(4, grado);
            ps.setString(5, seccion);
            ps.setInt(5, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminar(int codigo) {
        String sql = "delete from alumnos where id=?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

   public boolean status_estudiante(int id_estudiante) {
    // Declaración de variable
    boolean existe = false;

    try (Connection con = acceso.Conectar();
         PreparedStatement ps = con.prepareStatement("select count(*) from alumnos where id = ?")) {

        ps.setInt(1, id_estudiante);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int count = rs.getInt(1);
            existe = (count > 0);
        }

    } catch (SQLException e) {
        // excepciones 
        System.out.println("Error al verificar la existencia del estudiante: " + e.getMessage());
    }

    return existe;
}
      
}
