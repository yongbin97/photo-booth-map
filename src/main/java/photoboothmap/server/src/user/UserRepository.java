package photoboothmap.server.src.user;

import org.springframework.data.repository.CrudRepository;
import photoboothmap.server.src.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {

    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Integer integer);
}
