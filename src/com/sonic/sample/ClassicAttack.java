package com.sonic.sample;

import com.sonic.entity.*;
import com.sonic.process.*;

import java.util.*;

public class ClassicAttack {
	private static Unit player;
	private static Unit computer;
	private static int point;
	
	public static void process() {
		while(true) {
			setPlayers();
			fighting();
			
			System.out.println("\nPress Enter to continue attacking. (Press 0 to back to Main screen)");
			Scanner sc = new Scanner(System.in);
			String selection = sc.nextLine();
			if ("0".equals(selection)) {
				break;
			}
		}
	}
	
	private static void setPlayers() {
		DrawBox<Unit> box = new DrawBox<Unit>();
		box.add(EUnit.getListUnits());
		box.suffle();
		computer = box.peek();
		HashMap<Integer, Unit> option = new HashMap<Integer, Unit>();
		
		int number = 3;
		for (int i = 0; i < number; i++) {
			option.put((i + 1), box.peek());
		}
		StringBuilder sb = new StringBuilder();
		sb.append("Your enemy: ");
		sb.append(computer.getName());
		sb.append("\n\nChoose your soldier to attack the Enemy:\n");
		for (int i = 0; i < number; i++) {
			sb.append(i + 1);
			sb.append(". ");
			sb.append(option.get(i+1).getName());
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
		Scanner sc = new Scanner(System.in);
		int selection = sc.nextInt();
		
		if (option.containsKey(selection)) {
			player = option.get(selection);
		} else {
			player = option.get(1);
		}
	}
	
	private static void fighting() {
		System.out.println("Player: ");
		player.print();
		System.out.println("Enemy: ");
		computer.print();
		System.out.println("\nSTART FIGHTING NOW...(Press Enter for each attacking!)");
		Scanner sc = new Scanner(System.in);
		
		boolean cont = true;
		while(cont) {
			System.out.println("\nAttack..");
			sc.nextLine();
			player.damage(computer);
			computer.damage(player);
			player.printHealth();
			computer.printHealth();
			cont = (!computer.isDead() && !player.isDead());
		}
		
		if (player.isDead()) {
			System.out.println("YOU HAVE BEEN DEFEATED!");
			point--;
		} else if (computer.isDead()){
			System.out.println("CONGRATURATION! YOU WON");
			point++;
		}
		System.out.println("YOUR SCORE: " + point); 
	}
}
