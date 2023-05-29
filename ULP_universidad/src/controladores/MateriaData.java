
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Materia;

public class MateriaData {
    private Connection con;

    public MateriaData() {
        con = Conexion.getConexion();
    }
    
    public void guardarMateria(Materia materia){
        String sql =  "INSERT INTO materia(nombre,anio,estado)VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
           ps.setInt(2, materia.getAnio());
           ps.setBoolean(3, materia.isEstado());
           ps.executeUpdate();
           ResultSet rs= ps.getGeneratedKeys();
           if (rs.next()){
               materia.setId_materia(rs.getInt(1));
               JOptionPane.showMessageDialog(null,"La materia guardada exitosamente");
           } else {
               JOptionPane.showMessageDialog(null,"La materia no se pudo guardar");
           }
           ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"La materia no se pudo guardar");
        }
    }
    
    public void actualizarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre=?,anio=?,estado=? WHERE id_materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isEstado());
            ps.setInt(4, materia.getId_materia());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Materia actualizada");
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"La materia no se pudo actualizar");
        }
    }
    
    public Materia buscarMateria(int id){
        Materia mat = null;
        String sql = "SELECT id_materia, nombre, anio, estado FROM materia WHERE id_materia=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                mat = new Materia();
                mat.setId_materia(rs.getInt("id_materia"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                mat.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null,"Materia inexistente");
            }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Materia inexistente");
        }
        
        return mat;
    }
    
    public List<Materia> listarMaterias(){
        List<Materia> lista = new ArrayList<>();
        Materia mat;
        String sql ="SELECT * FROM materia";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mat = new Materia();
                mat.setId_materia(rs.getInt("id_materia"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnio(rs.getInt("anio"));
                mat.setEstado(rs.getBoolean("estado"));
                lista.add(mat);
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las materias: " + ex.getMessage());
        }
        if (lista.isEmpty()) {
            System.out.println("La base de datos se encuentra vacia");
        }
        return lista;
    }
    
    public void eliminarMateria(int id){
        String sql = "UPDATE materia SET estado = false WHERE id_materia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            if ((ps.executeUpdate() == 1)) {
                System.out.println("Materia borrada correctamente.");
            } else {
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al borrar la materia con id_materia: " + id + ". Error: " + ex.getMessage());
        }
    }
    
}
