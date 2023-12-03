package consejodepartamental.persistence;

import consejodepartamental.entity.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class UsuarioDao {

    private Conexion conexion;

    public UsuarioDao(Conexion conexion) {
        this.conexion = conexion;
    }

    public Usuario obtenerUsuarioPorCredenciales(String userName, String password) {
        try {
            String sql = "SELECT user_id, nombres, apellidos, dni, cargo, username FROM usuario "
                    + "WHERE BINARY  username=? AND BINARY password=?";

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
                usuario.setCargo(rs.getString("cargo"));
                usuario.setDni(rs.getString("dni"));

                return usuario;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Usuario obtenerUsuarioPorId(int userId){
          try {
            String sql = "SELECT user_id, nombres, apellidos, dni, cargo, username FROM usuario "
                    + "WHERE user_id=?";

            PreparedStatement ps = this.conexion.getJdbcConnection().prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUserId(rs.getInt("user_id"));
                usuario.setUserName(rs.getString("username"));
                usuario.setNombres(rs.getString("nombres"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCargo(rs.getString("cargo"));
                usuario.setDni(rs.getString("dni"));

                return usuario;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
