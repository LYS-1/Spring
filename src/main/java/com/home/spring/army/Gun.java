package com.home.spring.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Gun {
	private Bullet b;
	
	public Gun() {
		b = new Bullet();
	}
	@Autowired
	public Gun(Bullet bullet) {
		b = bullet;
	}
	
	public void trigger() {
		b.sound();
	}
}
