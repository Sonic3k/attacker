package com.sonic.sample;

import java.util.*;

import com.sonic.entity.*;

public class BalancePoint {
	private static Scanner sc;
	private static List<Unit> units;

	public static void process() {
		System.out.println("processing...\n");
		units = EUnit.getListUnits();

		// Active the contest
		activeContest(100);

		// Balance point results:
		System.out.println(getResult());
	}

	private static void activeContest(int times) {
		if (times > 0) {
			for (int i = 0; i < times; i++) {
				for (Unit thisUnit : units) {
					for (Unit againstUnit : units) {
						if (!thisUnit.equals(againstUnit)) {
							fight(thisUnit, againstUnit);
							thisUnit.heal();
							againstUnit.heal();
						}
					}
				}
			}
		}
	}

	private static void fight(Unit thisUnit, Unit againstUnit) {
		while (true) {
			thisUnit.damage(againstUnit);
			againstUnit.damage(thisUnit);

			if (thisUnit.isDead()) {
				againstUnit.addBalancePoint(1);
				break;
			}
			if (againstUnit.isDead()) {
				thisUnit.addBalancePoint(1);
				break;
			}
		}
	}

	private static String getResult() {
		Collections.sort(units, new Unit.BalanceDescComparator());

		int order = 0;
		StringBuilder sb = new StringBuilder();
		for (Unit unit : units) {
			order++;
			sb.append(order);
			sb.append(". ");
			sb.append(unit.getName());
			sb.append(" - ");
			sb.append(unit.getBalancePoint());
			sb.append(" points.\n");
		}

		return sb.toString();
	}
}
