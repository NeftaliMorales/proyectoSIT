/**
 * Clase controlador de la interfaz grafica menuCoordinadorGUI.fxml
 * 
 * @author Edson Melgarejo
 * @since 28/05/18
 */
package controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import proyectosit.Coordinador;

public class MenuCoordinadorController implements Initializable {        

    private ResourceBundle rb;
    
    private static Coordinador coordinador;
    
    private @FXML Label nombreUsuario;
    private @FXML Button asignarTutorados;
    private @FXML Button salir;
    
    @Override
    public void initialize(URL location, ResourceBundle rb) {        
        this.rb = rb;
        this.nombreUsuario.setText(coordinador.getNombre() + " " +
                coordinador.getApellidoPaterno() + " " +
                coordinador.getApellidoMaterno());
        asignarTutorados.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cargarInterfazAsignarTutorados();
            }
        });
        
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/interfacesGraficas/inicioSesionGUI.fxml"), rb);
                    
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.setTitle(rb.getString("tituloG"));
                    stage.show();
                    cerrar();
                } catch (IOException ex) {
                    Logger.getLogger(MenuCoordinadorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void cargarInterfazAsignarTutorados(){
        try {
            AsignarTutoradosController.setUsuario(coordinador);
            Parent root = FXMLLoader.load(getClass().getResource("/interfacesGraficas/asignarTutoradosGUI.fxml"), rb);
            
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(rb.getString("tituloG"));
            stage.show();
            this.cerrar();
        } catch (IOException ex) {
            Logger.getLogger(MenuCoordinadorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que asigna el Usuario que ingresa en la ventana IngresarSesion
     * @param coordinador 
     */
    public static void setUsuario(Coordinador coordinador){
        MenuCoordinadorController.coordinador = coordinador;
    }
    
    private void cerrar(){
        Stage stage = (Stage) this.asignarTutorados.getScene().getWindow();
        stage.close();
    }
}
