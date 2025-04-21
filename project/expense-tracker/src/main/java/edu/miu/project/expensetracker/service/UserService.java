package edu.miu.project.expensetracker.service;
import edu.miu.project.expensetracker.dao.UserDao;
import edu.miu.project.expensetracker.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public void register(User user){
        user.setRole("USER");
        userDao.saveUser(user);
    }

    public void  login(User user){
        userDao.validateUser(user);
    }

}
