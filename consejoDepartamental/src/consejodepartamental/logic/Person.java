package consejodepartamental.logic;

/**
 *
 * @author Diego
 */
public class Person {
    private int personId;
    private String name;
    private String lastName;

    public Person() {
    }

    public Person(int personId, String name, String lastName) {
        this.personId = personId;
        this.name = name;
        this.lastName = lastName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
