package main.pp_springboot.service;

import main.pp_springboot.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {
    public List<User> list();

    public User find(int id);

    @Transactional
    public void save(User user);
    @Transactional
    public void update(User user);

    @Transactional
    public void delete(int id);
}
