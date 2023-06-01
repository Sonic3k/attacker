package com.sonic.process;

public class Calculator {
	public static boolean isMissed(int missingPercent) {
		DrawBox<Boolean> box = new DrawBox<Boolean>();
		for (int i = 0; i < missingPercent; i++) {
			box.add(true);
		}
		for (int i = 0; i < 100 - missingPercent; i++) {
			box.add(false);
		}
		return box.get();
	}
}
