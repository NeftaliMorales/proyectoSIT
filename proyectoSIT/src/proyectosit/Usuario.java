/**
 * @author Edson Melgarejo
 * @since 30/05/18
 */
package proyectosit;

import accesoDatos.clasesDAO.InicioSesionDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuario {
    
    private int idUsuario;
    private String nombreUsuario;
    private String password;
    private int tipoUsuario;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String nombre;

    /**
     * Constructor con los parametros heredados a las clases hijo.
     * @param idUsuario
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param nombre 
     */
    public Usuario(int idUsuario, String apellidoPaterno, String apellidoMaterno, String nombres) {
        this.idUsuario = idUsuario;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombre = nombres;
    }
    
    /**
     * Constructor con dos parametros de la clase Usuario.
     * @param usuario
     * @param password 
     */
    public Usuario(String usuario, String password) {
        this.nombreUsuario = usuario;
        this.password = password;
    }
    
    /**
     * Constructor con un parametro de la clase Usuario
     * @param usuario 
     */
    public Usuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    /**
     * Constructor con todos los parametros privados de la clase Usuario
     * @param idUsuario
     * @param nombreUsuario
     * @param password
     * @param tipoUsuario 
     */
    public Usuario(int idUsuario, String nombreUsuario, String password, int tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }
    
    /**
     * Método que realiza la validación del usuario, usa la clase DAO
     * InicioSesionDao para consultar en la base de datos al usuario.
     * @return  [en caso de ser exitoso]usuario2 tipo objeto Usuario 
     * que contiene los datos del usuario deseado.
     * [en caso de no ser exitoso] null
     */
    public Usuario ingresarSistema() throws SQLException{
        InicioSesionDao isDao = new InicioSesionDao();
        Usuario usuario2 = isDao.consultarUsuario(this.nombreUsuario);
        if(this.password.equals(usuario2.getPassword())){
            return usuario2;
        } else {
            return null;
        }
        
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNombre() {
        return nombre;
    }
    
}
