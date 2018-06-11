/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosit;
import proyectosit.Conexion;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ferzo
 */
public class ConexionTest {
    Conexion testconexion;
    public ConexionTest() {
    }
    @Before
    public void before(){
        testconexion = new Conexion();
    }
    /**
     * Test of conectar method, of class Conexion.
     */
    @Test
    public void testConectar() {
        testconexion.conectar();
    }

    /**
     * Test of cerrar method, of class Conexion.
     */
    @Test
    public void testCerrar() {
        testconexion.cerrar();
    }

    /**
     * Test of ejecutar method, of class Conexion.
     
    @Test
    public void testEjecutar() {
        //testconexion.ejecutar(sql)
    }

    /**
     * Test of consultar method, of class Conexion.
     
    @Test
    public void testConsultar() {
       // testconexion.ejecutar(sql)
    }
    */
}
