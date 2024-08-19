package com.trungtamjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Setter
//@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = false, of = { "id" })
@EqualsAndHashCode(of = { "id" })
public class Person {
	private int id;
	private String name;
}
