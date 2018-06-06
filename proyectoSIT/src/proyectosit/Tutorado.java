/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

public class Tutorado {
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private String matricula;
    private String carrera;
    private int semestre;
    private Tutor tutor;
    
    public boolean asignarTutor(Tutor tutor){
        return true;
    }
    
    public boolean reasignarTutor(Tutor tutor){
        return true;
    }
    
    public boolean registrarAsistencia(boolean asistencia){
        return true;
    }
    
}
