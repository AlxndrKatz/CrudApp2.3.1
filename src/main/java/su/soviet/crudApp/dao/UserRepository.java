package su.soviet.crudApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import su.soviet.crudApp.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
