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

    public TipoEvento(int cod_tipo) {
        this.cod_tipo = cod_tipo;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.cod_tipo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoEvento other = (TipoEvento) obj;
        return this.cod_tipo == other.cod_tipo;
    }
}
