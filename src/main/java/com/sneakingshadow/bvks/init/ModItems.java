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
    public static final Item devilGem = new ItemBVKS(Name.Item.DEVIL_GEM).setCreativeTab(CreativeTabBVKS.tabItem);
    public static final Item obsidianIngot = new ItemBVKS(Name.Item.OBSIDIAN_INGOT);
    public static final Item ironRod = new ItemBVKS(Name.Item.IRON_ROD);
    public static final Item devilArrow = new ItemBVKS(Name.Item.DEVIL_ARROW);
    public static final Item devilIngot = new ItemBVKS(Name.Item.DEVIL_INGOT);
    public static final Item obsidianRod = new ItemBVKS(Name.Item.OBSIDIAN_ROD);
    public static final Item devilCompound = new ItemBVKS(Name.Item.DEVIL_COMPOUND);
    public static final Item bottomlessVoid = new ItemBottomlessVoid();
    public static final Item stoneGen = new ItemStoneGen();
    public static final Item devilBow = new ItemDevilBow();
    public static final Item assassinsKnife = new ItemAssassinsKnife();

    //Armor
    public static final Item devilBoots = new ItemArmorDevilBoots();
    public static final Item devilLeggings = new ItemArmorDevilLeggings();
    public static final Item devilChestplate = new ItemArmorDevilChestplate();
    public static final Item devilHelmet = new ItemArmorDevilHelmet();
    public static final Item obsidianBoots = new ItemBVKSArmor(Name.Item.OBSIDIAN_BOOTS, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.BOOTS);
    public static final Item obsidianLeggings = new ItemBVKSArmor(Name.Item.OBSIDIAN_LEGGINGS, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.LEGGINGS);
    public static final Item obsidianChestplate = new ItemBVKSArmor(Name.Item.OBSIDIAN_CHESTPLATE, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.CHESTPLATE);
    public static final Item obsidianHelmet = new ItemBVKSArmor(Name.Item.OBSIDIAN_HELMET, Name.Armor.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.HELMET);

    /**
     *    Tools
     */
    public static final Item hammer = new ItemHammer(Name.Item.HAMMER);
    //Devil
    public static final Item devilPickaxe = new ItemToolDevilPickaxe().setDevilTool();
    public static final Item devilShovel = new ItemToolDevilShovel().setDevilTool();
    public static final Item devilSword = new ItemToolDevilSword().setDevilTool();
    public static final Item devilAxe = new ItemToolDevilAxe().setDevilTool();
    public static final Item devilHoe = new ItemToolDevilHoe().setDevilTool();
    //Obsidian
    public static final Item obsidianPickaxe = new ItemBVKSPickaxe(Name.Item.OBSIDIAN_PICKAXE, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item obsidianShovel = new ItemBVKSShovel(Name.Item.OBSIDIAN_SHOVEL, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item obsidianSword = new ItemBVKSSword(Name.Item.OBSIDIAN_SWORD, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item obsidianAxe = new ItemBVKSAxe(Name.Item.OBSIDIAN_AXE, Tool.ItemToolMaterial.OBSIDIAN);
    public static final Item obsidianHoe = new ItemBVKSHoe(Name.Item.OBSIDIAN_HOE, Tool.ItemToolMaterial.OBSIDIAN);

    //Hammers
    public static final Item devilHammer = new ItemBVKSHammerOld(Name.Item.DEVIL_HAMMER, Tool.ItemToolMaterial.DEVIL_HAMMER, 9){
        @Override
        public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
        {
            list.add("The devil has a taste for worlds");
        }

        @Override
        public boolean isDamageable() { return false; }
    }.setDevilTool();
    public static final Item obsidianHammer = new ItemBVKSHammerOld(Name.Item.OBSIDIAN_HAMMER, Tool.ItemToolMaterial.OBSIDIAN_HAMMER, 4);
    public static final Item diamondHammer = new ItemBVKSHammerOld(Name.Item.DIAMOND_HAMMER, Tool.ItemToolMaterial.DIAMOND_HAMMER, 5);
    public static final Item goldHammer = new ItemBVKSHammerOld(Name.Item.GOLD_HAMMER, Tool.ItemToolMaterial.GOLD_HAMMER, 3);
    public static final Item ironHammer = new ItemBVKSHammerOld(Name.Item.IRON_HAMMER, Tool.ItemToolMaterial.IRON_HAMMER, 3);
    public static final Item stoneHammer = new ItemBVKSHammerOld(Name.Item.STONE_HAMMER, Tool.ItemToolMaterial.STONE_HAMMER, 2);
    public static final Item woodHammer = new ItemBVKSHammerOld(Name.Item.WOOD_HAMMER, Tool.ItemToolMaterial.WOOD_HAMMER, 1);

    public static final Item adminHammer = new ItemAdminHammerOld();
    public static final Item debugItem = new ItemDebugItem();
    public static final Item nbtDebugItem = new ItemNBTDebugItem();

    public static void init()
    {
        registerItem(assassinsKnife);
        registerItem(devilArrow);
        registerItem(devilAxe);
        registerItem(devilHoe);
        registerItem(devilBoots);
        registerItem(devilBow);
        registerItem(devilChestplate);
        registerItem(devilGem);
        registerItem(devilHammer);
        registerItem(devilHelmet);
        registerItem(devilIngot);
        registerItem(devilLeggings);
        registerItem(devilPickaxe);
        registerItem(devilShovel);
        registerItem(devilSword);
        registerItem(diamondHammer);
        registerItem(goldHammer);
        registerItem(ironHammer);
        registerItem(ironRod);
        registerItem(obsidianAxe);
        registerItem(obsidianBoots);
        registerItem(obsidianChestplate);
        registerItem(obsidianHammer);
        registerItem(obsidianHelmet);
        registerItem(obsidianHoe);
        registerItem(obsidianIngot);
        registerItem(obsidianLeggings);
        registerItem(obsidianPickaxe);
        registerItem(obsidianRod);
        registerItem(obsidianShovel);
        registerItem(obsidianSword);
        registerItem(stoneHammer);
        registerItem(woodHammer);
        registerItem(debugItem);
        registerItem(nbtDebugItem);
        registerItem(devilCompound);
        registerItem(adminHammer);
        registerItem(bottomlessVoid);
        registerItem(stoneGen);
        registerItem(hammer);
    }

    public static void add(List list, CreativeTabs creativeTab){
        CreativeTabBVKS.add(list, creativeTab, new Item[]{
                bottomlessVoid,
                adminHammer,
                devilHammer,
                obsidianHammer,
                diamondHammer,
                goldHammer,
                ironHammer,
                stoneHammer,
                woodHammer,
                devilHelmet,
                devilChestplate,
                devilLeggings,
                devilBoots,
                devilSword,
                devilPickaxe,
                devilShovel,
                devilAxe,
                devilHoe,
                obsidianHelmet,
                obsidianChestplate,
                obsidianLeggings,
                obsidianBoots,
                obsidianSword,
                obsidianPickaxe,
                obsidianShovel,
                obsidianAxe,
                obsidianHoe,
                stoneGen,
                assassinsKnife,
                devilBow,
                devilArrow,
                devilGem,
                devilIngot,
                devilCompound,
                obsidianIngot,
                obsidianRod,
                ironRod,
                hammer,
        });
        CreativeTabBVKS.add(list, creativeTab, new Item[] {
                debugItem,
                nbtDebugItem
        });
    }

    private static void registerItem(Item item){
        GameRegistry.registerItem(item, "item_" + item.getUnlocalizedName().substring( item.getUnlocalizedName().indexOf(":")+1 )
        );
    }
}