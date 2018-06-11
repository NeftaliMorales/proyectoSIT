    /**
 * @autor Gabriela Sandoval Cruz
 * @autor Jose Rodrigo Ordóñes Pacheco
 * @autor Edson Neftali Melgarejo Morales
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

    /**
     * Constructor con todos los atributos de la clase
     * @param matricula
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param carrera
     * @param semestre
     * @param estado 
     */
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
    
    /**
     * Sobreescritura del método toString
     * @return 
     * retorna un valor String con el nombre completo del Tutorado
     */
    @Override
    public String toString(){
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }
    
    /**
     * Método que realiza la asignación del Tutorado a un Tutor.
     * @param tutor
     * Valor proporcionado por el usuario a travez de la interfaz asignarTutor
     * @return
     * retorna un valor boolean que indica si se realizo la asignación
     * @throws SQLException 
     */
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

    /**
     * Retorna la matricula del Tutorado
     * @return 
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Retorna el(los) nombre(s) del Tutorado
     * @return 
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Retorna el apellido paterno del Tutorado
     * @return 
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Retorna el apellido materno del Tutorado
     * @return 
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Retorna la carrera del Tutorado
     * @return 
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * Retorna el semestre del Tutorado
     * @return 
     */
    public int getSemestre() {
        return semestre;
    }
}
