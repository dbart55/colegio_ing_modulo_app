package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class EventoModular {

    private int codigo;
    private int cod_modalidad;
    private EventoModalidad modalidad;
    private String modalidadNombre;
    private int cod_tipo;
    private String tipoNombre;
    private TipoEvento tipoEvento;
    private int cod_cap;
    private String capituloNombre;
    private Capitulo capitulo;
    private String tema;
    private int cantidad;
    private String inicio;
    private String fin;
    private String horas;
    private String lugar;

    public EventoModular() {
        this.codigo = 0;
    }

    public EventoModular(int codigo, EventoModalidad modalidad, TipoEvento tipoEvento, String tema) {
        this.codigo = codigo;
        this.modalidad = modalidad;
        this.tipoEvento = tipoEvento;
        this.tema = tema;
    }

    public int getCod_cap() {
        return cod_cap;
    }

    public void setCod_cap(int cod_cap) {
        this.cod_cap = cod_cap;
    }

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
    }

    public int getCod_modalidad() {
        return cod_modalidad;
    }

    public void setCod_modalidad(int cod_modalidad) {
        this.cod_modalidad = cod_modalidad;
    }

    public int getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(int cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public EventoModalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(EventoModalidad modalidad) {
        this.modalidad = modalidad;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getModalidadNombre() {
        return modalidadNombre;
    }

    public void setModalidadNombre(String modalidadNombre) {
        this.modalidadNombre = modalidadNombre;
    }

    public String getTipoNombre() {
        return tipoNombre;
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    public String getCapituloNombre() {
        return capituloNombre;
    }

    public void setCapituloNombre(String capituloNombre) {
        this.capituloNombre = capituloNombre;
    }

    @Override
    public String toString() {
        return "EventoModular{" + "codigo=" + codigo + ", cod_modalidad=" + cod_modalidad + ", modalidadNombre=" + modalidadNombre + ", cod_tipo=" + cod_tipo + ", tipoNombre=" + tipoNombre + ", cod_cap=" + cod_cap + ", capituloNombre=" + capituloNombre + ", tema=" + tema + ", cantidad=" + cantidad + ", inicio=" + inicio + ", fin=" + fin + ", horas=" + horas + ", lugar=" + lugar + '}';
    }
}
