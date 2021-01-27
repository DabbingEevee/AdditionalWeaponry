package com.existingeevee.additionalweaponry.attackaction;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.existingeevee.additionalweaponry.type.ToolAttackAction;

public class PetrifiedSword extends ToolAttackAction{

	public PetrifiedSword(String slimefunIdentifier) {
		super(slimefunIdentifier);
	}
	
	@Override
	public void onHit(EntityDamageByEntityEvent e) {
		Location location = e.getEntity().getLocation();
		World world = e.getEntity().getWorld();
		if (world.getBlockAt(location).getType().equals(Material.AIR) || world.getBlockAt(location).getType().equals(Material.CAVE_AIR) || world.getBlockAt(location).getType().equals(Material.VOID_AIR)) {
			world.getBlockAt(location).setType(Material.BLACKSTONE);
		}
		location.setY(location.getY() + 1);
		if (world.getBlockAt(location).getType().equals(Material.AIR) || world.getBlockAt(location).getType().equals(Material.CAVE_AIR) || world.getBlockAt(location).getType().equals(Material.VOID_AIR)) {
			world.getBlockAt(location).setType(Material.BLACKSTONE);
		}
		location.setY(location.getY() - 2);
		if (world.getBlockAt(location).getType().equals(Material.AIR) || world.getBlockAt(location).getType().equals(Material.CAVE_AIR) || world.getBlockAt(location).getType().equals(Material.VOID_AIR)) {
			world.getBlockAt(location).setType(Material.BLACKSTONE);
		}		
	}
}
