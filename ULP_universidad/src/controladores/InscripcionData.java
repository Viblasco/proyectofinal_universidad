
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
import modelo.Alumno;
import modelo.Inscripcion;
import modelo.Materia;

public class InscripcionData {
    private Connection con;
    private MateriaData matData;
    private AlumnoData aluData;

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
    
    public List<Inscripcion> obtenerInscripciones(){
        List<Inscripcion> listaInscriptos = new ArrayList<>();
        String sql = "SELECT * FROM inscripcion";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                   Inscripcion i = new Inscripcion();
                   i.setId_inscripto(rs.getInt("id_inscripto"));
                   Alumno a = aluData.buscarAlumno(rs.getInt("id_alumno"));
                   i.setAlumno(a);
                   Materia m = matData.buscarMateria(rs.getInt("id_materia"));
                   i.setMateria(m);
                   i.setNota(rs.getDouble("nota"));
                   listaInscriptos.add(i);
        }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (listaInscriptos.isEmpty()) {
            System.out.println("La base de datos se encuentra vacia");
        }
        return listaInscriptos;
        
    }
    
}
