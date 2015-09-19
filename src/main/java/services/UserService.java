package services;

import DAO.UserDAO;
import models.User;

public class UserService {

    UserDAO userdao = new UserDAO();

    public void createUser(String username, String password){
        if (userdao.getConnection() == null) {
            userdao.connect();
        }
            userdao.createUser(username, password);
    }

     public User getUser(String username){
         if (userdao.getConnection() == null) {
             userdao.connect();
         }
         return userdao.getUser(username);

     }
}
