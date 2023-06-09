package consejodepartamental.logic;

import consejodepartamental.entity.Ambiente;
import consejodepartamental.entity.Capitulo;
import consejodepartamental.entity.EventoModalidad;
import consejodepartamental.entity.EventoModular;
import consejodepartamental.entity.Organizador;
import consejodepartamental.entity.TipoEvento;
import consejodepartamental.entity.Usuario;
import consejodepartamental.persistence.AmbienteDao;
import consejodepartamental.persistence.CapituloDao;
import consejodepartamental.persistence.Conexion;
import consejodepartamental.persistence.EventoModalidadDao;
import consejodepartamental.persistence.EventoModularDao;
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
    private CapituloDao capituloDao;
    private EventoModularDao eventoModularDao;
    private AmbienteDao ambienteDao;

    public Controlador() {
        this.conexion = new Conexion();
        this.usuarioDao = new UsuarioDao(this.conexion);
        this.organizadorDao = new OrganizadorDao(this.conexion);
        this.modalidadDao = new EventoModalidadDao(this.conexion);
        this.tipoEventoDao = new TipoEventoDao(this.conexion);
        this.capituloDao = new CapituloDao(this.conexion);
        this.eventoModularDao = new EventoModularDao(this.conexion);
        this.ambienteDao = new AmbienteDao(this.conexion);
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

    public List<Capitulo> obtenerCapitulos() {
        return this.capituloDao.obtenerCapitulos();
    }

    public List<EventoModular> obtenerEventosModulares(String codeOrTema, Capitulo capitulo, EventoModalidad modalidad, TipoEvento tipo) {

        EventoModular filter = new EventoModular();
        if (codeOrTema != null && !codeOrTema.equals("")) {
            if (codeOrTema.matches("\\d+")) {
                //Es un numero
                filter.setCodigo(Integer.parseInt(codeOrTema));
            } else {
                filter.setTema(codeOrTema);
            }
        }

        filter.setCod_cap(capitulo.getCod_cap());
        filter.setCod_modalidad(modalidad.getCod_modalidad());
        filter.setCod_tipo(tipo.getCod_tipo());

        return this.eventoModularDao.obtenerEventosModulares(filter);
    }

    public List<Ambiente> obtenerAmbientes() {
        return this.ambienteDao.obtenerAmbientes();
    }

    public List<Organizador> obtenerOrganizadoresConFiltros(String cip, String nombre) {

        Organizador filter = new Organizador();
        if (cip != null && !cip.equals("")) {
            if (cip.matches("\\d+")) {
                filter.setCip(Integer.parseInt(cip));
            }
        }

        filter.setOrganizador(nombre);

        return this.organizadorDao.obtenerOrganizadoresConFiltros(filter);
    }

    public boolean guardarEventoModular(EventoModular em) {
        if (em.getCodigo() != 0) {
            return this.eventoModularDao.actualizarEventoModular(em);
        } else {
            return (this.eventoModularDao.crearEventoModular(em) > 0);
        }
    }

    public EventoModular obtenerEventoModularPorCodigo(int eventoCodigo) {
        return this.eventoModularDao.obtenerEventoModuarByCodigo(eventoCodigo);
    }

    public void finalizar() {
        this.conexion.desconectar();
    }

    public boolean eliminarEventoModular(int emCodigo) {
        return this.eventoModularDao.eliminarEventoModular(emCodigo);
    }
}
