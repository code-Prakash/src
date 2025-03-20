package services;
import dao.UserDAO;
import models.User;

public class UserService {
    public static boolean registerUser(User user){
        if(user.getName().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty()){
            return false;
        }
        return UserDAO.registerUser(user);
    }
    
     public static boolean loginUser(String email, String password) {
        return UserDAO.loginUsers(email, password);
    }

    public static User getUser(String email) {
        return UserDAO.getUserByEmail(email);
    }
    

}


