package com.existingeevee.additionalweaponry.ItemClasses;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.existingeevee.additionalweaponry.AdditionalWeaponry;
import com.existingeevee.additionalweaponry.recipe.BlastReactorRecipe;

import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class BlastReactor extends AContainer {

    public BlastReactor(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
        

    }

    @Override
    public String getInventoryTitle() {
        return "&5Blast Reactor";
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.ELYTRA);
    }

    @Override
    public int getEnergyConsumption() {
        return 512;
    }

    @Override
    public int getCapacity() {
        return 8192;
    }
    
    @Override
    protected void registerDefaultRecipes() {
    	for(BlastReactorRecipe recipe : AdditionalWeaponry.getRegisteredBlastReactorRecipes()) {
    		if (recipe.getByproduct() != null) {
    			registerRecipe(recipe.getReactionTime(), new ItemStack[] { recipe.getInputItemA(), recipe.getInputItemB() }, new ItemStack[] { recipe.getOutputItem(), recipe.getByproduct() });
    		} else {
    			registerRecipe(recipe.getReactionTime(), new ItemStack[] { recipe.getInputItemA(), recipe.getInputItemB() }, new ItemStack[] { recipe.getOutputItem() });    			
    		}
    		
    	}
    }
//  @Override
//  protected MachineRecipe findNextRecipe(BlockMenu menu) {
//      for (int slot : getInputSlots()) {
//      	menu.getItemInSlot(slot)
//      }
//      return null;
//  }


    
    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public String getMachineIdentifier() {
        return "ENHANCED_ENCHANTER";
    }

}