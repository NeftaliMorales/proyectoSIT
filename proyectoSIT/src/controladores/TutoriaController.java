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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import proyectosit.Problema;
import proyectosit.Tutor;
import proyectosit.Tutorado;

public class TutoriaController implements Initializable {

    private ResourceBundle rb;
    
    private static Tutor tutor;
    
    //Seleccionar Tutorado
    private @FXML Label nombreUsuario;
    private @FXML TextField buscarTutorado;
    private @FXML ListView<Tutorado> tutorados;
    
    //Sesion
    private @FXML Label nombreTutorado;
    private @FXML Label matriculaTutorado;
    private @FXML Label carreraTutorado;
    private @FXML Label semestreTutorado;

    
    //Problema
    private @FXML Button agregarProblema;
    private @FXML TextField descripcionProblema;
    private @FXML ComboBox<String> tipoProblema;
    private @FXML TextField nombreProblema;
    private @FXML TextField profesorEE;
    private @FXML Button guardarProblema;
    
    private @FXML Label lbDesc;
    private @FXML Label lbTipoP;
    private @FXML Label lbNombreP;
    private @FXML Label lbProfeP;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rb = rb;
        this.nombreUsuario.setText(tutor.getNombre() + " " +
                tutor.getApellidoPaterno() + " " +
                tutor.getApellidoMaterno());
        
        llenarListaTutorados();
        
        this.tipoProblema.getItems().addAll("Experiencia Educativa", "Depto/Servicio");
        
        tutorados.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mostrarInfo(tutorados.getSelectionModel().getSelectedItem());
            }
        });
        
        agregarProblema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mostrarCamposProblema();
            }
        });
        tipoProblema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int tipo = tipoProblema.getSelectionModel().getSelectedIndex();
                if(tipo == 0){                    
                    lbNombreP.setText(rb.getString("lbEE"));
                    lbNombreP.setVisible(true);
                    nombreProblema.setVisible(true);
                    lbProfeP.setVisible(true);
                    profesorEE.setVisible(true);
                    guardarProblema.setVisible(true);
                }
                if(tipo == 1){
                    lbNombreP.setText(rb.getString("lbDpto/serv"));
                    lbNombreP.setVisible(true);
                    profesorEE.setVisible(false);
                    lbProfeP.setVisible(false);
                    nombreProblema.setVisible(true);
                    guardarProblema.setVisible(true);
                }
            }
        });
        guardarProblema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                guardarProblema();
            }
        });
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
     * Método que muestra la información del tutorado que se selecciono.
     * @param tutorado Tutorado seleccionado de la lista tutorados.
     */
    private void mostrarInfo(Tutorado tutorado){
        this.nombreTutorado.setText(tutorado.getNombres()+" "+
                tutorado.getApellidoPaterno()+" "+tutorado.getApellidoMaterno());
        this.matriculaTutorado.setText(tutorado.getMatricula());
        this.carreraTutorado.setText(tutorado.getCarrera());
        this.semestreTutorado.setText(String.valueOf(tutorado.getSemestre())+"°");
    }
    
    private void mostrarCamposProblema(){
        lbDesc.setVisible(true);
        lbTipoP.setVisible(true);
        descripcionProblema.setVisible(true);
        tipoProblema.setVisible(true);
    }
    
    /**
     * Método que registra un nuevo problema en la base de datos.
     */
    private void guardarProblema(){
        String descripcion = descripcionProblema.getText();
        int tipo = tipoProblema.getSelectionModel().getSelectedIndex();
        String nombre = nombreProblema.getText();
        String profesor = profesorEE.getText();
        boolean validados;
        if(tipo == 0){
            validados = validarTextosProblema(descripcion, nombre, profesor);
            if(validados == true){                
                Problema problema = new Problema(descripcion, tipo, nombre, profesor);
                TutoriaDao tDao = new TutoriaDao();
                try {
                    tDao.guardarProblema(problema);
                } catch (SQLException ex) {
                    Logger.getLogger(TutoriaController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, rb.getString("msgErrorGuardar"));
                }
            } else{
                JOptionPane.showMessageDialog(null, rb.getString("msgCompletarDatos"));
            }
        }
        if(tipo == 1){
            validados = validarTextosProblema(descripcion, nombre);
            if(validados == true){
                Problema problema = new Problema(descripcion, tipo, nombre);
                TutoriaDao tDao = new TutoriaDao();
                try {
                    tDao.guardarProblema(problema);
                } catch (SQLException ex) {
                    Logger.getLogger(TutoriaController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, rb.getString("msgErrorGuardar"));
                }
            } else{
                JOptionPane.showMessageDialog(null, rb.getString("msgCompletarDatos"));
            }
        }
    }
    
    private boolean validarTextosProblema(String desc, String nomb, String prof){
        return !(desc.equals("") || nomb.equals("") || prof.equals(""));
    }
    private boolean validarTextosProblema(String desc, String nomb){
        return !(desc.equals("") || nomb.equals(""));
    }
    
    /**
     * Método que asigna el Usuario que ingresa en la ventana IngresarSesion
     * @param tutor 
     */
    public static void setUsuario(Tutor tutor){
        TutoriaController.tutor = tutor;
    }
    
}
