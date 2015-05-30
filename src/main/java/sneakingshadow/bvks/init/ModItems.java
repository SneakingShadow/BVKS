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
    /**
     *
     */
    public static final Item DevilGem = new ItemDevilGem().setCreativeTab(CreativeTabBVKS.tabItem);
    public static final Item ObsidianIngot = new ItemObsidianIngot();
    public static final Item IronRod = new ItemIronRod();
    public static final Item AssassinsKnife = new ItemAssassinsKnife();
    public static final Item DevilArrow = new ItemDevilArrow();
    public static final Item DevilBow = new ItemDevilBow();
    public static final Item DevilIngot = new ItemDevilIngot();
    public static final Item ObsidianRod = new ItemObsidianRod();
    public static final Item DevilCompound = new ItemDevilCompound();
    public static final Item BottomlessVoid = new ItemBottomlessVoid().setDescription("Stores one type of item");

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

    /**
     *   The common admin tools
     */
    public static final Item AdminHammer = new ItemAdminHammer();


    /**
     *   The allmighty, holy debug tool!!!
     */
    public static final Item DebugItem = new ItemDebugItem();

    public static void init()
    {
        registerItem(AssassinsKnife, Names.Items.AssassinsKnife);
        registerItem(DevilArrow, Names.Items.DevilArrow);
        registerItem(DevilAxe, Names.Items.DevilAxe);
        registerItem(DevilHoe, Names.Items.DevilHoe);
        registerItem(DevilBoots, Names.Items.DevilBoots);
        registerItem(DevilBow, Names.Items.DevilBow);
        registerItem(DevilChestplate, Names.Items.DevilChestplate);
        registerItem(DevilGem, Names.Items.DevilGem);
        registerItem(DevilHammer, Names.Items.DevilHammer);
        registerItem(DevilHelmet, Names.Items.DevilHelmet);
        registerItem(DevilIngot, Names.Items.DevilIngot);
        registerItem(DevilLeggings, Names.Items.DevilLeggings);
        registerItem(DevilPickaxe, Names.Items.DevilPickaxe);
        registerItem(DevilShovel, Names.Items.DevilShovel);
        registerItem(DevilSword, Names.Items.DevilSword);
        registerItem(DiamondHammer, Names.Items.DiamondHammer);
        registerItem(GoldHammer, Names.Items.GoldHammer);
        registerItem(IronHammer, Names.Items.IronHammer);
        registerItem(IronRod, Names.Items.IronRod);
        registerItem(ObsidianAxe, Names.Items.ObsidianAxe);
        registerItem(ObsidianBoots, Names.Items.ObsidianBoots);
        registerItem(ObsidianChestplate, Names.Items.ObsidianChestplate);
        registerItem(ObsidianHammer, Names.Items.ObsidianHammer);
        registerItem(ObsidianHelmet, Names.Items.ObsidianHelmet);
        registerItem(ObsidianHoe, Names.Items.ObsidianHoe);
        registerItem(ObsidianIngot, Names.Items.ObsidianIngot);
        registerItem(ObsidianLeggings, Names.Items.ObsidianLeggings);
        registerItem(ObsidianPickaxe, Names.Items.ObsidianPickaxe);
        registerItem(ObsidianRod, Names.Items.ObsidianRod);
        registerItem(ObsidianShovel, Names.Items.ObsidianShovel);
        registerItem(ObsidianSword, Names.Items.ObsidianSword);
        registerItem(StoneHammer, Names.Items.StoneHammer);
        registerItem(WoodHammer, Names.Items.WoodHammer);
        registerItem(DebugItem, Names.Items.DebugItem);
        registerItem(DevilCompound, Names.Items.DevilCompound);
        registerItem(AdminHammer, Names.Items.AdminHammer);
        registerItem(BottomlessVoid, Names.Items.BottomlessVoid);
    }

    public static void add(){
        CreativeTabBVKS.add(new Item[]
                {

                        BottomlessVoid,  AdminHammer,         DevilHammer,       ObsidianHammer,  DiamondHammer,  GoldHammer,       IronHammer,      StoneHammer,     WoodHammer,
                        DevilHelmet,     DevilChestplate,     DevilLeggings,     DevilBoots,      DevilSword,     DevilPickaxe,     DevilShovel,     DevilAxe,        DevilHoe,
                        ObsidianHelmet,  ObsidianChestplate,  ObsidianLeggings,  ObsidianBoots,   ObsidianSword,  ObsidianPickaxe,  ObsidianShovel,  ObsidianAxe,     ObsidianHoe,
                        AssassinsKnife,  DevilBow,            DevilArrow,        DevilGem,        DevilIngot,     DevilCompound,    ObsidianIngot,   ObsidianRod,     IronRod,

                }
        );
        CreativeTabBVKS.add(DebugItem);
    }

    private static void registerItem(Item item, String name){
        GameRegistry.registerItem(item, Ref.RESOURCE_PREFIX + "item_" + name);
    }
}
