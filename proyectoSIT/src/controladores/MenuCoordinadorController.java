/**
 * Clase controlador de la interfaz grafica menuCoordinadorGUI.fxml
 * 
 * @author Edson Melgarejo
 * @since 28/05/18
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import proyectosit.Coordinador;
import proyectosit.Usuario;

public class MenuCoordinadorController implements Initializable {        

    private ResourceBundle rb;
    
    private static Coordinador coordinador;
    
    private @FXML Label nombreUsuario;       
    
    @Override
    public void initialize(URL location, ResourceBundle rb) {        
        this.rb = rb;
        this.nombreUsuario.setText(coordinador.getNombre() + " " +
                coordinador.getApellidoPaterno() + " " +
                coordinador.getApellidoMaterno());
    }
    
    
    /**
     * Método que asigna el Usuario que ingresa en la ventana IngresarSesion
     * @param coordinador 
     */
    public static void setUsuario(Coordinador coordinador){
        MenuCoordinadorController.coordinador = coordinador;
    }
}
