package com.sonic.sample;

import java.util.Scanner;

import com.sonic.entity.EUnit;
import com.sonic.entity.Unit;
import com.sonic.process.DrawBox;

public class RandomAttack {
	private static DrawBox<Unit> box;
	private static Scanner sc;
	
	public static void process() {
		box = new DrawBox<Unit>();
		box.add(EUnit.getListUnits());		
		sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("suffling.... ");
			
			if (box.getSize() < 2) {
				break;
			}
			
			box.suffle();		
			Unit player = box.peek();
			Unit computer = box.peek();
			System.out.println("Player 1: ");
			player.print();
			System.out.println("Computer 2: ");
			computer.print();
			
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
				System.out.println("PLAYER 2 WIN!");
			} else if (computer.isDead()){
				System.out.println("PLAYER 1 WIN!");
			}
			sc.nextLine();
		}
	}
}
