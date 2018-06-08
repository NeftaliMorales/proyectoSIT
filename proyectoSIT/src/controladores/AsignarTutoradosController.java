/**
 * Clase controlador de la interfaz grafica asignarTutoradosGUI.fxml
 * 
 * 
 * 
 * @author Edson Melgarejo
 * @since 06/06/18
 * @version 07/06/18
 */
package controladores;

import accesoDatos.clasesDAO.AsignacionDao;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import proyectosit.Coordinador;
import proyectosit.Tutor;
import proyectosit.Tutorado;

public class AsignarTutoradosController implements Initializable {

    ResourceBundle rb;
    
    private static Coordinador coordinador;
    
    private @FXML Label nombreUsuario;
    private @FXML ListView<Tutorado> tutorados;
    private @FXML ListView<Tutor> tutores;
    private @FXML CheckBox seleccionarTodos;
    private @FXML Button asignar;
    
    private ArrayList<Tutorado> tutoradosList;
    private ArrayList<Tutor> tutoresList;
    private ObservableList<Tutorado> tutoradosSeleccionados;
    Tutor tutorSeleccionado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rb = rb;
        this.nombreUsuario.setText(coordinador.getNombre() + " " +
                coordinador.getApellidoPaterno() + " " +
                coordinador.getApellidoMaterno());
        
        llenarListaTutorados();
        llenarListaTutores();
        
        tutorados.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        seleccionarTodos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(seleccionarTodos.isSelected()){
                    tutorados.getSelectionModel().selectAll();
                    tutoradosSeleccionados = tutorados.getSelectionModel().getSelectedItems();
                } else {
                    tutorados.getSelectionModel().clearSelection();
                    tutoradosSeleccionados = null;
                }
            }
        });
        tutorados.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tutoradosSeleccionados = tutorados.getSelectionModel().getSelectedItems();
            }
        });
        tutores.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tutorSeleccionado = tutores.getSelectionModel().getSelectedItem();
            }
        });
        asignar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(tutorSeleccionado == null || tutoradosSeleccionados == null){
                    JOptionPane.showMessageDialog(null, rb.getString("msgErrorSeleccionAsignacion"));
                } else {
                    for(int i = 0; i < tutoradosSeleccionados.size(); i++){
                        Tutorado tutoradoSeleccionado = tutoradosSeleccionados.get(i);
                        tutoradoSeleccionado.asignarTutor(tutorSeleccionado);
                        System.err.println(tutoradoSeleccionado.getNombres());
                        System.err.println(tutorSeleccionado.getNombre());
                    }
                }
            }
        });
    }    
    
    /**
     * Metodo que se comunica con la clase DAO asignacionDao para recuperar los
     * Tutores de la base de datos y llenar la lista tutores
     */
    private void llenarListaTutores(){
        try {
            AsignacionDao aDao = new AsignacionDao();
            tutoresList = aDao.recuperarTutores();
            for(int i = 0; i < tutoresList.size(); i++){
                tutores.getItems().add(tutoresList.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignarTutoradosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodo que se comunica con la clase DAO asignacionDao para recuperar los
     * Tutorados de la base de datos y llenar la lista tutorados
     */
    private void llenarListaTutorados(){
        try {
            AsignacionDao aDao = new AsignacionDao();
            tutoradosList = aDao.recuperarTutorados();
            for(int i = 0; i < tutoradosList.size(); i++){
                tutorados.getItems().add(tutoradosList.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignarTutoradosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que asigna el Usuario que ingresa en la ventana IngresarSesion
     * @param coordinador 
     */
    public static void setUsuario(Coordinador coordinador){
        AsignarTutoradosController.coordinador = coordinador;
    }
}
