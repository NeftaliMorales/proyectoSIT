/**
 * @autor Gabriela Sandoval Cruz
 * @autor Jose Rodrigo Ordóñes Pacheco
 * @autor Edson Neftali Melgarejo Morales
 * @since 30/05/18
 */
package proyectosit;

import accesoDatos.clasesDAO.TutoriaDao;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tutoria {
    private int idTutoria;
    private String comentarios;
    private Date fecha;
    private int numSesion;
    
    private ArrayList<Integer> problemasReportados;
    
    /**
     * Metodo que se comunica con la clase DAO TutoriaDao para registrar la
     * sesión de tutoria en la DB.
     * @return true si la operación fue exitosa
     */
    public boolean registrarSesion(String matriculaTutorado, int idTutor) throws SQLException{
        this.idTutoria = calcularID();
        this.fecha = Date.valueOf("2018-06-08");
        this.numSesion = 1;
        TutoriaDao tDao = new TutoriaDao();
        tDao.guardarSesionTutoria(this, matriculaTutorado, idTutor);
        return true;
    }
    
    private Date calcularFecha(){
        int dia = Calendar.DAY_OF_MONTH;
        int mes = Calendar.MONTH;
        int año = Calendar.YEAR;
        Date fecha = Date.valueOf(año+"-"+mes+"-"+dia);
        return fecha;
    }
    private int calcularID(){
        TutoriaDao tDao = new TutoriaDao();
        try {
            int id = tDao.obtenerId();
            id = id + 1;
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(Tutoria.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumSesion(int numSesion) {
        this.numSesion = numSesion;
    }
    
    public void setProblema(int idP){
        problemasReportados.add(idP);
    }

    public int getIdTutoria() {
        return idTutoria;
    }

    public String getComentarios() {
        return comentarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getNumSesion() {
        return numSesion;
    }

    public ArrayList<Integer> getProblemasReportados() {
        return problemasReportados;
    }
    
}
