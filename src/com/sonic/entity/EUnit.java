package com.sonic.entity;

import java.util.*;

public enum EUnit {
	SWORDSMAN(1, "Swordsman", 230, 9, 0, 0),
	PIKEMAN(2, "Pikeman", 105, 12, 0, 0),
	SAMURAI(3, "Samurai", 95, 18, 2, 0),
	HUSKARL(4, "Huskarl", 90, 14, 0, 7),
	BERSERK(5, "Berserk", 160, 10, 2, 3),
	TEUTONIC_KNIGHT(6, "Teutonic Knight", 80, 16, 10, 0),
	LONGBOWMAN(7, "Longbowman", 110, 14, 2, 2),
	SKIRMISHER(8, "Skirmisher", 120, 11, 0, 5),
	ARBALEST(9, "Arbalest", 180, 11, 0, 0),
	CHU_KO_NU(10, "Chu Ko Nu", 100, 15, 3, 0),
	HAND_CANNONEER(11, "Hand Cannoneer", 120, 20, 0, 0, 20),
	TURKMAN(12, "Turkman", 190, 12, 0, 2, 15),
	BOMBARD_CANNON(13, "Bombard Cannon", 75, 40, 0, 0, 40),
	PALADIN(14, "Paladin", 140, 12, 2, 3, 5),
	KNIGHT(15, "Knight", 100, 14, 2, 1, 15),
	TARKAN(16, "Tarkan", 70, 15, 2, 2, 35),
	BELISARIUS(17, "Belisarius", 125, 9, 2, 2, 20),
	HEAVY_CAMEL(18, "Heavy Camel", 130, 12, 0, 0, 15),
	MAMELUKE(19, "Mameluke", 80, 14, 1, 0, 30),
	CAVALRY_ARCHER(20, "Cavalry Archer", 140, 11, 1, 1, 20),
	MANGUDAI(21, "Mangudai", 80, 16, 3, 4, 20),
	
	// ==== new ======
	
	WOAD_RIDER(22, "Woad Rider", 150, 13, 0, 1),
	AXEMAN(23, "Axeman", 150, 13, 1, 0),
	JAGUAR(24, "Jaguar Warrior", 105, 14, 1, 2),
	PLUMED_ARCHER(25, "Plumed Archer", 145, 12, 0, 1),
	CONQUISTADOR(26, "Conquistador", 90, 16, 0, 0, 20);
	
	private int id;
	private String name;
	private int health;
	private int damage;
	private int armor;
	private int pierce;
	private int special;
	
	EUnit(int id, String name, int health, int damage, int armor, int pierce) {
		this.id = id;
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.armor = armor;
		this.pierce = pierce;
	}
	
	EUnit(int id, String name, int health, int damage, int armor, int pierce, int special) {
		this.id = id;
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.armor = armor;
		this.pierce = pierce;
		this.special = special;
	}
	
	public String toString() {
		return this.name;
	}
	
	public int toInt() {
		return this.id;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public int getArmor() {
		return this.armor;
	}
	
	public int getPierce() {
		return this.pierce;
	}
	
	public int getSpecial() {
		return this.special;
	}
	
	public static List<Unit> getListUnits() {
		List<Unit> box = new ArrayList<Unit>();
		box.add(new Infantry(EUnit.SWORDSMAN)); 
		box.add(new Infantry(EUnit.PIKEMAN)); 
		box.add(new Infantry(EUnit.SAMURAI)); 
		box.add(new Infantry(EUnit.HUSKARL)); 
		box.add(new Infantry(EUnit.BERSERK)); 
		box.add(new Infantry(EUnit.TEUTONIC_KNIGHT)); 
		box.add(new Archer(EUnit.LONGBOWMAN)); 
		box.add(new Archer(EUnit.SKIRMISHER)); 
		box.add(new Archer(EUnit.ARBALEST)); 
		box.add(new Archer(EUnit.CHU_KO_NU));
		box.add(new Cannoneer(EUnit.HAND_CANNONEER)); 
		box.add(new Cannoneer(EUnit.TURKMAN)); 
		box.add(new Cannoneer(EUnit.BOMBARD_CANNON)); 
		box.add(new Cavalry(EUnit.PALADIN)); 
		box.add(new Cavalry(EUnit.KNIGHT)); 
		box.add(new Cavalry(EUnit.TARKAN)); 
		box.add(new Cavalry(EUnit.BELISARIUS));
		box.add(new Camel(EUnit.HEAVY_CAMEL));
		box.add(new Camel(EUnit.MAMELUKE));
		box.add(new CavalryArcher(EUnit.CAVALRY_ARCHER));
		box.add(new CavalryArcher(EUnit.MANGUDAI));
		
		box.add(new Infantry(EUnit.WOAD_RIDER));
		box.add(new Infantry(EUnit.AXEMAN));
		box.add(new Infantry(EUnit.JAGUAR));
		box.add(new Archer(EUnit.PLUMED_ARCHER));
		box.add(new CavalryArcher(EUnit.CONQUISTADOR));
		return box;
	}
}
