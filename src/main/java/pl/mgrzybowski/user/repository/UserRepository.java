package pl.mgrzybowski.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mgrzybowski.user.model.UserEnity;

@Repository
public interface UserRepository extends JpaRepository<UserEnity, Long> {
}
