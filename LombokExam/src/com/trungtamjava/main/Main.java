package com.trungtamjava.main;

import com.trungtamjava.model.Person;
import com.trungtamjava.model.Teacher;

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(1);
		p1.setName("P1");
		
		System.out.println(p1.getId());
		
		Person p2 = new Person(2, "P2");
		
		System.out.println(p2.toString());
		
		
		Teacher tc1 = new Teacher();
		tc1.setId(3);
		tc1.setName("TC1");
		tc1.setAddress("Hanoi");
		
		System.out.println(tc1.toString());
		
		Teacher tc2 = new Teacher();
		tc2.setId(3);
		tc2.setName("TC2");
		tc2.setAddress("Ha Nam");
		
		System.out.println(tc1.equals(tc2));
		
		Teacher tc3 = new Teacher();
	}
}
