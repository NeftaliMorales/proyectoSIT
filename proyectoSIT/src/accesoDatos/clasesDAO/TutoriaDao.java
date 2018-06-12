/**
 * Clase que implementa los métodos de la interfaz TutoriaDAO para la
 * tecnologia sql.
 * 
 * @author edson
 * @since 07/06/18
 * @version 07/06/18
 */
package accesoDatos.clasesDAO;

import accesoDatos.InterfacesDAO.TutoriaDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import proyectosit.Conexion;
import proyectosit.Problema;
import proyectosit.Tutorado;
import proyectosit.Tutoria;

public class TutoriaDao implements TutoriaDAO{

    public TutoriaDao() {
    
    }
    
    /**
     * Método que recupera los tutorados correspondientes al tutor que ingreso
     * al sistema
     * @param idTutor 
     * Proporcionado por el método llenarListaTutorados() de la interface Tutoria
     * @return tutorados
     * Regresa un ArrayList de Tutorados
     * @throws SQLException 
     */
    @Override
    public ArrayList<Tutorado> recuperarTutorados(int idTutor) throws SQLException{
        
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql = ("SELECT `matriculaTutorado` FROM `periodo` WHERE `idTutor` = "+ idTutor);
        rs = conn.consultar(sql);
        ArrayList<String> matriculas = new ArrayList<>();
        while(rs.next()){
            matriculas.add(rs.getString(1));
        }
        
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        String sql2;
        for(int i = 0; i < matriculas.size(); i++){
            sql2 = ("SELECT * FROM `tutorado` WHERE `matricula` = '"+ matriculas.get(i) +"'");
            rs = conn.consultar(sql2);
            rs.next();
            Tutorado tutorado = new Tutorado(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), 
                    rs.getInt(6), rs.getInt(7));
            tutorados.add(tutorado);
        }
        conn.cerrar();
        return tutorados;
    }

    /**
     * Método que guarda un Problema en la base de datos
     * @param problema 
     * Proporcionado por el método guardarProblema de la interface Tutoria
     * @return flag
     * Valor boolean que indica si se realizo la orden
     * @throws SQLException 
     */
    @Override
    public boolean guardarProblema(Problema problema) throws SQLException {
        Conexion conn = new Conexion();
        String sql;
        if(problema.getTipoProblema() == 0){
            sql="INSERT INTO `problema`(`tipoProblema`, `experienciaEducativa`, "
                    + "`profesor`, `descripcionProblema`, `numAlumnos`) VALUES "
                    + "("+problema.getTipoProblema()+",'"+problema.getExperienciaEducativa()
                    +"','"+problema.getProfesorEE()+"','"+problema.getDescripcion()+"', 0)";
        } else{
            sql="INSERT INTO `problema`(`tipoProblema`, `depto_servicio`, "
                    + "`descripcionProblema`, `numAlumnos`) VALUES "
                    + "("+problema.getTipoProblema()+",'"+problema.getDepto_servicio()+"'"
                    + ",'"+problema.getDescripcion()+"', 0)";
        }
        boolean flag = conn.ejecutar(sql);
        conn.cerrar();
        return flag;
    }

    /**
     * Método que recupera los Problemas registrados en la DB
     * @return
     * problemas ArrayList que contiene los Problemas encontrados
     * @throws SQLException 
     */
    @Override
    public ArrayList<Problema> recuperarProblemas() throws SQLException {
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql = "SELECT * FROM `problema`";
        rs = conn.consultar(sql);
        Problema problema;
        ArrayList<Problema> problemas = new ArrayList<>();
        while(rs.next()){
            if(rs.getInt(2) == 0){
                problema = new Problema(rs.getInt(1), rs.getString(6), rs.getInt(2), rs.getString(4), rs.getString(5), rs.getInt(7));
            } else {
                problema = new Problema(rs.getInt(1), rs.getString(6), rs.getInt(2), rs.getString(3), rs.getInt(7));
            }
            problemas.add(problema);
        }
        return problemas;
    }
    
    /**
     * Método que guarda la sesion de Tutoria en la DB
     * @param sesion
     * proporcionado por el metodo registrarSesion de la clase Tutoria
     * @param matricula
     * proporcionado por el metodo registrarSesion de la clase Tutoria
     * @param idTutor
     * proporcionado por el metodo registrarSesion de la clase Tutoria
     * @return flag
     * Valor booleano que indica si la sesion fue registrada correctamente en la
     * DB
     * @throws SQLException 
     */
    @Override
    public boolean guardarSesionTutoria(Tutoria sesion, String matricula, int idTutor) throws SQLException {
        Conexion conn = new Conexion();
        String sql = "INSERT INTO `tutoria`(`idTutoria`, `fechaTutoria`, "
                + "`numeroSesion`, `comentario`) VALUES ("+sesion.getIdTutoria()+""
                + ", '2018-06-08',"+sesion.getNumSesion()+",'"+sesion.getComentarios()+"')";
        boolean flag = conn.ejecutar(sql);
        conn.cerrar();
        System.out.println(sesion.getProblemasReportados());
        if(sesion.getProblemasReportados() == null){
            
        } else {
            if(sesion.getProblemasReportados().size() > 0){
                for(int i = 0; i < sesion.getProblemasReportados().size(); i++){
                    conn = new Conexion();
                    sql = "INSERT INTO `tutoria_problema`(`idTutoria`, `idProblema`) "
                            + "VALUES ("+sesion.getIdTutoria()+","+sesion.getProblemasReportados().get(i)+"";
                    conn.ejecutar(sql);
                }
            conn.cerrar();
            }
        }
        int idPeriodo = obtenerIdPeriodo(matricula, idTutor);
        conn = new Conexion();
        sql = "INSERT INTO `periodo_tutoria`(`idPeriodo`, `idTutoria`) "
                + "VALUES ("+ idPeriodo +","+sesion.getIdTutoria() +")";
        conn.ejecutar(sql);
        conn.cerrar();
        return flag;
    }
    /**
     * Método usado por el método guardarSesionTutoria.
     * @param matricula
     * @param idTutor
     * @return
     * @throws SQLException 
     */
    private int obtenerIdPeriodo(String matricula, int idTutor) throws SQLException{
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql = "SELECT * FROM `periodo` WHERE `matriculaTutorado` = '"
                + matricula +"' AND `idTutor` = "+ idTutor;
        rs = conn.consultar(sql);
        rs.next();
        int idPeriodo = rs.getInt(1);
        return idPeriodo;
    }
    
    /**
     * Método que obtiene el valor maximo del campo idTutoria de la DB
     * @return id
     * Valor entero que representa el id Maximo de las Tutorias registradas.
     * @throws SQLException 
     */
    public int obtenerId() throws SQLException{
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql = "SELECT MAX(`idTutoria`) FROM `tutoria`";
        rs = conn.consultar(sql);
        if(rs == null){
            return 0;
        } else {
            rs.next();
            int id = rs.getInt(1);
            return id;
        }
    }
    
    public void aumentarProblema(int valor, int id) throws SQLException{
        Conexion conn = new Conexion();
        String sql= "UPDATE `problema` SET `numAlumnos` = '" + valor +"' WHERE `problema`.`idProblema` = "+ id;
        conn.ejecutar(sql);
        conn.cerrar();
    }
}
