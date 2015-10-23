package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import sneakingshadow.bvks.item.*;
import sneakingshadow.bvks.item.armor.devil.ItemDevilBoots;
import sneakingshadow.bvks.item.armor.devil.ItemDevilChestplate;
import sneakingshadow.bvks.item.armor.devil.ItemDevilHelmet;
import sneakingshadow.bvks.item.armor.devil.ItemDevilLeggings;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianBoots;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianChestplate;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianHelmet;
import sneakingshadow.bvks.item.armor.obsidian.ItemObsidianLeggings;
import sneakingshadow.bvks.item.tool.ItemAdminHammer;
import sneakingshadow.bvks.item.tool.ItemAssassinsKnife;
import sneakingshadow.bvks.item.tool.devil.*;
import sneakingshadow.bvks.item.tool.hammer.*;
import sneakingshadow.bvks.item.tool.obsidian.*;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.Ref;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModItems
{
    public static final Item DevilGem = new ItemDevilGem().setCreativeTab(CreativeTabBVKS.tabItem);
    public static final Item ObsidianIngot = new ItemObsidianIngot();
    public static final Item IronRod = new ItemIronRod();
    public static final Item AssassinsKnife = new ItemAssassinsKnife();
    public static final Item DevilArrow = new ItemDevilArrow();
    public static final Item DevilBow = new ItemDevilBow();
    public static final Item DevilIngot = new ItemDevilIngot();
    public static final Item ObsidianRod = new ItemObsidianRod();
    public static final Item DevilCompound = new ItemDevilCompound();
    public static final Item BottomlessVoid = new ItemBottomlessVoid();
    public static final Item CobbleGen = new ItemStoneGen();

    //Armor
    public static final Item DevilBoots = new ItemDevilBoots();
    public static final Item DevilLeggings = new ItemDevilLeggings();
    public static final Item DevilChestplate = new ItemDevilChestplate();
    public static final Item DevilHelmet = new ItemDevilHelmet();
    public static final Item ObsidianBoots = new ItemObsidianBoots();
    public static final Item ObsidianLeggings = new ItemObsidianLeggings();
    public static final Item ObsidianChestplate = new ItemObsidianChestplate();
    public static final Item ObsidianHelmet = new ItemObsidianHelmet();

    /**
     *    Tools
     */
    //Pickaxes
    public static final Item DevilPickaxe = new ItemDevilPickaxe();
    public static final Item ObsidianPickaxe = new ItemObsidianPickaxe();
    //Axes
    public static final Item DevilAxe = new ItemDevilAxe();
    public static final Item ObsidianAxe = new ItemObsidianAxe();
    //Shovels
    public static final Item DevilShovel = new ItemDevilShovel();
    public static final Item ObsidianShovel = new ItemObsidianShovel();
    //Swords
    public static final Item DevilSword = new ItemDevilSword();
    public static final Item ObsidianSword = new ItemObsidianSword();
    //Hoes
    public static final Item DevilHoe = new ItemDevilHoe();
    public static final Item ObsidianHoe = new ItemObsidianHoe();
    //Hammers

    public static final Item DevilHammer = new ItemDevilHammer();
    public static final Item DiamondHammer = new ItemDiamondHammer();
    public static final Item GoldHammer = new ItemGoldHammer();
    public static final Item IronHammer = new ItemIronHammer();
    public static final Item ObsidianHammer = new ItemObsidianHammer();
    public static final Item StoneHammer = new ItemStoneHammer();
    public static final Item WoodHammer = new ItemWoodHammer();

    public static final Item AdminHammer = new ItemAdminHammer();
    public static final Item DebugItem = new ItemDebugItem();

    public static void init()
    {
        registerItem(AssassinsKnife, Names.Items.ASSASSINS_KNIFE);
        registerItem(DevilArrow, Names.Items.DEVIL_ARROW);
        registerItem(DevilAxe, Names.Items.DEVIL_AXE);
        registerItem(DevilHoe, Names.Items.DEVIL_HOE);
        registerItem(DevilBoots, Names.Items.DEVIL_BOOTS);
        registerItem(DevilBow, Names.Items.DEVIL_BOW);
        registerItem(DevilChestplate, Names.Items.DEVIL_CHESTPLATE);
        registerItem(DevilGem, Names.Items.DEVIL_GEM);
        registerItem(DevilHammer, Names.Items.DEVIL_HAMMER);
        registerItem(DevilHelmet, Names.Items.DEVIL_HELMET);
        registerItem(DevilIngot, Names.Items.DEVIL_INGOT);
        registerItem(DevilLeggings, Names.Items.DEVIL_LEGGINGS);
        registerItem(DevilPickaxe, Names.Items.DEVIL_PICKAXE);
        registerItem(DevilShovel, Names.Items.DEVIL_SHOVEL);
        registerItem(DevilSword, Names.Items.DEVIL_SWORD);
        registerItem(DiamondHammer, Names.Items.DIAMOND_HAMMER);
        registerItem(GoldHammer, Names.Items.GOLD_HAMMER);
        registerItem(IronHammer, Names.Items.IRON_HAMMER);
        registerItem(IronRod, Names.Items.IRON_ROD);
        registerItem(ObsidianAxe, Names.Items.OBSIDIAN_AXE);
        registerItem(ObsidianBoots, Names.Items.OBSIDIAN_BOOTS);
        registerItem(ObsidianChestplate, Names.Items.OBSIDIAN_CHESTPLATE);
        registerItem(ObsidianHammer, Names.Items.OBSIDIAN_HAMMER);
        registerItem(ObsidianHelmet, Names.Items.OBSIDIAN_HELMET);
        registerItem(ObsidianHoe, Names.Items.OBSIDIAN_HOE);
        registerItem(ObsidianIngot, Names.Items.OBSIDIAN_INGOT);
        registerItem(ObsidianLeggings, Names.Items.OBSIDIAN_LEGGINGS);
        registerItem(ObsidianPickaxe, Names.Items.OBSIDIAN_PICKAXE);
        registerItem(ObsidianRod, Names.Items.OBSIDIAN_ROD);
        registerItem(ObsidianShovel, Names.Items.OBSIDIAN_SHOVEL);
        registerItem(ObsidianSword, Names.Items.OBSIDIAN_SWORD);
        registerItem(StoneHammer, Names.Items.STONE_HAMMER);
        registerItem(WoodHammer, Names.Items.WOOD_HAMMER);
        registerItem(DebugItem, Names.Items.DEBUG_ITEM);
        registerItem(DevilCompound, Names.Items.DEVIL_COMPOUND);
        registerItem(AdminHammer, Names.Items.ADMIN_HAMMER);
        registerItem(BottomlessVoid, Names.Items.BOTTOMLESS_VOID);
        registerItem(CobbleGen, Names.Items.STONE_GEN);
    }

    public static void add(){
        CreativeTabBVKS.add(new Item[]{
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
                CobbleGen,
                AssassinsKnife,
                DevilBow,
                DevilArrow,
                DevilGem,
                DevilIngot,
                DevilCompound,
                ObsidianIngot,
                ObsidianRod,
                IronRod,
        });
        CreativeTabBVKS.add(DebugItem);
    }

    private static void registerItem(Item item, String name){
        GameRegistry.registerItem(item, Ref.RESOURCE_PREFIX + "item_" + name);
    }
}
