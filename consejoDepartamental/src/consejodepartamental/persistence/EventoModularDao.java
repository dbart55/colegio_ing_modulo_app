package consejodepartamental.persistence;

import consejodepartamental.entity.EventoModular;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class EventoModularDao {

    private Conexion conexion;

    public EventoModularDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<EventoModular> obtenerEventosModulares(EventoModular filter) {
        List<EventoModular> eventos = new ArrayList<EventoModular>();
        try {

            String sql = "SELECT user_id, nombres, apellidos, username FROM usuario "
                    + "WHERE username=? AND password=?";

            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return eventos;
    }
}
