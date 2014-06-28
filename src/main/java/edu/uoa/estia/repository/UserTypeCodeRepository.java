package edu.uoa.estia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoa.estia.domain.UserTypeCodes;

public interface UserTypeCodeRepository extends JpaRepository<UserTypeCodes, Integer> {

}
