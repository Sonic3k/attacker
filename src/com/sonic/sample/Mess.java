package com.sonic.sample;

public class Mess {
	public static final String getMainScreen() {
		StringBuilder sb = new StringBuilder();
		sb.append("Choose options:\n");
		sb.append("1. Attack! Attack! Attack!.\n");
		sb.append("2. View random attack.\n");
		sb.append("3. View Soldier list.\n");
		sb.append("Other. Exit\n");
		return sb.toString();
	}
}
