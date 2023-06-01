package com.sonic.entity;

public class Infantry extends Unit{
	
	public Infantry(EUnit _unit) {
		super(_unit);
	}
	
	public void damage(Unit aUnit) {
		if (!this.isDead()) {
			int dam = this.getDamage();
			//Special attributes
			if (this.getUnit() == EUnit.PIKEMAN && 
					((aUnit instanceof Cavalry) || (aUnit instanceof CavalryArcher))) {
				dam = dam * 2;
			}
			
			if (this.getUnit() == EUnit.JAGUAR && 
					((aUnit instanceof Infantry) && !(aUnit instanceof Cavalry))) {
				dam = (int) Math.round(dam * 1.5);
			}
			
			damage(aUnit, dam);
		}
	}
	
	protected void damage(Unit aUnit, int dam) {
		int arm = aUnit.getArmor();
		dam = dam - arm;
		super.damage(aUnit, dam);
	}
}
