package consejodepartamental.entity;

/**
 *
 * @author Diego
 */
public class Persona {
    private int personaId;
    private String nombre;
    private String apellidos;

    public Persona() {
    }

    public Persona(int personId, String name, String lastName) {
        this.personaId = personId;
        this.nombre = name;
        this.apellidos = lastName;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
}
