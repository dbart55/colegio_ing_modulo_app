package consejodepartamental.persistence;

import consejodepartamental.entity.ConfiguracionGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ConfigDao {

    private Conexion conexion;

    public ConfigDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public ConfiguracionGeneral obtenerConfiguracionGeneral() {
        try {
            String sql = "SELECT config_id, ruta_imagen FROM configuracion_general ORDER BY config_id LIMIT 1;";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ConfiguracionGeneral config = new ConfiguracionGeneral();
                config.setConfigId(rs.getInt("config_id"));
                config.setRutaImagen(rs.getString("ruta_imagen"));
                return config;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return new ConfiguracionGeneral();
    }
}
