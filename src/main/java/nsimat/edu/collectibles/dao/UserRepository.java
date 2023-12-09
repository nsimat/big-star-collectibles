package nsimat.edu.collectibles.dao;

import nsimat.edu.collectibles.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    <S extends User> S save(S entity);
    Optional<User> findByEmailOrName(String email, String name);
}
