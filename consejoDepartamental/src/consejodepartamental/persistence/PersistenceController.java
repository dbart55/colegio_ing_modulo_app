package consejodepartamental.persistence;

import consejodepartamental.logic.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class PersistenceController {
   
    ArrayList<User> users = new ArrayList();
    public PersistenceController() {
        users.add(new User("diego@gmail.com","123",1, "Diego","Barturen"));
    }
   
    
    
    public User getUserByCredentials(String userName, String password){
        
        for(User us : users){
            if(us.getUserName().equals(userName) && us.getPassword().equals(password)){
                return us;
            }
        }
        
        return null;
    }
}
