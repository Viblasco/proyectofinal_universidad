
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Inscripcion;

public class InscripcionData {
    private Connection con;

    public InscripcionData() {
        con = Conexion.getConexion();
    }
    
    public void guardarInscripcion (Inscripcion inscripcion){
        String sql = "INSERT INTO inscripcion(nota, id_alumno, id_materia) VALUES (?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1,inscripcion.getNota()); //CAMBIAR A DOUBLE EN BASE DE DATOS!!!!!
            ps.setInt(2,inscripcion.getAlumno().getId());
            ps.setInt(3,inscripcion.getMateria().getId_materia());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setId_inscripto(rs.getInt(1));
                System.out.println("Se ha inscripto correctamente el alumno");
            } else {
                System.out.println("No se ha inscripto al alumno");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
