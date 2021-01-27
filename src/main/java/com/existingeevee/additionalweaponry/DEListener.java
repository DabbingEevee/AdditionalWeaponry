package com.existingeevee.additionalweaponry;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.existingeevee.additionalweaponry.type.ToolAttackAction;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

public class DEListener implements Listener {

	@EventHandler
	public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			if (e.getDamager() instanceof HumanEntity) {
				if (SlimefunItem.getByItem(((HumanEntity) e.getDamager()).getInventory().getItemInMainHand()) instanceof SlimefunItem) {
					for (ToolAttackAction attackAction : AdditionalWeaponry.getRegisteredToolAttackActions()) {
						if (SlimefunItem.getByItem(((HumanEntity) e.getDamager()).getInventory().getItemInMainHand()).equals(SlimefunItem.getByID(attackAction.getSlimefunIdentifier()))){
							attackAction.onHit(e);
							return;
						}
					}
				}
			}
		}
	}
}
