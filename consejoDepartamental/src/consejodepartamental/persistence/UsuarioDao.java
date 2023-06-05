package consejodepartamental.persistence;

import consejodepartamental.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Diego
 */
public class UsuarioDao {

    private Conexion conexion;

    public UsuarioDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public Usuario obtenerUsuario(String userName, String password) {
        try {
            String sql = "SELECT user_id, nombres, apellidos, username FROM usuario "
                    + "WHERE username=? AND password=?";

            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                
                return usuario;
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

}
