package com.infosupport.repos;

import com.infosupport.domain.User;
import jakarta.enterprise.context.ApplicationScoped;

import static com.infosupport.domain.User.FIND_BY_USERNAME_AND_PASSWORD;
import static com.infosupport.util.PasswordUtils.digest;

@ApplicationScoped // since bean-discovery-mode="annotated"
public class UserRepo extends Repo<User> {

    @Override
    public Class<User> E() {
        return User.class;
    }

    public User findByUsernameAndPassword(String login, String password) {
        return em.createNamedQuery(FIND_BY_USERNAME_AND_PASSWORD, User.class)
                .setParameter("login", login)
                .setParameter("password", digest(password))
                .getSingleResult();
    }
}
