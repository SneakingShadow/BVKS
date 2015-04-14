package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.item.*;
import com.sneakingshadow.bvks.item.armor.*;
import com.sneakingshadow.bvks.item.tool.*;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.reference.Ref;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModItems
{
    /**
     *
     */
    public static final ItemBVKS DevilGem = new ItemDevilGem();
    public static final ItemBVKS ObsidianIngot = new ItemObsidianIngot();
    public static final ItemBVKS IronRod = new ItemIronRod();
    public static final ItemBVKS AssassinsKnife = new ItemAssassinsKnife();
    public static final ItemBVKS DevilArrow = new ItemDevilArrow();
    public static final ItemBVKS DevilBow = new ItemDevilBow();
    public static final ItemBVKS DevilIngot = new ItemDevilIngot();
    public static final ItemBVKS DiamondHammer = new ItemDiamondHammer();
    public static final ItemBVKS GoldHammer = new ItemGoldHammer();
    public static final ItemBVKS IronHammer = new ItemIronHammer();
    public static final ItemBVKS ObsidianAxe = new ItemObsidianAxe();
    public static final ItemBVKS ObsidianHammer = new ItemObsidianHammer();
    public static final ItemBVKS ObsidianHoe = new ItemObsidianHoe();
    public static final ItemBVKS ObsidianPickaxe = new ItemObsidianPickaxe();
    public static final ItemBVKS ObsidianRod = new ItemObsidianRod();
    public static final ItemBVKS ObsidianShovel = new ItemObsidianShovel();
    public static final ItemBVKS ObsidianSword = new ItemObsidianSword();
    public static final ItemBVKS StoneHammer = new ItemStoneHammer();
    public static final ItemBVKS WoodHammer = new ItemWoodHammer();
    public static final ItemBVKS DevilCompound = new ItemDevilCompound();

    //Armor
    public static final ItemBVKSArmor DevilBoots = new ItemDevilBoots();
    public static final ItemBVKSArmor DevilLeggings = new ItemDevilLeggings();
    public static final ItemBVKSArmor DevilChestplate = new ItemDevilChestplate();
    public static final ItemBVKSArmor DevilHelmet = new ItemDevilHelmet();
    public static final ItemBVKSArmor ObsidianBoots = new ItemObsidianBoots();
    public static final ItemBVKSArmor ObsidianLeggings = new ItemObsidianLeggings();
    public static final ItemBVKSArmor ObsidianChestplate = new ItemObsidianChestplate();
    public static final ItemBVKSArmor ObsidianHelmet = new ItemObsidianHelmet();

    /**
     *    Tools
     */
    //Pickaxes
    public static final ItemBVKSPickaxe DevilPickaxe = new ItemDevilPickaxe();
    //Axes
    public static final ItemBVKSAxe DevilAxe = new ItemDevilAxe();
    //Shovels
    public static final ItemBVKSShovel DevilShovel = new ItemDevilShovel();
    //Swords
    public static final ItemBVKSSword DevilSword = new ItemDevilSword();
    //Hoes
    public static final ItemBVKSHoe DevilHoe = new ItemDevilHoe();
    //Hammers
    public static final ItemBVKSHammer DevilHammer = new ItemDevilHammer();


    /**
     *   The allmighty, holy debug tool!!!
     */
    public static final ItemDebugItem DebugItem = new ItemDebugItem();

    public static void init()
    {
        GameRegistry.registerItem(AssassinsKnife, Names.Items.AssassinsKnife);
        GameRegistry.registerItem(DevilArrow, Names.Items.DevilArrow);
        GameRegistry.registerItem(DevilAxe, Names.Items.DevilAxe);
        GameRegistry.registerItem(DevilHoe, Names.Items.DevilHoe);
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
        GameRegistry.registerItem(DebugItem, Names.Items.DebugItem);
        GameRegistry.registerItem(DevilCompound, Names.Items.DevilCompound);
    }
}
