package jmaster.io.webflux.service;

import org.springframework.data.repository.CrudRepository;

import jmaster.io.webflux.domain.City;

public interface CityRepository extends CrudRepository<City, Long> {
	City findByNameAndCountryAllIgnoringCase(String name, String country);
}
