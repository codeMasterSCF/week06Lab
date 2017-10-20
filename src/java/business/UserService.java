
package business;

/**
 *
 * @author 463849
 */
public class UserService {
    
    public User login(String username, String password){
    
        String user1 = "Adam";
        String user2 = "Betty";
        String pw = "password";
        User user = new User();
        
        if(username.equals(user1) || username.equals(user2) && password.equals(pw)){
            if(username.equals(user1)){
                user.setUsername(user1);
                user.setPassword(null);
                return user;
            }
            else if(username.equals(user2)){
                user.setUsername(user2);
                user.setPassword(null);
                return user;
            }        
        }
        return null;
    } 
}

