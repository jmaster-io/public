package com.trungtamjava.springlombok.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Country {
	private final int id;
	private final String name;
}
