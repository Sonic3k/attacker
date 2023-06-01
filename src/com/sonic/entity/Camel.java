package com.sonic.entity;

public class Camel extends Cavalry{

	public Camel(EUnit _unit) {
		super(_unit);
	}
	
	public void damage(Unit aUnit) {
		if (!this.isDead()) {
			int dam = this.getDamage();
			//Special attributes
			if ((aUnit instanceof Cavalry) || (aUnit instanceof CavalryArcher)) {
				dam = (int)Math.round(dam * 1.5);
			}
			
			super.damage(aUnit, dam);
		}
	}

}
