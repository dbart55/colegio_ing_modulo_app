package consejodepartamental.persistence;

import consejodepartamental.entity.Sesion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class SesionDao {

    private Conexion conexion;

    public SesionDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public Sesion crearSesion(Sesion s) {
        try {
            String sql = "INSERT INTO sesion(usuario_id, recordar_usuario) VALUES (?, ?)";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, s.getUserId());
            ps.setBoolean(2, s.isRecordarUsuario());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int sesionId = 0;
            if (rs.next()) {
                sesionId = rs.getInt(1);
                System.out.println("sesionId: " + sesionId);
                return new Sesion(sesionId, s.getUserId(), s.isRecordarUsuario());
            } else {
                throw new Exception("ID no generado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SesionDao.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            Logger.getLogger(SesionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean eliminarSesion(Sesion s) {
        try {
            String sql = "DELETE FROM sesion WHERE sesion_id = ?";
            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ps.setInt(1, s.getSesionId());
            ps.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SesionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Sesion obtenerUltimSesion() {
        try {
            String sql = "SELECT sesion_id, usuario_id, recordar_usuario FROM sesion WHERE recordar_usuario = 1 ORDER BY fecha_sesion DESC";

            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int sesionId = rs.getInt("sesion_id");
                int usuarioId = rs.getInt("usuario_id");
                boolean recordar_usuario = rs.getBoolean("recordar_usuario");

                return new Sesion(sesionId, usuarioId, recordar_usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SesionDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
