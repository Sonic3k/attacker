package com.sonic.entity;

import com.sonic.process.*;

public class CavalryArcher extends Archer {
	private int reflexPercent;

	public CavalryArcher(EUnit _unit) {
		super(_unit);
		this.reflexPercent = _unit.getSpecial();
	}

	public void hurt(int h) {
		if (!Calculator.isMissed(reflexPercent)) {
			super.hurt(h);
		}
	}
}
