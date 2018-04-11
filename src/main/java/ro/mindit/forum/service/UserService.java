package ro.mindit.forum.service;

import ro.mindit.forum.domain.User;

public interface UserService {

    User getUserByUserNameAndPassword(String userName, String password);

    Boolean registerUser(User user);
}
