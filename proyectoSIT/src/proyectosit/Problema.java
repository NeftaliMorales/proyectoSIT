/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

public class Problema {
    private String descripcion;
    private int tipoProblema;
    private String depto_servicio;
    private String experienciaEducativa;
    private String profesorEE;
    private int numAlumnosReportan;

    public Problema(String descripcion, int tipoProblema, String depto_servicio, String experienciaEducativa, String profesorEE, int numAlumnosReportan) {
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.depto_servicio = depto_servicio;
        this.experienciaEducativa = experienciaEducativa;
        this.profesorEE = profesorEE;
        this.numAlumnosReportan = numAlumnosReportan;
    }
}
