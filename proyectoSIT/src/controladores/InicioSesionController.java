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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import proyectosit.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import proyectosit.Coordinador;
import proyectosit.Tutor;

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
            try {
                Usuario usuario = new Usuario(nombreUsuario, passwordUsuario);
                usuario = usuario.ingresarSistema();
                if(usuario == null){
                    JOptionPane.showMessageDialog(null, rb.getString("msgErrorPassword"));
                    this.passwordUsuario.clear();
                } else{                
                    recuperarUsuario(usuario);
                }
            } catch (SQLException ex) {
                Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, rb.getString("msgErrorUser"));
            } catch (NullPointerException ex){
                Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, rb.getString("msgErrorDB"));
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
    private void logIn(int tipo, Usuario user) {
        if(tipo == 1){
            try {
                MenuCoordinadorController.setUsuario((Coordinador) user);
                Parent root = FXMLLoader.load(getClass().getResource("/interfacesGraficas/menuCoordinadorGUI.fxml"), rb);                                
                
                Stage stage = new Stage();                                                
                Scene scene = new Scene(root);
                
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setTitle(rb.getString("tituloG"));
                stage.show();                
                this.cerrar();
            } catch (IOException ex) {
                Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                TutoriaController.setUsuario((Tutor) user);
                Parent root = FXMLLoader.load(getClass().getResource("/interfacesGraficas/tutoriaGUI.fxml"), rb);
                
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                
                stage.setScene(scene);                
                stage.setMaximized(true);
                //stage.setResizable(false);
                stage.setMinHeight(750);
                stage.setMinWidth(1358);
                stage.setTitle(rb.getString("tituloG"));
                stage.show();
                this.cerrar();
            } catch (IOException ex) {
                Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Método que recupera el usuario que ingresara al sistema
     * 
     * @param usuario Parametro proporcionado por el método crearUsuario
     */
    private void recuperarUsuario(Usuario usuario){
        try {
            InicioSesionDao isDao = new InicioSesionDao();
            Usuario user = isDao.consultarUsuario(usuario.getIdUsuario(), usuario.getTipoUsuario());
            if(user.toString().equals("Coordinador")){
                logIn(1, user);
            } else {
                logIn(2, user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InicioSesionController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, rb.getString("msgErrorDB"));
        }
    }
    
    private void cerrar(){
        Stage stage = (Stage) this.iniciarSesion.getScene().getWindow();
        stage.close();
    }
}
