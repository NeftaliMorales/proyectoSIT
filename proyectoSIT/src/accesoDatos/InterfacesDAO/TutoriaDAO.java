/**
 * Interfaz de acceso a datos Tutoria, incluye métodos de conexión para las
 * clases Tutotado, Tutoria y Problema del modulo Tutoria.
 *
 * @author edson
 * @since 07/06/18
 * @version 07/06/18
 */
package accesoDatos.InterfacesDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import proyectosit.Tutorado;

public interface TutoriaDAO {
    public ArrayList<Tutorado> recuperarTutorados(int idTutor) throws SQLException;
}
