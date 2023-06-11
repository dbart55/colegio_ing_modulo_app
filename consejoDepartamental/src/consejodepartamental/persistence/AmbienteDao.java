package consejodepartamental.persistence;

import consejodepartamental.entity.Ambiente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class AmbienteDao {

    private Conexion conexion;

    public AmbienteDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public List<Ambiente> obtenerAmbientes() {
        List<Ambiente> ambientes = new ArrayList();
        try {
            String sql = "SELECT id_ambiente, nombre FROM ambiente";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ambiente ambiente = new Ambiente();
                ambiente.setId_ambiente(rs.getInt("id_ambiente"));
                ambiente.setNombre(rs.getString("nombre"));
                ambientes.add(ambiente);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return ambientes;

    }

}
