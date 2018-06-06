/**
 * Clase que implementa los métodos de la interfaz InicioSesionDAO para la
 * tecnologia sql.
 * 
 * @author edson
 * @since 03/06/18
 * @version 03/06/18
 */
package accesoDatos.clasesDAO;

import accesoDatos.InterfacesDAO.InicioSesionDAO;
import proyectosit.Usuario;

public class InicioSesionDao implements InicioSesionDAO{

    public InicioSesionDao() {
    }
    
    @Override
    public Usuario consultarUsuario(String user) {
        Usuario usuario;
        String nombreUsuario = "";
        //consulta
        usuario = new Usuario(nombreUsuario);
        return usuario;
    }

    @Override
    public Usuario consultarUsuario(int idUsuario, int tipoUsuario) {
        Usuario usuario = null;
        if(tipoUsuario == 1){
            //Consulta de coordinador
        }
        if(tipoUsuario == 2){
            //Consulta de Tutor
        }
        return usuario;
    }
}
