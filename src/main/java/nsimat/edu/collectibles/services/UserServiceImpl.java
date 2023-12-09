package nsimat.edu.collectibles.services;

import nsimat.edu.collectibles.beans.User;
import nsimat.edu.collectibles.dao.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean userExists(User user) {

        var userSearched = userRepository.findByEmailOrName(user.getEmail(), user.getName());
        return userSearched.isPresent();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }
}
