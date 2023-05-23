
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
               System.out.println("El alumno no se pudo guardar");
           }
           ps.close();
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
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
           
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
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
               System.out.println("Alumno inexistente");
           }
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
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
               System.out.println("Alumno inexistente");
           }
       } catch (SQLException ex) {
           Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
       }
       return alu;
    }
    
    public List<Alumno> listarAlumnos(){
        List<Alumno> lista = new ArrayList<>();
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
                alu.setFecha_nacimiento(rs.getDate("fecha_nac").toLocalDate());
                alu.setEstado(rs.getBoolean("estado"));
                lista.add(alu);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }
        if (lista.isEmpty()) {
            System.out.println("La base de datos se encuentra vacia");
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
                System.out.println("Error al borrar el alumno con id_alumno: " + id);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al borrar el alumno con id_alumno: " + id + ". Error: " + ex.getMessage());
        }
    }
}
