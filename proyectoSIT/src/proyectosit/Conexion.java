/*
 * Clase para realizar la conexion con la base de datos y las consultas.
 *
 * @author edson
 * @since 06/06/18
 */
package proyectosit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection cnx = null;
    private Statement sentencia = null;
    private ResultSet res = null;
    
    //CONSTRUCTOR
    public Conexion(){
        
        conectar();
    }
    /**
     * Método que realiza la conexión con la DB para la tecnologia SQL.
     */
    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");//DRIVER
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/sitdatabase", "root", "");//CONECCION (DATOS: DIRECCION DE LA BASE, USER, PASS)
            if(cnx != null){
                sentencia = cnx.createStatement();//CREAR LA CONEXION
                System.out.println("Conexión exitosa");
            }
        }        
        catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex);//ERROR
        }
    }
    /**
     * Método que cierra la conexion con la BD.
     */
    public void cerrar(){
        if(cnx != null){
            try {
                cnx.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }
    /**
     * Método que se usa para ejecutar instrucciones sql como Insert, Delete y
     * Update
     * @param sql
     * Consulta sql proporcionada por los metodos de clases DAO que utilizan a 
     * la clase Conexion
     * @return flag
     * Valor boolean que indica si se realizo la instrucción sql
     */
    public boolean ejecutar(String sql){
        boolean flag;
        try{
            sentencia.execute(sql);
            sentencia.close();
            flag = true;
        }
        catch(SQLException ex){
            System.err.println(ex);
            flag = false;
        }
        return flag;
    }

    /**
     * Método que realiza las instrucciones sql Select y Join.
     * @param sql
     * Consulta sql proporcionada por los metodos de clases DAO que utilizan a 
     * la clase Conexion
     * @return res
     * Set de Resultados con todos los registros que se recuperaron de la DB.
     */
    public ResultSet consultar(String sql){
        try{
            res = sentencia.executeQuery(sql);
        }
        catch(SQLException ex){
            System.err.println(ex);
            return null;
        }
        catch(NullPointerException ex){
            System.err.println(ex);
        }
        return res;
    }
}

