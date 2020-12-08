package com.existingeevee.additionalweaponry;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.existingeevee.additionalweaponry.ItemClasses.BlastReactor;
import com.existingeevee.additionalweaponry.recipe.BlastReactorRecipe;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class AdditionalWeaponry extends JavaPlugin implements SlimefunAddon {

	private static List<BlastReactorRecipe> registeredBlastReactorRecipes = new ArrayList<BlastReactorRecipe>();
	
    @Override
    public void onEnable() {
        //Config cfg = new Config(this);

        //if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        //}


        //Category categoryWeapon = new Category(new NamespacedKey(this, "addon_category_weapon"), new CustomItem(Material.WOODEN_SWORD, "&eAdditional Weaponry - Swords", "", "&a> Click to open"));
    	
    	ItemStack stonechunks16 = SlimefunItems.STONE_CHUNK.clone();
    	stonechunks16.setAmount(16);
    	
    	RecipeType blastReactor = new RecipeType(new NamespacedKey(SlimefunPlugin.instance(), "blastreactor"), new SlimefunItemStack("BLAST_REACTOR", Material.BASALT, "&fBlast Reactor"), "Heats and infuses items with each other at extreme tempratures");
    	
    	Category categoryResources = new Category(new NamespacedKey(this, "addon_category_resources"), new CustomItem(Material.NETHERITE_INGOT, "&eAdditional Weaponry - Resources", "", "&a> Click to open"));

        Category categoryMachines = new Category(new NamespacedKey(this, "addon_category_machine"), new CustomItem(Material.STICKY_PISTON, "&eAdditional Weaponry - Machines", "", "&a> Click to open"));

        SlimefunItemStack petrified_ingot = new SlimefunItemStack("PETRIFIED_INGOT", Material.NETHERITE_INGOT, "&fPetrified Ingot");
        BlastReactorRecipe petrified_ingot_recipe = new BlastReactorRecipe(30, new ItemStack(Material.BASALT, 16), new ItemStack(Material.NETHERITE_INGOT, 2), petrified_ingot, stonechunks16);
        addBlastReactorRecipe(petrified_ingot_recipe);
        new SlimefunItem(categoryResources, petrified_ingot, blastReactor, petrified_ingot_recipe.getItemRecipe()).register(this);

        ItemStack[] recipe = {new ItemStack(Material.CRYING_OBSIDIAN), SlimefunItems.WITHER_PROOF_OBSIDIAN, new ItemStack(Material.CRYING_OBSIDIAN), new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.TNT), new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.CRYING_OBSIDIAN), SlimefunItems.WITHER_PROOF_OBSIDIAN, new ItemStack(Material.CRYING_OBSIDIAN)};
        new BlastReactor(categoryMachines, new SlimefunItemStack("BLAST_REACTOR", Material.BASALT, "&fBlast Reactor"), RecipeType.ENHANCED_CRAFTING_TABLE, recipe).register(this);
        

    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

	public static List<BlastReactorRecipe> getRegisteredBlastReactorRecipes() {
		return registeredBlastReactorRecipes;
	}

	public static void addBlastReactorRecipe(BlastReactorRecipe blastReactorRecipe) {
	    registeredBlastReactorRecipes.add(blastReactorRecipe);
	}
    

}
