package com.existingeevee.additionalweaponry.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class LoreUtils {

	public ItemStack addLore(ItemStack itemStack, String...lore) {
		ItemMeta itemMeta = itemStack.getItemMeta();
    	List<String> list = new ArrayList<>(); 
    	for (String l : lore) {
    		list.add(l);
    	}
    	itemMeta.setLore(list);
    	itemStack.setItemMeta(itemMeta);
    	return itemStack;
	}
	public SlimefunItemStack addLore(SlimefunItemStack itemStack, String...lore) {
		ItemMeta itemMeta = itemStack.getItemMeta();
    	List<String> list = new ArrayList<>(); 
    	for (String l : lore) {
    		list.add(l);
    	}
    	itemMeta.setLore(list);
    	itemStack.setItemMeta(itemMeta);
    	return itemStack;
	}
	
}
