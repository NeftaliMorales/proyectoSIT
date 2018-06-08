/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

import accesoDatos.clasesDAO.AsignacionDao;
import java.sql.SQLException;

public class Tutorado {
    
    private String matricula;
    private String nombres;
    private String apellidoPaterno;    
    private String apellidoMaterno;
    private String carrera;
    private int semestre;
    private int estado; //0 no asignado a Tuto //1 asignado a Tutor
    private Tutor tutor;

    public Tutorado(String matricula, String nombres, String apellidoPaterno, 
            String apellidoMaterno, String carrera, int semestre, int estado) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.carrera = carrera;
        this.semestre = semestre;
        this.estado = estado;
    }   
    
    @Override
    public String toString(){
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }
    
    public boolean asignarTutor(Tutor tutor) throws SQLException{
        AsignacionDao aDao = new AsignacionDao();
        return aDao.guardarPeriodo("02/2018 - 06/2018", matricula, tutor.getIdUsuario());
    }
    
    public boolean reasignarTutor(Tutor tutor){
        return true;
    }
    
    public boolean registrarAsistencia(boolean asistencia){
        return true;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
