/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

public class Problema {
    private String descripcion;
    private int tipoProblema;//0 experiencia educativa  //1 depto/servicio
    private String depto_servicio;
    private String experienciaEducativa;
    private String profesorEE;
    private int numAlumnosReportan;

    public Problema(String descripcion, int tipoProblema, String depto_servicio) {
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.depto_servicio = depto_servicio;
    }

    public Problema(String descripcion, int tipoProblema, String experienciaEducativa, String profesorEE) {
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.experienciaEducativa = experienciaEducativa;
        this.profesorEE = profesorEE;
    }

    public Problema(String descripcion, int tipoProblema, String depto_servicio, int numAlumnosReportan) {
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.depto_servicio = depto_servicio;
        this.numAlumnosReportan = numAlumnosReportan;
    }

    public Problema(String descripcion, int tipoProblema, String experienciaEducativa, String profesorEE, int numAlumnosReportan) {
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.experienciaEducativa = experienciaEducativa;
        this.profesorEE = profesorEE;
        this.numAlumnosReportan = numAlumnosReportan;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public int getTipoProblema() {
        return tipoProblema;
    }

    public String getDepto_servicio() {
        return depto_servicio;
    }

    public String getExperienciaEducativa() {
        return experienciaEducativa;
    }

    public String getProfesorEE() {
        return profesorEE;
    }

    public int getNumAlumnosReportan() {
        return numAlumnosReportan;
    }
}
