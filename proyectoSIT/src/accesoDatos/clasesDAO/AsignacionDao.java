/**
 * Clase que implementa los métodos de la interfaz asignacionDAO para la
 * tecnologia sql.
 * 
 * @author edson
 * @since 07/06/18
 * @version 07/06/18
 */
package accesoDatos.clasesDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import proyectosit.Tutor;
import proyectosit.Tutorado;
import accesoDatos.InterfacesDAO.AsignacionDAO;
import java.sql.ResultSet;
import proyectosit.Conexion;

public class AsignacionDao implements AsignacionDAO{

    /**
     * Método que recupera los Tutores que se encentran disponibles para
     * asignarle un Tutorado
     * @return tutores
     * ArrayList de Tutores que retorna todos los Tutores disponibles en la DB.
     * @throws SQLException 
     */
    @Override
    public ArrayList<Tutor> recuperarTutores() throws SQLException {
        ArrayList<Tutor> tutores = new ArrayList<>();
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql = "SELECT * FROM `tutor` WHERE `disponibilidad` = 1";
        rs = conn.consultar(sql);
        while(rs.next()){
            Tutor tutor = new Tutor(rs.getBoolean(6), rs.getInt(5), rs.getInt(1),
                    rs.getString(3), rs.getString(4), rs.getString(2));
            tutores.add(tutor);
        }
        conn.cerrar();
        return tutores;
    }

    /**
     * Método que recupera todos los Tutorados que aun no poseen un tutor
     * asignado, ordenados en orden alfabetico.
     * @return tutorados
     * ArrayList de Tutorados que retorna todos los Tutorados disponibles para 
     * asignar
     * @throws SQLException 
     */
    @Override
    public ArrayList<Tutorado> recuperarTutorados() throws SQLException {
        ArrayList<Tutorado> tutorados = new ArrayList<>();
        Conexion conn = new Conexion();
        ResultSet rs;
        String sql = "SELECT * FROM `tutorado` WHERE `estado` = 0 ORDER BY "
                + "`tutorado`.`nombre` ASC";
        rs = conn.consultar(sql);
        while(rs.next()){
            Tutorado tutorado = new Tutorado(rs.getString(1), rs.getString(2), 
                    rs.getString(3), rs.getString(4), rs.getString(5), 
                    rs.getInt(6), rs.getInt(7));
            tutorados.add(tutorado);
        }
        conn.cerrar();
        return tutorados;
    }

    /**
     * Método que guarda la relación de tiempo entre un Tutor y su Tutorado.
     * @param periodo
     * Parametro ingresado por el método asignarTutor de la clase Tutorado
     * @param matricula
     * Parametro ingresado por el método asignarTutor de la clase Tutorado
     * @param idTutor
     * Parametro ingresado por el método asignarTutor de la clase Tutorado
     * @return flag
     * Valor booleano que indica si se guardo el registro en la DB correctamente
     * @throws SQLException 
     */
    @Override
    public boolean guardarPeriodo(String periodo, String matricula, int idTutor) 
            throws SQLException {
        Conexion conn = new Conexion();
        Conexion conn2 = new Conexion();
        boolean flag = false;
        String sql = "INSERT INTO `periodo`(`periodo`, `matriculaTutorado`, `idTutor`) "
                + "VALUES ('"+periodo+"','"+matricula+"',"+idTutor+")";
        String sql2 = "UPDATE `tutorado` SET `estado` = '1' WHERE `tutorado`.`matricula` = '"+matricula+"';";
        conn.ejecutar(sql);
        flag = conn2.ejecutar(sql2);
        conn.cerrar();
        conn2.cerrar();
        return flag;
    }
}
