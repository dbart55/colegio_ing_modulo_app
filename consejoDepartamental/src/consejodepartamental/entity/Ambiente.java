package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class Ambiente {

    private int id_ambiente;
    private String nombre;

    public Ambiente() {
    }

    public Ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    public Ambiente(int id_ambiente, String nombre) {
        this.id_ambiente = id_ambiente;
        this.nombre = nombre;
    }

    public int getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id_ambiente;
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
        final Ambiente other = (Ambiente) obj;
        return this.id_ambiente == other.id_ambiente;
    }
}
