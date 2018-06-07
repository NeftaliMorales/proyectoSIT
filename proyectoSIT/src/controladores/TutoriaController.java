/**
 * Clase controlador de la interfaz grafica tutoriaGUI.fxml
 * 
 * @author Edson Melgarejo
 * @since 28/05/18
 */
package controladores;

import accesoDatos.clasesDAO.TutoriaDao;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javax.swing.JOptionPane;
import proyectosit.Tutor;
import proyectosit.Tutorado;

public class TutoriaController implements Initializable {

    private ResourceBundle rb;
    
    private static Tutor tutor;
    
    private @FXML Label nombreUsuario;
    private @FXML TextField buscarTutorado;
    private @FXML ListView<Tutorado> tutorados;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rb = rb;
        this.nombreUsuario.setText(tutor.getNombre() + " " +
                tutor.getApellidoPaterno() + " " +
                tutor.getApellidoMaterno());
        
        llenarListaTutorados();
    }    
    
    /**
     * Método que se comunica con la clase TutoriaDao para recuperar los
     * Tutorados de la base de datos y llenar la listview tutorados.
     */
    private void llenarListaTutorados(){
        try {
            ArrayList<Tutorado> tutoradosList;
            TutoriaDao tDao = new TutoriaDao();
            tutoradosList = tDao.recuperarTutorados(tutor.getIdUsuario());
            if(tutoradosList == null){
                JOptionPane.showMessageDialog(null, rb.getString("msgTutoradosNull"));
            } else {
                for(int i = 0; i < tutoradosList.size(); i++){
                    tutorados.getItems().add(tutoradosList.get(i));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TutoriaController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, rb.getString("msgErroDB"));
        }
    }
    
    /**
     * Método que asigna el Usuario que ingresa en la ventana IngresarSesion
     * @param tutor 
     */
    public static void setUsuario(Tutor tutor){
        TutoriaController.tutor = tutor;
    }
    
}
