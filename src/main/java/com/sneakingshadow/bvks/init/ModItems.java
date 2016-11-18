package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import com.sneakingshadow.bvks.item.*;
import com.sneakingshadow.bvks.item.base.*;
import com.sneakingshadow.bvks.reference.Armor;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Reference;
import com.sneakingshadow.bvks.reference.Tool;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final Item DevilGem = new ItemBVKS(Name.Item.DEVIL_GEM).setCreativeTab(CreativeTabBVKS.tabItem);
    public static final Item ObsidianIngot = new ItemBVKS(Name.Item.OBSIDIAN_INGOT);
    public static final Item IronRod = new ItemBVKS(Name.Item.IRON_ROD);
    public static final Item DevilArrow = new ItemBVKS(Name.Item.DEVIL_ARROW);
    public static final Item DevilIngot = new ItemBVKS(Name.Item.DEVIL_INGOT);
    public static final Item ObsidianRod = new ItemBVKS(Name.Item.OBSIDIAN_ROD);
    public static final Item DevilCompound = new ItemBVKS(Name.Item.DEVIL_COMPOUND);
    public static final Item BottomlessVoid = new ItemBottomlessVoid();
    public static final Item StoneGen = new ItemStoneGen();
    public static final Item DevilBow = new ItemDevilBow();
    public static final Item AssassinsKnife = new ItemAssassinsKnife();

    //Armor
    public static final Item DevilBoots = new ItemArmorDevilBoots();
    public static final Item DevilLeggings = new ItemArmorDevilLeggings();
    public static final Item DevilChestplate = new ItemArmorDevilChestplate();
    public static final Item DevilHelmet = new ItemArmorDevilHelmet();
    public static final Item ObsidianBoots = new ItemBVKSArmor(Name.Item.OBSIDIAN_BOOTS, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.BOOTS);
    public static final Item ObsidianLeggings = new ItemBVKSArmor(Name.Item.OBSIDIAN_LEGGINGS, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.LEGGINGS);
    public static final Item ObsidianChestplate = new ItemBVKSArmor(Name.Item.OBSIDIAN_CHESTPLATE, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.CHESTPLATE);
    public static final Item ObsidianHelmet = new ItemBVKSArmor(Name.Item.OBSIDIAN_HELMET, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.HELMET);

    /**
     *    Tools
     */
    public static final Item Hammer = new ItemHammer(Name.Item.HAMMER);
    //Devil
    public static final Item DevilPickaxe = new ItemToolDevilPickaxe().setDevilTool();
    public static final Item DevilShovel = new ItemToolDevilShovel().setDevilTool();
    public static final Item DevilSword = new ItemToolDevilSword().setDevilTool();
    public static final Item DevilAxe = new ItemToolDevilAxe().setDevilTool();
    public static final Item DevilHoe = new ItemToolDevilHoe().setDevilTool();
    //Obsidian
    public static final Item ObsidianPickaxe = new ItemBVKSPickaxe(Name.Item.OBSIDIAN_PICKAXE, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item ObsidianShovel = new ItemBVKSShovel(Name.Item.OBSIDIAN_SHOVEL, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item ObsidianSword = new ItemBVKSSword(Name.Item.OBSIDIAN_SWORD, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item ObsidianAxe = new ItemBVKSAxe(Name.Item.OBSIDIAN_AXE, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item ObsidianHoe = new ItemBVKSHoe(Name.Item.OBSIDIAN_HOE, Tool.ItemToolMaterial.OBSIDIAN);

    //Hammers
    public static final Item DevilHammer = new ItemBVKSHammerOld(Name.Item.DEVIL_HAMMER, Tool.ItemToolMaterial.DEVIL_HAMMER, 9){
        @Override
        public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
        {
            list.add("The devil has a taste for worlds");
        }

        @Override
        public boolean isDamageable() { return false; }
    }.setDevilTool();
    public static final Item ObsidianHammer = new ItemBVKSHammerOld(Name.Item.OBSIDIAN_HAMMER, Tool.ItemToolMaterial.OBSIDIAN_HAMMER, 4);
    public static final Item DiamondHammer = new ItemBVKSHammerOld(Name.Item.DIAMOND_HAMMER, Tool.ItemToolMaterial.DIAMOND_HAMMER, 5);
    public static final Item GoldHammer = new ItemBVKSHammerOld(Name.Item.GOLD_HAMMER, Tool.ItemToolMaterial.GOLD_HAMMER, 3);
    public static final Item IronHammer = new ItemBVKSHammerOld(Name.Item.IRON_HAMMER, Tool.ItemToolMaterial.IRON_HAMMER, 3);
    public static final Item StoneHammer = new ItemBVKSHammerOld(Name.Item.STONE_HAMMER, Tool.ItemToolMaterial.STONE_HAMMER, 2);
    public static final Item WoodHammer = new ItemBVKSHammerOld(Name.Item.WOOD_HAMMER, Tool.ItemToolMaterial.WOOD_HAMMER, 1);

    public static final Item AdminHammer = new ItemAdminHammerOld();
    public static final Item DebugItem = new ItemDebugItem();
    public static final Item NBTDebugItem = new ItemNBTDebugItem();

    public static void init()
    {
        registerItem(AssassinsKnife);
        registerItem(DevilArrow);
        registerItem(DevilAxe);
        registerItem(DevilHoe);
        registerItem(DevilBoots);
        registerItem(DevilBow);
        registerItem(DevilChestplate);
        registerItem(DevilGem);
        registerItem(DevilHammer);
        registerItem(DevilHelmet);
        registerItem(DevilIngot);
        registerItem(DevilLeggings);
        registerItem(DevilPickaxe);
        registerItem(DevilShovel);
        registerItem(DevilSword);
        registerItem(DiamondHammer);
        registerItem(GoldHammer);
        registerItem(IronHammer);
        registerItem(IronRod);
        registerItem(ObsidianAxe);
        registerItem(ObsidianBoots);
        registerItem(ObsidianChestplate);
        registerItem(ObsidianHammer);
        registerItem(ObsidianHelmet);
        registerItem(ObsidianHoe);
        registerItem(ObsidianIngot);
        registerItem(ObsidianLeggings);
        registerItem(ObsidianPickaxe);
        registerItem(ObsidianRod);
        registerItem(ObsidianShovel);
        registerItem(ObsidianSword);
        registerItem(StoneHammer);
        registerItem(WoodHammer);
        registerItem(DebugItem);
        registerItem(NBTDebugItem);
        registerItem(DevilCompound);
        registerItem(AdminHammer);
        registerItem(BottomlessVoid);
        registerItem(StoneGen);
        registerItem(Hammer);
    }

    public static void add(List list, CreativeTabs creativeTab){
        CreativeTabBVKS.add(list, creativeTab, new Item[]{
                BottomlessVoid,
                AdminHammer,
                DevilHammer,
                ObsidianHammer,
                DiamondHammer,
                GoldHammer,
                IronHammer,
                StoneHammer,
                WoodHammer,
                DevilHelmet,
                DevilChestplate,
                DevilLeggings,
                DevilBoots,
                DevilSword,
                DevilPickaxe,
                DevilShovel,
                DevilAxe,
                DevilHoe,
                ObsidianHelmet,
                ObsidianChestplate,
                ObsidianLeggings,
                ObsidianBoots,
                ObsidianSword,
                ObsidianPickaxe,
                ObsidianShovel,
                ObsidianAxe,
                ObsidianHoe,
                StoneGen,
                AssassinsKnife,
                DevilBow,
                DevilArrow,
                DevilGem,
                DevilIngot,
                DevilCompound,
                ObsidianIngot,
                ObsidianRod,
                IronRod,
                Hammer,
        });
        CreativeTabBVKS.add(list, creativeTab, new Item[] {
                DebugItem,
                NBTDebugItem
        });
    }

    private static void registerItem(Item item){
        GameRegistry.registerItem(item, "item_" + item.getUnlocalizedName().substring( item.getUnlocalizedName().indexOf(":")+1 )
        );
    }
}