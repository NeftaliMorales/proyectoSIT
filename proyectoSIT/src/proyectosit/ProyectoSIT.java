/**
 * ------------------------------ENCABEZADO------------------------------
 * Nombre del Programa: Sistema Integral de Tutorias (SIT)
 * @autor Gabriela Sandoval Cruz
 * @autor Jose Rodrigo Ordóñes Pacheco
 * @autor Edson Neftali Melgarejo Morales
 * @since 16/Mayo/2018
 * Descripción: El Sistema de Tutorías (SIT) de la Universidad Veracruzana (UV)
 *      es el responsable de ayudarle al tutor a brindarle orientación al 
 *      estudiante en las decisiones relacionadas con su formación profesional
 *      de acuerdo con sus expectativas, capacidades e intereses.
 * @version: alpha 0.1.0.0  16/05/2018
 */

package proyectosit;

import java.io.IOException;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ProyectoSIT extends Application {
    
    private static String idioma = "resources.idioma";
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        ResourceBundle bundle = ResourceBundle.getBundle(idioma);
        Parent root = FXMLLoader.load(getClass().getResource("/interfacesGraficas/inicioSesionGUI.fxml"), bundle);
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        Image icono = new Image("/imagenes/Logo SIT.png");
        primaryStage.getIcons().add(icono);
        primaryStage.setResizable(false);
        primaryStage.setTitle(bundle.getString("tituloG"));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
