package consejodepartamental.logic;

import consejodepartamental.entity.EventoModalidad;
import consejodepartamental.entity.Organizador;
import consejodepartamental.entity.TipoEvento;
import consejodepartamental.entity.Usuario;
import consejodepartamental.persistence.Conexion;
import consejodepartamental.persistence.EventoModalidadDao;
import consejodepartamental.persistence.OrganizadorDao;
import consejodepartamental.persistence.TipoEventoDao;
import consejodepartamental.persistence.UsuarioDao;
import java.util.List;

/**
 *
 * @author Diego
 */
public class Controlador {

    private Conexion conexion;
    private UsuarioDao usuarioDao;
    private OrganizadorDao organizadorDao;
    private EventoModalidadDao modalidadDao;
    private TipoEventoDao tipoEventoDao;

    public Controlador() {
        this.conexion = new Conexion();
        this.usuarioDao = new UsuarioDao(this.conexion);
        this.organizadorDao = new OrganizadorDao(this.conexion);
        this.modalidadDao = new EventoModalidadDao(this.conexion);
        this.tipoEventoDao = new TipoEventoDao(this.conexion);
    }

    public Usuario obtenerUsuario(String userName, String password) {
        return this.usuarioDao.obtenerUsuario(userName, password);
    }

    public List<Organizador> obtenerOrganizadores() {
        return this.organizadorDao.obtenerOrganizadores();
    }

    public List<EventoModalidad> obtenerModalidades() {
        return this.modalidadDao.obtenerModalidades();
    }

    public List<TipoEvento> obtenerTipos() {
        return this.tipoEventoDao.obtenerTipos();
    }

    public void finalizar() {
        this.conexion.desconectar();
    }
}
