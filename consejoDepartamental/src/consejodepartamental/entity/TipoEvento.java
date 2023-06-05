package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class TipoEvento {

    private int cod_tipo;
    private String tipo;
    private String descripcion;

    public TipoEvento() {
    }

    public TipoEvento(int cod_tipo, String tipo) {
        this.cod_tipo = cod_tipo;
        this.tipo = tipo;
    }
    
    public TipoEvento(int cod_tipo, String tipo, String descripcion) {
        this.cod_tipo = cod_tipo;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getCod_tipo() {
        return cod_tipo;
    }

    public void setCod_tipo(int cod_tipo) {
        this.cod_tipo = cod_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.tipo;
    }

}
