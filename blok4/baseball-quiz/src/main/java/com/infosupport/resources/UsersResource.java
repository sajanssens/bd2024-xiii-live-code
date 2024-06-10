package com.infosupport.resources;

import com.infosupport.domain.User;
import com.infosupport.repos.UserRepo;
import com.infosupport.util.KeyGenerator;
import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.security.Key;

import static com.infosupport.util.PasswordUtils.digest;
import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MINUTES;

@Path("users")
public class UsersResource {

    @Inject
    private UserRepo repo;

    @Inject
    private KeyGenerator keyGenerator;

    @POST
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public User register(User u) {
        u.setPassword(digest(u.getPassword()));
        User added = repo.add(u);
        return added;
    }

    @POST @Path("login")
    @Produces(APPLICATION_JSON) @Consumes(APPLICATION_JSON)
    public User login(User input) {
        try {
            String username = input.getUsername();
            String password = input.getPassword();

            User user = repo.findByUsernameAndPassword(username, password);

            String jwt = issueToken(user);
            user.setToken(jwt);

            return user;
        } catch (NoResultException e) {
            throw new NotAuthorizedException("User " + input + " is not authorized.");
        }
    }

    private String issueToken(User user) {
        Key password = keyGenerator.generateKey();

        return Jwt.issuer("bramjanssens")
                .subject("baseball-quiz")
                // .upn(user.getLastName())
                .claim("username", user.getUsername())
                // .groups(user.getRoles())
                .issuedAt(now())
                .expiresAt(now().plus(30, MINUTES))
                .signWithSecret(password.toString())
                // .sign(readPrivateKey("private-key.pem")) // See readme how to generate keys
                ;
    }
}
