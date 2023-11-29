package consejodepartamental.entity;

import java.io.File;
import java.util.Date;
import java.util.List;

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
    private Date inicio;
    private Date fin;
    private int diaMax;
    private String horas;
    private String lugar;
    private String temario;
    private int id_ambiente;
    private String ambienteNombre;
    private List<Organizador> organizadores;
    private int horasTotales;
    private File imagenFile;
    private String rutaImagen;
    private int mesNum;
    private String url;
    private boolean mostrarCalendario;

    public EventoModular() {
        this.codigo = 0;
    }

    public EventoModular(int codigo) {
        this.codigo = codigo;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
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

    public String getTemario() {
        return temario;
    }

    public void setTemario(String temario) {
        this.temario = temario;
    }

    public int getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    public String getAmbienteNombre() {
        return ambienteNombre;
    }

    public void setAmbienteNombre(String ambienteNombre) {
        this.ambienteNombre = ambienteNombre;
    }

    public List<Organizador> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(List<Organizador> organizadores) {
        this.organizadores = organizadores;
    }

    public int getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(int horasTotales) {
        this.horasTotales = horasTotales;
    }

    public int getDiaMax() {
        return diaMax;
    }

    public void setDiaMax(int diaMax) {
        this.diaMax = diaMax;
    }

    public File getImagenFile() {
        return imagenFile;
    }

    public void setImagenFile(File imagenFile) {
        this.imagenFile = imagenFile;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getMesNum() {
        return mesNum;
    }

    public void setMesNum(int mesNum) {
        this.mesNum = mesNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isMostrarCalendario() {
        return mostrarCalendario;
    }

    public void setMostrarCalendario(boolean mostrarCalendario) {
        this.mostrarCalendario = mostrarCalendario;
    }
    
    @Override
    public String toString() {
        return "EventoModular{" + "codigo=" + codigo + ", cod_modalidad=" + cod_modalidad + ", modalidadNombre=" + modalidadNombre + ", cod_tipo=" + cod_tipo + ", tipoNombre=" + tipoNombre + ", cod_cap=" + cod_cap + ", capituloNombre=" + capituloNombre + ", tema=" + tema + ", cantidad=" + cantidad + ", inicio=" + inicio + ", fin=" + fin + ", horas=" + horas + ", lugar=" + lugar + '}';
    }
}
