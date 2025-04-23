package edu.miu.project.expensetracker.service;

import edu.miu.project.expensetracker.dao.UserDao;
import edu.miu.project.expensetracker.model.User;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    public boolean register(User user) {
//        user.setRole("USER");
        if (userDao.saveUser(user)) {
            return true;
        }
        return false;

    }

    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    public List<User> getAllUsers() {
        return userDao.listAllUsers();
    }

}
