package edu.uoa.estia.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.uoa.estia.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}