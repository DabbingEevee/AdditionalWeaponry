package com.existingeevee.additionalweaponry.recipe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BlastReactorRecipe {
	
	private ItemStack inputItemA;
	private ItemStack inputItemB;
	private ItemStack outputItem;
	private ItemStack byproductItem;
	private int reactionTime;
	//private ItemStack outputItemB;
	
	public BlastReactorRecipe(int reactionTime, ItemStack inputItemA, ItemStack inputItemB, ItemStack outputItem) {
		
		this.setInputItemA(inputItemA);
		this.setInputItemB(inputItemB);
		this.setOutputItem(outputItem);
		this.setReactionTime(reactionTime);
		this.setByproduct(null);

	}

	public BlastReactorRecipe(int reactionTime, ItemStack inputItemA, ItemStack inputItemB, ItemStack outputItem, ItemStack byproduct) {
		
		this.setInputItemA(inputItemA);
		this.setInputItemB(inputItemB);
		this.setOutputItem(outputItem);
		this.setReactionTime(reactionTime);
		this.setByproduct(byproduct);
	}
	
	public ItemStack getInputItemA() {
		return inputItemA;
	}

	private void setInputItemA(ItemStack inputItemA) {
		this.inputItemA = inputItemA;
	}

	public ItemStack getInputItemB() {
		return inputItemB;
	}

	private void setInputItemB(ItemStack inputItemB) {
		this.inputItemB = inputItemB;
	}

	public ItemStack getOutputItem() {
		return outputItem;
	}

	private void setOutputItem(ItemStack outputItem) {
		this.outputItem = outputItem;
	}

	public int getReactionTime() {
		return reactionTime;
	}

	private void setReactionTime(int reactionTime) {
		this.reactionTime = reactionTime;
	}

	public ItemStack getByproduct() {
		return byproductItem;
	}

	private void setByproduct(ItemStack byproductItem) {
		this.byproductItem = byproductItem;
	}
	
	public ItemStack[] getItemRecipe() {
		ItemStack cookTime = new ItemStack(Material.FIRE_CHARGE);
		ItemMeta x = cookTime.getItemMeta();
		x.setDisplayName("Reaction Time");
    	List<String> list = new ArrayList<>(); 
    	list.add("§r§f" + this.getReactionTime() + "§r");
    	x.setLore(list);
    	cookTime.setItemMeta(x);
    	
    	ItemStack[] recipe = {null, inputItemA, null, null, cookTime , null, null, inputItemB, null};
		return recipe;
	}	
	
}
