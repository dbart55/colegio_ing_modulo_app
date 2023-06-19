package consejodepartamental.persistence;

import consejodepartamental.entity.TipoEvento;
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
public class TipoEventoDao {

    private Conexion conexion;

    public TipoEventoDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<TipoEvento> obtenerTipos() {

        List<TipoEvento> tipos = new ArrayList();
        try {
            String sql = "SELECT cod_tipo, tipo, descripcion FROM tipo_evento";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                TipoEvento tipo = new TipoEvento();
                tipo.setCod_tipo(rs.getInt("cod_tipo"));
                tipo.setTipo(rs.getString("tipo"));
                tipo.setDescripcion(rs.getString("descripcion"));

                tipos.add(tipo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoEventoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipos;
    }
}
