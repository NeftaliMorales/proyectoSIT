/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

public class Coordinador extends Usuario{

    public Coordinador(String usuario, String password) {
        super(usuario, password);
    }
    
    public boolean generarListaAsignacion(){
        return true;
    }
    
    public boolean generarListaAsistencia(Tutor tutor){
        return true;
    }
}
