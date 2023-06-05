package consejodepartamental.logic;

import consejodepartamental.entity.Usuario;
import consejodepartamental.persistence.Conexion;
import consejodepartamental.persistence.UsuarioDao;

/**
 *
 * @author Diego
 */
public class Controlador {
   private Conexion conexion;
   private UsuarioDao usuarioDao;
   
   public Controlador(){
       this.conexion = new Conexion();
       this.usuarioDao = new UsuarioDao(this.conexion);
   }
   
   
   public Usuario obtenerUsuario(String userName, String password){
      return this.usuarioDao.obtenerUsuario(userName, password);
   }
  
   public void finalizar(){
       this.conexion.desconectar();
   }
}
