package edu.uoa.estia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uoa.estia.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

}