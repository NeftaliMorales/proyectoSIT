/**
 * @autor Gabriela Sandoval Cruz
 * @autor Jose Rodrigo Ordóñes Pacheco
 * @autor Edson Neftali Melgarejo Morales
 * @since 30/05/18
 */
package proyectosit;

public class Tutor extends Usuario{
    
    private boolean disponibilidad; //0: no disponible //1: disponible
    private int tipoProfesor; //1: Tiempo Completo //2: Medio Tiempo

    /**
     * Constructor de la clase Tutor con atributos propios y heredados de la
     * clase Usuario
     * 
     * @param disponibilidad
     * @param tipoProfesor
     * @param idUsuario
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param nombres 
     */
    public Tutor(boolean disponibilidad, int tipoProfesor, int idUsuario, 
            String apellidoPaterno, String apellidoMaterno, String nombres) {
        super(idUsuario, apellidoPaterno, apellidoMaterno, nombres);
        this.disponibilidad = disponibilidad;
        this.tipoProfesor = tipoProfesor;
    }
        
    /**
     * Constructor heredado
     * @param usuario
     * @param password 
     */
    public Tutor(String usuario, String password) {
        super(usuario, password);
    }
    
    /**
     * Sobreescritura del método toString
     * @return 
     * retorna un valor String con el nombre completo del Tutor
     */
    @Override
    public String toString(){
        return nombre + " " +apellidoPaterno+" "+apellidoMaterno;
    }
}
