package edu.miu.project.expensetracker.service;
import edu.miu.project.expensetracker.dao.UserDao;
import edu.miu.project.expensetracker.model.User;

public class UserService {

    private UserDao userDao = new UserDao();

    public void registerUser(User user){
        userDao.save(user);
    }

    public login(User user){
        userDao.save();
    }
}
