package jmaster.io.accountservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.accountservice.model.MessageDTO;

public interface MessageRepo extends JpaRepository<MessageDTO, Integer> {
	
	List<MessageDTO> findByStatus(boolean status);

}
