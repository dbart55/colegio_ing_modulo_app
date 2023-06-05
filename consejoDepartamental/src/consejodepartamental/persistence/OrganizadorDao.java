package consejodepartamental.persistence;

import consejodepartamental.entity.Organizador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class OrganizadorDao {
    Conexion conexion;
    
    public OrganizadorDao(Conexion conexion){
        this.conexion = conexion;
    }
    
    
    public List<Organizador> obtenerOrganizadores(){
        List<Organizador> organizadores = new ArrayList();
        try {
            String sql = "SELECT CIP, DNI, capitulo, organizador, celular, correo FROM organizadores";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Organizador organizador = new Organizador();
                organizador.setCip(rs.getInt("CIP"));
                organizador.setDni(rs.getString("DNI"));
                organizador.setCapitulo(rs.getString("capitulo"));
                organizador.setOrganizador(rs.getString("organizador"));
                organizador.setCelular(rs.getString("celular"));
                organizador.setCorreo(rs.getString("correo"));
                
                System.out.println(organizador);
                
                organizadores.add(organizador);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return organizadores;
    }
}
