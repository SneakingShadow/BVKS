package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.item.*;
import com.sneakingshadow.bvks.reference.Reference;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemBVKS devilGem = new ItemDevilGem();
    public static final ItemBVKS devilIngot = new ItemDevilIngot();
    public static final ItemBVKS devilPickaxe = new ItemDevilPickaxe();
    public static final ItemBVKS devilSword = new ItemDevilSword();
    public static final ItemBVKS obsidianIngot = new ItemObsidianIngot();
    public static final ItemBVKS ironRod = new ItemIronRod();
    public static final ItemBVKS obsidianRod = new ItemObsidianRod();

    public static void init()
    {
        GameRegistry.registerItem(devilGem, "devilGem");
        GameRegistry.registerItem(devilIngot, "devilIngot");
        GameRegistry.registerItem(devilPickaxe, "devilPickaxe");
        GameRegistry.registerItem(devilSword, "devilSword");
        GameRegistry.registerItem(obsidianIngot, "obsidianIngot");
        GameRegistry.registerItem(ironRod, "ironRod");
        GameRegistry.registerItem(obsidianRod, "obsidianRod");
    }
}
