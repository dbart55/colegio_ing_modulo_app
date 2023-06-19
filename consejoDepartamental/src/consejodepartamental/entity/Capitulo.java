package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class Capitulo {

    private int cod_cap;
    private String color;
    private String organizador;
    private String titulo;

    public Capitulo() {
    }

    public Capitulo(int cod_cap) {
        this.cod_cap = cod_cap;
    }

    public Capitulo(int cod_cap, String organizador) {
        this.cod_cap = cod_cap;
        this.organizador = organizador;
    }

    public Capitulo(int cod_cap, String color, String organizador, String titulo) {
        this.cod_cap = cod_cap;
        this.color = color;
        this.organizador = organizador;
        this.titulo = titulo;
    }

    public int getCod_cap() {
        return cod_cap;
    }

    public void setCod_cap(int cod_cap) {
        this.cod_cap = cod_cap;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return this.organizador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.cod_cap;
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
        final Capitulo other = (Capitulo) obj;
        return this.cod_cap == other.cod_cap;
    }
}
