
package modelo;

public class Incripcion {
  private int id_incripto;
  private double nota;
  private Alumno alumno;
  private Materia materia;

    public Incripcion() {
    }

    public Incripcion(int id_incripto, double nota, Alumno alumno, Materia materia) {
        this.id_incripto = id_incripto;
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public Incripcion(double nota, Alumno alumno, Materia materia) {
        this.nota = nota;
        this.alumno = alumno;
        this.materia = materia;
    }

    public int getId_incripto() {
        return id_incripto;
    }

    public void setId_incripto(int id_incripto) {
        this.id_incripto = id_incripto;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Incripcion{" + "id_incripto=" + id_incripto + ", nota=" + nota + ", alumno=" + alumno + ", materia=" + materia + '}';
    }
 
  
}
