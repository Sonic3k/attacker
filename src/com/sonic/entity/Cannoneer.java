package com.sonic.entity;

import com.sonic.process.Calculator;

public class Cannoneer extends Archer{
	private int missingPercent;

	public Cannoneer(EUnit _unit) {
		super(_unit);
		this.missingPercent = _unit.getSpecial();
	}
	
	public void damage(Unit aUnit) {
		if (!Calculator.isMissed(missingPercent)) {
			super.damage(aUnit);
		}
	}

}
