package ro.mindit.forum.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.mindit.forum.domain.User;
import ro.mindit.forum.repository.UserDAO;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {

        User user =  userDAO.findOneByUserName(userName);
        if(user != null) {
            if(user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Boolean registerUser(User user) {

        User userExistingOptional = userDAO.findOneByUserName(user.getUserName());
        if(userExistingOptional != null) {
            return false;
        }

        user.setUser_role_id(1);

        userDAO.registerUser(user);
        return true;
    }
}
