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
import proyectosit.Tutorado;

public class TutoriaDao implements TutoriaDAO{

    public TutoriaDao() {
    
    }
    
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
        return tutorados;
    }
    
}
