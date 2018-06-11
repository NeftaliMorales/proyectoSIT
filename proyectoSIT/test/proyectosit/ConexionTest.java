/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosit;
import org.junit.After;
import proyectosit.Conexion;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Clase de pruebas unitarias para la clase Conexion.
 * @author José Rodrigo Ordóñez Pacheco
 */
public class ConexionTest {
    Conexion testconexion;
    public ConexionTest() {
    }
    /**
     * Se inicializa un objeto "testconexion" de la clase Conexion para usarlo
     * dentro del alcance de la prueba.
     */
    @Before
    public void before(){
        testconexion = new Conexion();
    }
    /**
     * Test of conectar method, of class Conexion.
     * A partir de un objeto "test" de la clase Conexion, se prueba la funciona-
     * lidad de conectar con la Base de datos. 
     */
    @Test
    public void testConectar() {
        testconexion.conectar();
    }

    /**
     * Test of cerrar method, of class Conexion.
     * A partir de un objeto "test" de la clase Conexion, se prueba la funciona-
     * lidad de cerrar una conexión ya activa con al Base de datos.
     */
    @Test
    public void testCerrar() {
        testconexion.cerrar();
    }
    /**
     * Test del método cerrar, de la clase Conexion.
     * A partir de un objeto "test" de la clase Conexion, se prueba el escenario
     * en el que la conexión con la Base de Datos no existe o está inactiva.
     */
    @Test
    public void testCerrarNull(){
        testconexion.setCnxNull();
        testconexion.cerrar();
    }

    /**
     * Test of ejecutar method, of class Conexion.
     * A partir de un objeto "test" de la clase Conexion, se prueba la funciona-
     * lidad de ejecutar un comando SQL dentro de la base de datos.
     * 
     */
    @Test
    public void testEjecutar() {
        testconexion.ejecutar("INSERT INTO `tutoria`(`idTutoria`, `fechaTutoria`, "
                + "`numeroSesion`, `comentario`) VALUES ('999', '2018-12-12', '999', 'esto es una prueba')");
        
    }

    /**
     * Test of consultar method, of class Conexion.
     * A partir de un objeto "test" de la clase Conexion, se prueba la funciona-
     * lidad de ejecutar un comando SQL dentro de la base de datos.
     */
    @Test
    public void testConsultar() {
       testconexion.consultar("SELECT * FROM `tutoria` WHERE `idTutoria`= '999'");
    }
    /**
     * Después de las pruebas, se le indica al objeto "test" que borre las entra-
     * das que se hicieron como parte de las pruebas en al base de datos.
     */
    @After
    public void after(){
        testconexion.conectar();
        testconexion.ejecutar("DELETE FROM `tutoria` WHERE `idTutoria`= '999'");
        
        
    }
}
