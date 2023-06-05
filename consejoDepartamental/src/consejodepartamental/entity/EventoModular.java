package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class EventoModular {
    private int codigo;
    private int cod_modalidad;
    private EventoModalidad modalidad;
    private int cod_tipo;
    private TipoEvento tipoEvento;
    private int cod_cap;
    private Capitulo capitulo;
    private String tema;
    private int cantidad;
    private String inicio;
    private String fin;
    private String horas;
    private String lugar;

    public EventoModular() {
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
    
}
