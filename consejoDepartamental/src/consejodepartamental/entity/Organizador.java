package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class Organizador {

    private int cip;
    private String dni;
    private String capitulo;
    private String organizador;
    private String celular;
    private String correo;

    public Organizador() {
    }

    public Organizador(int cip, String capitulo) {
        this.cip = cip;
        this.capitulo = capitulo;
    }

    public Organizador(int cip, String dni, String capitulo, String organizador, String celular, String correo) {
        this.cip = cip;
        this.dni = dni;
        this.capitulo = capitulo;
        this.organizador = organizador;
        this.celular = celular;
        this.correo = correo;
    }

    public int getCip() {
        return cip;
    }

    public void setCip(int cip) {
        this.cip = cip;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return this.capitulo;
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
        final Organizador other = (Organizador) obj;
        return this.cip == other.cip;
    }
}
