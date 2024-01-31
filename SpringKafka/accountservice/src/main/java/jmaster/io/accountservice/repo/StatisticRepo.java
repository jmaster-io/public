package jmaster.io.accountservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.accountservice.model.StatisticDTO;

public interface StatisticRepo extends JpaRepository<StatisticDTO, Integer> {
	List<StatisticDTO> findByStatus(boolean status);
}
