package consejodepartamental.persistence;

import consejodepartamental.entity.EventoModalidad;
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
public class EventoModalidadDao {

    private Conexion conexion;

    public EventoModalidadDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<EventoModalidad> obtenerModalidades() {
        List<EventoModalidad> modalidades = new ArrayList<>();
        try {
            String sql = "SELECT cod_modalidad, modalidad, descripcion FROM evento_modalidad";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                EventoModalidad modalidad = new EventoModalidad();
                modalidad.setCod_modalidad(rs.getInt("cod_modalidad"));
                modalidad.setModalidad(rs.getString("modalidad"));
                modalidad.setDescripcion(rs.getString("descripcion"));

                modalidades.add(modalidad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoModalidadDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return modalidades;
    }

}
