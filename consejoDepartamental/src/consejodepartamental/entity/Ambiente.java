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
   
}
