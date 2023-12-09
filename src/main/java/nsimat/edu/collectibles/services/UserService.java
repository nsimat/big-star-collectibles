package nsimat.edu.collectibles.services;

import nsimat.edu.collectibles.beans.Product;
import nsimat.edu.collectibles.beans.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    boolean userExists(User user);
    User saveUser(User user);
}
