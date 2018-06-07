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
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectosit.Conexion;
import proyectosit.Coordinador;
import proyectosit.Tutor;
import proyectosit.Usuario;

public class InicioSesionDao implements InicioSesionDAO{

    public InicioSesionDao() {
    }
    
    @Override
    public Usuario consultarUsuario(String user) throws SQLException{
        Usuario usuario;
        String nombreUsuario = user;
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql= "SELECT * FROM `usuario` WHERE BINARY `nombreUsuario` = '"+nombreUsuario+"'";
        rs = conn.consultar(sql);
        rs.next();
        usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        return usuario;
    }

    @Override
    public Usuario consultarUsuario(int idUsuario, int tipoUsuario) throws SQLException{
        Usuario usuario = null;
        if(tipoUsuario == 1){            
            Conexion conn = new Conexion();
            ResultSet rs;
            String sql= "SELECT * FROM `coordinador` WHERE `idUsuario` = "+ idUsuario +"";
            rs = conn.consultar(sql);
            rs.next();
            usuario = new Coordinador(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(2));
            conn.cerrar();
        }
        if(tipoUsuario == 2){
            Conexion conn = new Conexion();
            ResultSet rs;
            String sql= "SELECT * FROM `tutor` WHERE `idUsuario` = "+ idUsuario +"";
            rs = conn.consultar(sql);
            rs.next();
            usuario = new Tutor(rs.getBoolean(6), rs.getInt(5), rs.getInt(1), rs.getString(3), rs.getString(4), rs.getString(2));
            conn.cerrar();
        }
        return usuario;
    }
}
