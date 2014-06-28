package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
