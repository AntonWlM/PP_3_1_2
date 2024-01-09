package main.pp_springboot.reposotory;


import main.pp_springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UserDAOImp implements UserDAO {

    private final EntityManager entityManager;
    //todo: codeStyle - пустые строки

    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> list() {//todo: codeStyle -> getUsers
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User find(int id) {
        return entityManager.find(User.class,id);
    }

    public void save(User user) {
        if (!user.getName().isBlank() && !user.getLastName().isBlank()) {
        entityManager.persist(user);
        entityManager.flush();}
    }

    public void update(User user) {
        if (!user.getName().isBlank() && !user.getLastName().isBlank()) {
            entityManager.merge(user);
            entityManager.flush();}
    }

    public void delete(int id) throws NullPointerException {
        User user = find(id);
        if (user == null) {
            throw new NullPointerException("User not found");
        }
        entityManager.remove(user);
        entityManager.flush();
    }
}
