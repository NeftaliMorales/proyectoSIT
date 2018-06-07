/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

public class Coordinador extends Usuario{

    /**
     * Constructor de la clase Coordinador con atributos heredados de la clase 
     * Usuario
     * 
     * @param idUsuario
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param nombres 
     */
    public Coordinador(int idUsuario, String apellidoPaterno, String apellidoMaterno, String nombres) {
        super(idUsuario, apellidoPaterno, apellidoMaterno, nombres);
    }    
    
    /**
     * Constructor heredado
     * @param usuario
     * @param password 
     */
    public Coordinador(String usuario, String password) {
        super(usuario, password);
    }
        
    public boolean generarListaAsignacion(){
        return true;
    }
    
    public boolean generarListaAsistencia(Tutor tutor){
        return true;
    }
    
    @Override
    public String toString(){
        return "Coordinador";
    }
}
