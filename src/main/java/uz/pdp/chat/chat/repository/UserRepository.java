package uz.pdp.chat.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.chat.chat.entity.User;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Integer> {

    boolean existsByUsername(String username);

    List<User> findAllByIdIn(Set<Integer> list);
}
