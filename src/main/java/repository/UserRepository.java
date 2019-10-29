package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academicPlanner.academicPlanner.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
