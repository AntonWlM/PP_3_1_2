package main.pp_springboot.reposotory;


import main.pp_springboot.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> list();

    public User find(int id);

    public void save(User user);


    public void update(User user);


    public void delete(int id);
}
