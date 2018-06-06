/**
 * Clase controlador de la interfaz grafica inicioSesionGUI.fxml
 * 
 * Contiene metodos para realizar la validación del inicio de sesión.
 * 
 * @author Edson Melgarejo
 * @since 27/05/18
 */
package controladores;

import accesoDatos.clasesDAO.InicioSesionDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import proyectosit.Usuario;
import accesoDatos.clasesDAO.InicioSesionDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javax.swing.JOptionPane;

public class InicioSesionController implements Initializable {
    
    private ResourceBundle rb;
    
    private @FXML TextField nombreUsuario;
    private @FXML PasswordField passwordUsuario;
    private @FXML Button iniciarSesion;

    public InicioSesionController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rb = rb;
        iniciarSesion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                crearUsuario();
            }
        });
    }    
    
    /**
     * Este método crea el objeto Usuario a partir de los datos que se ingresen
     * por el usuario del sistema en la interfaz grafica inicioSesionGUI
     */
    public void crearUsuario() {        
        String nombreUsuario = this.nombreUsuario.getText();
        String passwordUsuario = this.passwordUsuario.getText();        
        if(validarCamposDeTexto(nombreUsuario, passwordUsuario) == true) {
            Usuario usuario = new Usuario(nombreUsuario, passwordUsuario);
            usuario = usuario.ingresarSistema();
            if(usuario == null){
                JOptionPane.showMessageDialog(null, rb.getString("msgErrorPassword"));
            } else{
                recuperarUsuario(usuario);                
            }
        } else {
            JOptionPane.showMessageDialog(null, rb.getString("msgLoginCamposIncompletos"));
        }        
    }
    
    /**
     * Método que valida que los campos de texto nombreUsuario y passwordUsuario
     * no esten vacios.
     * 
     * Parametros Insertado por el método crearUsuario.
     * @param usuario 
     * @param password
     * @return 
     */
    private boolean validarCamposDeTexto(String usuario, String password) {
        return !(usuario.equals("") || password.equals(""));
    }    
    
    /**
     * Metodo que carga la interfaz de usuario de Coordinador o Tutor
     * dependiendo del tipo de usuario que ingrese.
     */
    private void logIn() {
        
    }
    
    /**
     * Método que recupera el usuario que ingresara al sistema
     * 
     * @param idUsuario 
     */
    private void recuperarUsuario(Usuario usuario){
        
    }
}
