/**
 * Interfaz de acceso a datos Asignacion, incluye la definición métodos de 
 * conexión para las clases Tutorado y Tutor del modulo Asignación de Tutorados.
 *
 * @autor Gabriela Sandoval Cruz
 * @autor Jose Rodrigo Ordóñes Pacheco
 * @autor Edson Neftali Melgarejo Morales
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
    public boolean guardarPeriodo(String periodo, String matricula, int idTutor) throws SQLException;
}
