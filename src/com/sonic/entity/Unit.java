package com.sonic.entity;

import java.util.*;

public abstract class Unit {
	private EUnit unit;
	private final int healthMax;
	private int health;
	private int damage;
	private int armor;
	private int pierce;
	private boolean deadStatus;
	private int balancePoint = 0; // For balance test only

	public Unit(EUnit _unit) {
		this.unit = _unit;
		this.healthMax = unit.getHealth();
		this.health = healthMax;
		this.damage = unit.getDamage();
		this.armor = unit.getArmor();
		this.pierce = unit.getPierce();
		this.deadStatus = false;
	}

	public EUnit getUnit() {
		return this.unit;
	}

	public String getName() {
		return this.unit.toString();
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

	public boolean isDead() {
		return this.deadStatus;
	}

	public int getBalancePoint() {
		return this.balancePoint;
	}

	public void addBalancePoint(int point) {
		this.balancePoint += point;
	}

	public void hurt(int h) {
		this.health -= h;
		if (this.health <= 0) {
			this.health = 0;
			this.deadStatus = true;
		}
	}

	public void heal() {
		this.health = healthMax;
		this.deadStatus = false;
	}

	protected void damage(Unit aUnit, int dam) {
		if (dam < 1) {
			aUnit.hurt(1);
		} else {
			aUnit.hurt(dam);
		}
	}

	public abstract void damage(Unit aUnit);

	// comparator
	public static class BalanceDescComparator implements Comparator<Unit> {
		@Override
		public int compare(Unit unit1, Unit unit2) {
			return unit2.balancePoint - unit1.balancePoint;
		}
	}

	public void printHealth() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(": ");
		sb.append(getHealth());
		System.out.println(sb.toString());
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getName());
		sb.append("\nHealth: ");
		sb.append(this.getHealth());
		sb.append("\nDamage: ");
		sb.append(this.getDamage());
		sb.append("\nArmor: ");
		sb.append(this.getArmor());
		sb.append("\nPierce Armor: ");
		sb.append(this.getPierce());
		System.out.println(sb.toString());
	}
}
