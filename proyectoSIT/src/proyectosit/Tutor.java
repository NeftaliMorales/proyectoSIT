/**
 * @author edson
 * @since 30/05/18
 */
package proyectosit;

public class Tutor extends Usuario{
    private boolean disponibilidad;
    private int tipoProfesor;

    public Tutor(String usuario, String password) {
        super(usuario, password);
    }
}
