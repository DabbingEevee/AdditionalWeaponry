package com.existingeevee.additionalweaponry.type;

import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ToolAttackAction {

	public ToolAttackAction(String slimefunIdentifier) {
		this.setSlimefunIdentifier(slimefunIdentifier.toUpperCase());
	}
	
	private String slimefunIdentifier;
	
	public void onHit(EntityDamageByEntityEvent e) {
		
	}

	public String getSlimefunIdentifier() {
		return slimefunIdentifier;
	}

	private void setSlimefunIdentifier(String slimefunIdentifier) {
		this.slimefunIdentifier = slimefunIdentifier;
	}
	
	
}

