package main.pp_springboot.service;

import main.pp_springboot.model.User;
import main.pp_springboot.reposotory.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.pp_springboot.model.User;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserDAO userDAO;//todo: пишем в camelCase: userDao

    @Autowired
    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> list() {
        return userDAO.list();
    }

    public User find(int id) {
        return userDAO.find(id);
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
