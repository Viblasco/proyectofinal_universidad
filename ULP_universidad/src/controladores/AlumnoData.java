
package controladores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;


public class AlumnoData {
   private Connection con;

    public AlumnoData() {
        con = Conexion.getConexion();
    }
    
    public void guardarAlumno(Alumno alumno){
       try {
           String sql =  "INSERT INTO alumno(dni,nombre,apellido,f_nacimiento,estado) VALUES (?,?,?,?,?)";
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1,alumno.getDni());
           ps.setString(2, alumno.getNombre());
           ps.setString(3, alumno.getApellido());
           ps.setDate(4, Date.valueOf(alumno.getFecha_nacimiento()));
           ps.setBoolean(5, alumno.isEstado());
           ps.executeUpdate();
           
           ResultSet rs= ps.getGeneratedKeys();
           if (rs.next()){
               alumno.setId(rs.getInt(1));
           } else {
               JOptionPane.showMessageDialog(null, "No se pudo guardar el alumno");
           }
           ps.close();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo guardar el alumno");
       }
    }
    
    public void actualizarAlumno(Alumno alumno){
        try {
           String sql =  "UPDATE alumno SET dni=?,nombre=?,apellido=?,f_nacimiento=?,estado=? WHERE id_alumno=?";
           PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1,alumno.getDni());
           ps.setString(2, alumno.getNombre());
           ps.setString(3, alumno.getApellido());
           ps.setDate(4, Date.valueOf(alumno.getFecha_nacimiento()));
           ps.setBoolean(5, alumno.isEstado());
           ps.setInt(6, alumno.getId());
           ps.executeUpdate();
           ps.close();
           JOptionPane.showMessageDialog(null,"Alumno actualizado correctamente");
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al actualizar alumno");
       }
    }
    
    public Alumno buscarAlumno(int id){
        Alumno alu = null;
      String sql = "SELECT id_alumno,dni,nombre,apellido,f_nacimiento,estado FROM alumno WHERE id_alumno=?";
      
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,id);
           ResultSet rs = ps.executeQuery();
           if (rs.next()){
               alu = new Alumno();
               alu.setId(rs.getInt("id_alumno"));
               alu.setDni(rs.getInt("dni"));
               alu.setNombre(rs.getString("nombre"));
               alu.setApellido(rs.getString("apellido"));
               alu.setFecha_nacimiento(rs.getDate("f_nacimiento").toLocalDate());
               alu.setEstado(rs.getBoolean("estado"));
           } else {
               JOptionPane.showMessageDialog(null, "Alumno inexistente");
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo buscar el alumno");
       }
       return alu;
    }
    
    public Alumno buscarAlumnoporDni(int dni){
        Alumno alu = null;
      String sql = "SELECT id_alumno,dni,nombre,apellido,f_nacimiento,estado FROM alumno WHERE dni=?";
      
       try {
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,dni);
           ResultSet rs = ps.executeQuery();
           if (rs.next()){
               alu = new Alumno();
               alu.setId(rs.getInt("id_alumno"));
               alu.setDni(rs.getInt("dni"));
               alu.setNombre(rs.getString("nombre"));
               alu.setApellido(rs.getString("apellido"));
               alu.setFecha_nacimiento(rs.getDate("f_nacimiento").toLocalDate());
               alu.setEstado(rs.getBoolean("estado"));
           } else {
               JOptionPane.showMessageDialog(null, "Alumno inexistente");
           }
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No se pudo buscar el alumno");
       }
       return alu;
    }
    
    public ArrayList<Alumno> listarAlumnos(){
        ArrayList<Alumno> lista = new ArrayList<>();
        Alumno alu;
        String sql ="SELECT * FROM alumno";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alu = new Alumno();
                alu.setId(rs.getInt("id_alumno"));
                alu.setNombre(rs.getString("nombre"));
                alu.setApellido(rs.getString("apellido"));
                alu.setFecha_nacimiento(rs.getDate("f_nacimiento").toLocalDate());
                alu.setEstado(rs.getBoolean("estado"));
                lista.add(alu);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener los alumnos: " + ex.getMessage());
        }
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La base de datos se encuentra vacía");
        }
        return lista;
    }
    
    public void eliminarAlumno(int id){
        String sql = "UPDATE alumno SET estado = false WHERE id_alumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            if ((ps.executeUpdate() == 1)) {
                System.out.println("Alumno borrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al borrar alumno");
            }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al borrar el alumno con id_alumno: " + id + ". Error: " + ex.getMessage());
        }
    }
}
