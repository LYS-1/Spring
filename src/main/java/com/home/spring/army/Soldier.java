package com.home.spring.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Soldier {
//	private Gun gun;
	@Autowired
	@Qualifier ("sg")
	private Gun shotgun;
	@Autowired
	@Qualifier ("rf")
	private Gun rifle;
	
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
//	public Gun getGun() {
//		return gun;
//	}
//	public Soldier() {
//		gun = new Gun();
//	}
	public void useGun() {
		this.rifle.trigger();
	}
//	@Autowired
//	public void setGun(Gun gun) {
//		this.gun = gun;
//	}
}
