package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.item.*;
import com.sneakingshadow.bvks.item.armor.*;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemBVKS AssassinsKnife = new ItemAssassinsKnife();
    public static final ItemBVKS DevilArrow = new ItemDevilArrow();
    public static final ItemBVKS DevilAxe = new ItemDevilAxe();
    public static final ItemBVKS DevilBoots = new ItemDevilBoots();
    public static final ItemBVKS DevilBow = new ItemDevilBow();
    public static final ItemBVKS DevilChestplate = new ItemDevilChestplate();
    public static final ItemBVKS DevilGem = new ItemDevilGem();
    public static final ItemBVKS DevilHammer = new ItemDevilHammer();
    public static final ItemBVKS DevilHelmet = new ItemDevilHelmet();
    public static final ItemBVKS DevilIngot = new ItemDevilIngot();
    public static final ItemBVKS DevilLeggings = new ItemDevilLeggings();
    public static final ItemBVKS DevilPickaxe = new ItemDevilPickaxe();
    public static final ItemBVKS DevilShovel = new ItemDevilShovel();
    public static final ItemBVKS DevilSword = new ItemDevilSword();
    public static final ItemBVKS DiamondHammer = new ItemDiamondHammer();
    public static final ItemBVKS GoldHammer = new ItemGoldHammer();
    public static final ItemBVKS IronHammer = new ItemIronHammer();
    public static final ItemBVKS IronRod = new ItemIronRod();
    public static final ItemBVKS ObsidianAxe = new ItemObsidianAxe();
    public static final ItemBVKS ObsidianBoots = new ItemObsidianBoots();
    public static final ItemBVKS ObsidianChestplate = new ItemObsidianChestplate();
    public static final ItemBVKS ObsidianHammer = new ItemObsidianHammer();
    public static final ItemBVKS ObsidianHelmet = new ItemObsidianHelmet();
    public static final ItemBVKS ObsidianHoe = new ItemObsidianHoe();
    public static final ItemBVKS ObsidianIngot = new ItemObsidianIngot();
    public static final ItemBVKS ObsidianLeggings = new ItemObsidianLeggings();
    public static final ItemBVKS ObsidianPickaxe = new ItemObsidianPickaxe();
    public static final ItemBVKS ObsidianRod = new ItemObsidianRod();
    public static final ItemBVKS ObsidianShovel = new ItemObsidianShovel();
    public static final ItemBVKS ObsidianSword = new ItemObsidianSword();
    public static final ItemBVKS StoneHammer = new ItemStoneHammer();
    public static final ItemBVKS WoodHammer = new ItemWoodHammer();

    public static void init()
    {
        GameRegistry.registerItem(AssassinsKnife, Names.Items.AssassinsKnife);
        GameRegistry.registerItem(DevilArrow, Names.Items.DevilArrow);
        GameRegistry.registerItem(DevilAxe, Names.Items.DevilAxe);
        GameRegistry.registerItem(DevilBoots, Names.Items.DevilBoots);
        GameRegistry.registerItem(DevilBow, Names.Items.DevilBow);
        GameRegistry.registerItem(DevilChestplate, Names.Items.DevilChestplate);
        GameRegistry.registerItem(DevilGem, Names.Items.DevilGem);
        GameRegistry.registerItem(DevilHammer, Names.Items.DevilHammer);
        GameRegistry.registerItem(DevilHelmet, Names.Items.DevilHelmet);
        GameRegistry.registerItem(DevilIngot, Names.Items.DevilIngot);
        GameRegistry.registerItem(DevilLeggings, Names.Items.DevilLeggings);
        GameRegistry.registerItem(DevilPickaxe, Names.Items.DevilPickaxe);
        GameRegistry.registerItem(DevilShovel, Names.Items.DevilShovel);
        GameRegistry.registerItem(DevilSword, Names.Items.DevilSword);
        GameRegistry.registerItem(DiamondHammer, Names.Items.DiamondHammer);
        GameRegistry.registerItem(GoldHammer, Names.Items.GoldHammer);
        GameRegistry.registerItem(IronHammer, Names.Items.IronHammer);
        GameRegistry.registerItem(IronRod, Names.Items.IronRod);
        GameRegistry.registerItem(ObsidianAxe, Names.Items.ObsidianAxe);
        GameRegistry.registerItem(ObsidianBoots, Names.Items.ObsidianBoots);
        GameRegistry.registerItem(ObsidianChestplate, Names.Items.ObsidianChestplate);
        GameRegistry.registerItem(ObsidianHammer, Names.Items.ObsidianHammer);
        GameRegistry.registerItem(ObsidianHelmet, Names.Items.ObsidianHelmet);
        GameRegistry.registerItem(ObsidianHoe, Names.Items.ObsidianHoe);
        GameRegistry.registerItem(ObsidianIngot, Names.Items.ObsidianIngot);
        GameRegistry.registerItem(ObsidianLeggings, Names.Items.ObsidianLeggings);
        GameRegistry.registerItem(ObsidianPickaxe, Names.Items.ObsidianPickaxe);
        GameRegistry.registerItem(ObsidianRod, Names.Items.ObsidianRod);
        GameRegistry.registerItem(ObsidianShovel, Names.Items.ObsidianShovel);
        GameRegistry.registerItem(ObsidianSword, Names.Items.ObsidianSword);
        GameRegistry.registerItem(StoneHammer, Names.Items.StoneHammer);
        GameRegistry.registerItem(WoodHammer, Names.Items.WoodHammer);
    }
}
