package com.trungtamjava.springlombok.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Person {
	private int id;
	private String name;

	@Builder(builderMethodName="builderCountry")
	public static Country countryBuilder(int id, String name) {
		return new Country(id, name);
	}
}
