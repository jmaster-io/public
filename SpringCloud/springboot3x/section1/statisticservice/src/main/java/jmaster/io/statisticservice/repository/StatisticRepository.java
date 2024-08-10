package jmaster.io.statisticservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.statisticservice.entity.Statistic;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {

}
