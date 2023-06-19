package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class EventoModalidad {

    private int cod_modalidad;
    private String modalidad;
    private String descripcion;

    public int getCod_modalidad() {
        return cod_modalidad;
    }

    public void setCod_modalidad(int cod_modalidad) {
        this.cod_modalidad = cod_modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EventoModalidad(int cod_modalidad, String modalidad, String descripcion) {
        this.cod_modalidad = cod_modalidad;
        this.modalidad = modalidad;
        this.descripcion = descripcion;
    }

    public EventoModalidad() {
    }

    public EventoModalidad(int cod_modalidad) {
        this.cod_modalidad = cod_modalidad;
    }
    
    public EventoModalidad(int cod_modalidad, String modalidad) {
        this.cod_modalidad = cod_modalidad;
        this.modalidad = modalidad;
    }

    @Override
    public String toString() {
        return this.modalidad;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.cod_modalidad;
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
        final EventoModalidad other = (EventoModalidad) obj;
        return this.cod_modalidad == other.cod_modalidad;
    }
}
