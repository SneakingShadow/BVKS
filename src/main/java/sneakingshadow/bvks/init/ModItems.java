package sneakingshadow.bvks.init;

import sneakingshadow.bvks.item.*;
import sneakingshadow.bvks.item.armor.devil.ItemDevilBoots;
import sneakingshadow.bvks.item.armor.devil.ItemDevilChestplate;
import sneakingshadow.bvks.item.armor.devil.ItemDevilHelmet;
import sneakingshadow.bvks.item.armor.devil.ItemDevilLeggings;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianBoots;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianChestplate;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianHelmet;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianLeggings;
import sneakingshadow.bvks.item.tool.ItemAssassinsKnife;
import sneakingshadow.bvks.item.tool.devil.*;
import sneakingshadow.bvks.item.tool.hammer.*;
import sneakingshadow.bvks.item.tool.obsidian.*;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.Ref;
import cpw.mods.fml.common.registry.GameRegistry;
import sneakingshadow.bvks.item.base.*;
import sneakingshadow.bvks.item.tool.ItemAdminHammer;

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
    public static final ItemBVKS ObsidianRod = new ItemObsidianRod();
    public static final ItemBVKS DevilCompound = new ItemDevilCompound();
    public static final ItemBVKS BottomlessVoid = new ItemBVKSStorage().setDescription("Stores one type of item").setBaseName(Names.Items.BottomlessVoid);

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
    public static final ItemBVKSPickaxe ObsidianPickaxe = new ItemObsidianPickaxe();
    //Axes
    public static final ItemBVKSAxe DevilAxe = new ItemDevilAxe();
    public static final ItemBVKSAxe ObsidianAxe = new ItemObsidianAxe();
    //Shovels
    public static final ItemBVKSShovel DevilShovel = new ItemDevilShovel();
    public static final ItemBVKSShovel ObsidianShovel = new ItemObsidianShovel();
    //Swords
    public static final ItemBVKSSword DevilSword = new ItemDevilSword();
    public static final ItemBVKSSword ObsidianSword = new ItemObsidianSword();
    //Hoes
    public static final ItemBVKSHoe DevilHoe = new ItemDevilHoe();
    public static final ItemBVKSHoe ObsidianHoe = new ItemObsidianHoe();
    //Hammers
    public static final ItemBVKSHammer DevilHammer = new ItemDevilHammer();
    public static final ItemBVKSHammer DiamondHammer = new ItemDiamondHammer();
    public static final ItemBVKSHammer GoldHammer = new ItemGoldHammer();
    public static final ItemBVKSHammer IronHammer = new ItemIronHammer();
    public static final ItemBVKSHammer ObsidianHammer = new ItemObsidianHammer();
    public static final ItemBVKSHammer StoneHammer = new ItemStoneHammer();
    public static final ItemBVKSHammer WoodHammer = new ItemWoodHammer();

    /**
     *   The common admin tools
     */
    public static final ItemBVKSPickaxe AdminHammer = new ItemAdminHammer();


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
        GameRegistry.registerItem(AdminHammer, Names.Items.AdminHammer);
        GameRegistry.registerItem(BottomlessVoid, Names.Items.BottomlessVoid);
    }
}
