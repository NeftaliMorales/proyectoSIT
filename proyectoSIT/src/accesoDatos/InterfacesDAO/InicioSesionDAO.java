/**
 * Interfaz de acceso a datos InicioSesion, incluye métodos de conexión para las
 * clases Usuario, Coordinador y Tutor del modulo InisioSesion.
 *
 * @author edson
 * @since 03/06/18
 * @version 03/06/18
 */
package accesoDatos.InterfacesDAO;

import proyectosit.Usuario;

public interface InicioSesionDAO {

    public Usuario consultarUsuario(String nombreUsuario);
    public Usuario consultarUsuario(int idUsuario, int tipoUsuarios);
}
