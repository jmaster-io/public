package com.trungtamjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = true, exclude = { "address" })
@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor
public class Teacher extends Person {
	
	@NonNull
	private String address;
	
	private String school;
}
