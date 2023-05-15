
package ulp_universidad;

import controladores.AlumnoData;
import java.time.LocalDate;
import java.time.Month;
import modelo.Alumno;

public class ULP_universidad {

    public static void main(String[] args) {
       //Alumno alu = new Alumno("Suarez","Mariana",444444,LocalDate.of(2000, 2, 20),true);
       Alumno alu2 = new Alumno(5,"Suarez","Mariana",555555,LocalDate.of(2000, 2, 20),true);
       AlumnoData ad = new AlumnoData();
       //ad.guardarAlumno(alu);
       //ad.actualizarAlumno(alu2);
        System.out.println("El alumno es"+ad.buscarAlumno(5));
    }
    
}
