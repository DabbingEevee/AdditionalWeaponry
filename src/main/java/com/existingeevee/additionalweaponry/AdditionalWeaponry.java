package com.existingeevee.additionalweaponry;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.existingeevee.additionalweaponry.Itemclasses.BlastReactor;
import com.existingeevee.additionalweaponry.attackaction.PetrifiedSword;
import com.existingeevee.additionalweaponry.type.BlastReactorRecipe;
import com.existingeevee.additionalweaponry.type.ToolAttackAction;
import com.existingeevee.additionalweaponry.utils.LoreUtils;

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
	private static List<ToolAttackAction> registeredToolAttackActions = new ArrayList<ToolAttackAction>();
	
	private LoreUtils loreUtils = new LoreUtils();
	
    @SuppressWarnings("unused")
	@Override
    public void onEnable() {
    	
    	ItemStack stonechunks16 = SlimefunItems.STONE_CHUNK.clone();
    	stonechunks16.setAmount(16);
    	
    	RecipeType blastReactor = new RecipeType(new NamespacedKey(SlimefunPlugin.instance(), "blastreactor"), new SlimefunItemStack("BLAST_REACTOR", Material.BASALT, "&fBlast Reactor"), "Heats and infuses items with each other at extreme tempratures");
    	
    	ToolAttackAction petrifiedSwordAttackAction = new PetrifiedSword("PETRIFIED_SWORD");
    	
    	Category categoryResources = new Category(new NamespacedKey(this, "addon_category_resources"), new CustomItem(Material.NETHERITE_INGOT, "&eAdditional Weaponry - Resources", "", "&a> Click to open"));
    	Category categoryMaterials = new Category(new NamespacedKey(this, "addon_category_materials"), new CustomItem(Material.STICK, "&eAdditional Weaponry - Materials", "", "&a> Click to open"));

        Category categoryMachines = new Category(new NamespacedKey(this, "addon_category_machine"), new CustomItem(Material.STICKY_PISTON, "&eAdditional Weaponry - Machines", "", "&a> Click to open"));

        SlimefunItemStack petrifiedIngot = new SlimefunItemStack("PETRIFIED_INGOT", Material.NETHERITE_INGOT, "&fPetrified Ingot");
        BlastReactorRecipe petrifiedIngotRecipe = new BlastReactorRecipe(30, new ItemStack(Material.BASALT, 16), new ItemStack(Material.NETHERITE_INGOT, 2), petrifiedIngot, stonechunks16);
        addBlastReactorRecipe(petrifiedIngotRecipe);
        String truth = "sickopenguin was here and he got grilled";
        new SlimefunItem(categoryResources, petrifiedIngot, blastReactor, petrifiedIngotRecipe.getItemRecipe()).register(this);

        ItemStack[] blastReactorRecipe = {new ItemStack(Material.CRYING_OBSIDIAN), SlimefunItems.WITHER_PROOF_OBSIDIAN, new ItemStack(Material.CRYING_OBSIDIAN), new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.TNT), new ItemStack(Material.NETHERITE_INGOT),new ItemStack(Material.CRYING_OBSIDIAN), SlimefunItems.WITHER_PROOF_OBSIDIAN, new ItemStack(Material.CRYING_OBSIDIAN)};
        new BlastReactor(categoryMachines, new SlimefunItemStack("BLAST_REACTOR", Material.BASALT, "&fBlast Reactor"), RecipeType.ENHANCED_CRAFTING_TABLE, blastReactorRecipe).register(this);

        ItemStack[] petrifiedStickRecipe = {null, null, null, null, petrifiedIngot, null, null, petrifiedIngot, null};
        SlimefunItemStack petrifiedStick = new SlimefunItemStack("PETRIFIED_STICK", Material.STICK, "&fPetrified Stick");
        new SlimefunItem(categoryMaterials, petrifiedStick, RecipeType.ENHANCED_CRAFTING_TABLE, petrifiedStickRecipe).register(this);

        ItemStack[] petrifiedSwordRecipe = {null, petrifiedIngot, null, null, petrifiedIngot, null, null, petrifiedStick, null};
        SlimefunItemStack petrifiedSword = loreUtils.addLore(new SlimefunItemStack("PETRIFIED_SWORD", Material.NETHERITE_SWORD, "&fPetrified Sword"),"§fCauses Petrification on victims.", "§fCan be used for a renewable blackstone farm.");
        new SlimefunItem(categoryMaterials, petrifiedSword, RecipeType.ENHANCED_CRAFTING_TABLE, petrifiedSwordRecipe).register(this);

        addToolAttackAction(petrifiedSwordAttackAction);
        
        Bukkit.getPluginManager().registerEvents(new DEListener(), this);

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

	public static List<ToolAttackAction> getRegisteredToolAttackActions() {
		return registeredToolAttackActions;
	}

	public static void addToolAttackAction(ToolAttackAction toolAttackAction) {
		registeredToolAttackActions.add(toolAttackAction);
	}

	public static List<BlastReactorRecipe> getRegisteredBlastReactorRecipes() {
		return registeredBlastReactorRecipes;
	}

	public static void addBlastReactorRecipe(BlastReactorRecipe blastReactorRecipe) {
	    registeredBlastReactorRecipes.add(blastReactorRecipe);
	}

}
