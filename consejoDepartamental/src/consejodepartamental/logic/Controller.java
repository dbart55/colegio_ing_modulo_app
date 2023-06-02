package consejodepartamental.logic;

import consejodepartamental.persistence.PersistenceController;

/**
 *
 * @author Diego
 */
public class Controller {
    PersistenceController persistenceController = new PersistenceController();
    
    public int getUserIdByCredentials(String userName, String password){
        
           User user = persistenceController.getUserByCredentials(userName, password);
           if(user != null){
               return user.getPersonId();
           }
       
        return 0;
    }
}
