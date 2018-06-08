/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

public class Problema {
    private int idProblema;
    private String descripcion;
    private int tipoProblema;//0 experiencia educativa  //1 depto/servicio
    private String depto_servicio;
    private String experienciaEducativa;
    private String profesorEE;
    private int numAlumnosReportan;
    
    /**
     * Constructor usado para crear un nuevo problema de tipo Depto/Servicio y 
     * guardarlo en la DB
     * @param descripcion
     * Representa la Descripción del Problema
     * @param tipoProblema
     * Representa el tipo de Problema
     * @param depto_servicio 
     * Representa el nombre del departamento o servicio que se reporta
     */
    public Problema(String descripcion, int tipoProblema, String depto_servicio) {
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.depto_servicio = depto_servicio;
    }

    /**
     * Constructor usado para crear un nuevo problema de tipo Experiencia Educativa 
     * y guardarlo en la DB
     * @param descripcion
     * Representa la Descripción del Problema
     * @param tipoProblema
     * Representa el tipo de Problema
     * @param experienciaEducativa
     * Representa el nombre de la Experiencia Educativa que se reporta
     * @param profesorEE
     * Representa el nombre del Profesor que imparte la EE educativa reportada
     */
    public Problema(String descripcion, int tipoProblema, String experienciaEducativa, String profesorEE) {
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.experienciaEducativa = experienciaEducativa;
        this.profesorEE = profesorEE;
    }

    /**
     * Contructor usado para crear el objeto Problema de tipo Depto/Servicio 
     * que se recupera de la DB
     * @param id
     * Representa el identificador del problema recuperado de la DB
     * @param descripcion
     * Representa la Descripción del Problema
     * @param tipoProblema
     * Representa el tipo de Problema
     * @param depto_servicio 
     * Representa el nombre del departamento o servicio que se reporta
     * @param numAlumnosReportan 
     * Representa el numero de alumnos que reportan el problema
     */
    public Problema(int id, String descripcion, int tipoProblema, String depto_servicio, 
            int numAlumnosReportan) {
        this.idProblema = id;
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.depto_servicio = depto_servicio;
        this.numAlumnosReportan = numAlumnosReportan;
    }

    /**
     * Contructor usado para crear el objeto Problema de tipo Experiencia Educativa  
     * que se recupera de la DB
     * @param id
     * Representa el identificador del problema recuperado de la DB
     * @param descripcion
     * Representa la Descripción del Problema
     * @param tipoProblema
     * Representa el tipo de Problema
     * @param experienciaEducativa
     * Representa el nombre de la Experiencia Educativa que se reporta
     * @param profesorEE
     * Representa el nombre del Profesor que imparte la EE educativa reportada
     * @param numAlumnosReportan
     * Representa el numero de alumnos que reportan el problema
     */
    public Problema(int id, String descripcion, int tipoProblema, String experienciaEducativa, 
            String profesorEE, int numAlumnosReportan) {
        this.idProblema = id;
        this.descripcion = descripcion;
        this.tipoProblema = tipoProblema;
        this.experienciaEducativa = experienciaEducativa;
        this.profesorEE = profesorEE;
        this.numAlumnosReportan = numAlumnosReportan;
    }
    
    /**
     * Método que retorna el valor String de la descripción del problema 
     * @return 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método que retorna el valor int del tipo del poblema
     * @return 
     */
    public int getTipoProblema() {
        return tipoProblema;
    }

    /**
     * Método que retorna el valor String del nombre del depto/servicio del 
     * problema
     * @return 
     */
    public String getDepto_servicio() {
        return depto_servicio;
    }

    /**
     * Método que retorna el valor String del nombre de la Experiencia Educativa
     * del problema
     * @return 
     */
    public String getExperienciaEducativa() {
        return experienciaEducativa;
    }
    
    /**
     * Método que retorna el valor String del nombre del Profesor correspondiente
     * a la Experiencia Educativa del problema
     * @return 
     */
    public String getProfesorEE() {
        return profesorEE;
    }

    /**
     * Método que retorna el valor int del numero total de alumnos que reportan 
     * el problema
     * @return 
     */
    public int getNumAlumnosReportan() {
        return numAlumnosReportan;
    }

    /**
     * Método que retorna el valor int del identificador del problema
     * @return 
     */
    public int getIdProblema() {
        return idProblema;
    }
    
    /**
     * Sobreescritura del metodo toString
     * @return 
     * retorna un valor String de la descripcion del problema
     */
    public String toString(){
        return descripcion;
    }
}
