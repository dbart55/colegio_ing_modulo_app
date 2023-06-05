package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class EventoModular {
    private int codigo;
    private EventoModalidad modalidad;
    private TipoEvento tipoEvento;
    private Capitulo capitulo;
    private String tema;
    private int cantidad;
    private String inicio;
    private String fin;
    private String horas;
    private String lugar;

    public EventoModular() {
    }

    public EventoModular(int codigo, EventoModalidad modalidad, TipoEvento tipoEvento, Capitulo capitulo, String tema, int cantidad, String inicio, String fin, String horas, String lugar) {
        this.codigo = codigo;
        this.modalidad = modalidad;
        this.tipoEvento = tipoEvento;
        this.capitulo = capitulo;
        this.tema = tema;
        this.cantidad = cantidad;
        this.inicio = inicio;
        this.fin = fin;
        this.horas = horas;
        this.lugar = lugar;
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

    public Capitulo getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(Capitulo capitulo) {
        this.capitulo = capitulo;
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
