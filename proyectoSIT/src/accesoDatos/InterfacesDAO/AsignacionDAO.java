/**
 * Interfaz de acceso a datos Asignacion, incluye métodos de conexión para las
 * clases Tutorado y Tutor del modulo Asignación de Tutorados.
 *
 * @author edson
 * @since 07/06/18
 * @version 07/06/18
 */
package accesoDatos.InterfacesDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import proyectosit.Tutor;
import proyectosit.Tutorado;

public interface AsignacionDAO {
    
    public ArrayList<Tutor> recuperarTutores() throws SQLException;
    public ArrayList<Tutorado> recuperarTutorados() throws SQLException;
    
}
