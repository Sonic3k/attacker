package com.sonic.entity;

import com.sonic.process.Calculator;

public class Cavalry extends Infantry{
	private int reflexPercent;
	
	public Cavalry(EUnit _unit) {
		super(_unit);
		this.reflexPercent = _unit.getSpecial();
	}
	
	public void hurt(int h) {
		if (!Calculator.isMissed(reflexPercent)) {
			super.hurt(h);
		}
	}
	
	public void damage(Unit aUnit) {
		if (!this.isDead()) {
			int dam = this.getDamage();
			//Special attributes
			if (this.getUnit() == EUnit.BELISARIUS 
					&& aUnit instanceof Infantry && !(aUnit instanceof Cavalry)) {
				dam = dam * 2;
			}

			super.damage(aUnit, dam);
		}
	}
}
