package com.skilldistillery.jet;

import java.util.concurrent.TimeUnit;

public class JetsApp {

	static Airfield af = new Airfield();
	public static void main(String[] args) throws InterruptedException {
		JetsApp jApp = new JetsApp();
		af.fly();
	}
}
