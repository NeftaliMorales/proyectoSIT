/**
 * Interfaz de acceso a datos InicioSesion, incluye métodos de conexión para las
 * clases Usuario, Coordinador y Tutor del modulo InisioSesion.
 *
 * @autor Gabriela Sandoval Cruz
 * @autor Jose Rodrigo Ordóñes Pacheco
 * @autor Edson Neftali Melgarejo Morales
 * @since 03/06/18
 * @version 03/06/18
 */
package accesoDatos.InterfacesDAO;

import java.sql.SQLException;
import proyectosit.Usuario;

public interface InicioSesionDAO {

    public Usuario consultarUsuario(String nombreUsuario) throws SQLException;
    public Usuario consultarUsuario(int idUsuario, int tipoUsuarios) throws SQLException;
}
