package consejodepartamental.persistence;

import consejodepartamental.entity.Capitulo;
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
public class CapituloDao {

    private Conexion conexion;

    public CapituloDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<Capitulo> obtenerCapitulos() {
        List<Capitulo> capitulos = new ArrayList();
        try {
            String sql = "SELECT cod_cap, color, organizador, titulo FROM capitulo";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Capitulo c = new Capitulo();
                c.setCod_cap(rs.getInt("cod_cap"));
                c.setColor(rs.getString("color"));
                c.setOrganizador(rs.getString("organizador"));
                c.setTitulo(rs.getString("titulo"));

                capitulos.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CapituloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return capitulos;
    }

}
