package com.sonic.entity;

public class Archer extends Unit{
	
	public Archer(EUnit _unit) {
		super(_unit);
	}
	
	public void damage(Unit aUnit) {
		if (!this.isDead()) {
			int dam = this.getDamage();
			//special attributes
			if (this.getUnit() == EUnit.SKIRMISHER && (aUnit instanceof Archer)){
				dam = (int)Math.round(dam * 1.5);
			}
			
			if (this.getUnit() == EUnit.PLUMED_ARCHER && (aUnit instanceof Infantry) && !(aUnit instanceof Cavalry)){
				dam = dam + 2;
			}
			
			damage(aUnit, dam);
		}
	}
	
	protected void damage(Unit aUnit, int dam) {
		int arm = aUnit.getPierce();
		dam = dam - arm;
		super.damage(aUnit, dam);
	}
}
