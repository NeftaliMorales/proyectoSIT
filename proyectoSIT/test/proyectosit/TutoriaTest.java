/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosit;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ferzo
 */
public class TutoriaTest {
    Tutoria testtutoria;
    Conexion conex;
    public TutoriaTest() {
    }

    @Before
    public void before(){
        testtutoria = new Tutoria();
        conex = new Conexion();
    }
    /**
     * Test of registrarSesion method, of class Tutoria.
     */
    @Test
    public void testRegistrarSesion() throws Exception {
        testtutoria.registrarSesion("S12251425", 3);
    }

   
    
}
