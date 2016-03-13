package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import sneakingshadow.bvks.item.*;
import sneakingshadow.bvks.item.base.*;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Tool;

import java.util.List;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
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
    public static final Item ObsidianBoots = new ItemBVKSArmor(Name.Item.OBSIDIAN_BOOTS, Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.BOOTS);
    public static final Item ObsidianLeggings = new ItemBVKSArmor(Name.Item.OBSIDIAN_LEGGINGS, Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.LEGGINGS);
    public static final Item ObsidianChestplate = new ItemBVKSArmor(Name.Item.OBSIDIAN_CHESTPLATE, Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.CHESTPLATE);
    public static final Item ObsidianHelmet = new ItemBVKSArmor(Name.Item.OBSIDIAN_HELMET, Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.HELMET);

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
        registerItem(AssassinsKnife, Name.Item.ASSASSINS_KNIFE);
        registerItem(DevilArrow, Name.Item.DEVIL_ARROW);
        registerItem(DevilAxe, Name.Item.DEVIL_AXE);
        registerItem(DevilHoe, Name.Item.DEVIL_HOE);
        registerItem(DevilBoots, Name.Item.DEVIL_BOOTS);
        registerItem(DevilBow, Name.Item.DEVIL_BOW);
        registerItem(DevilChestplate, Name.Item.DEVIL_CHESTPLATE);
        registerItem(DevilGem, Name.Item.DEVIL_GEM);
        registerItem(DevilHammer, Name.Item.DEVIL_HAMMER);
        registerItem(DevilHelmet, Name.Item.DEVIL_HELMET);
        registerItem(DevilIngot, Name.Item.DEVIL_INGOT);
        registerItem(DevilLeggings, Name.Item.DEVIL_LEGGINGS);
        registerItem(DevilPickaxe, Name.Item.DEVIL_PICKAXE);
        registerItem(DevilShovel, Name.Item.DEVIL_SHOVEL);
        registerItem(DevilSword, Name.Item.DEVIL_SWORD);
        registerItem(DiamondHammer, Name.Item.DIAMOND_HAMMER);
        registerItem(GoldHammer, Name.Item.GOLD_HAMMER);
        registerItem(IronHammer, Name.Item.IRON_HAMMER);
        registerItem(IronRod, Name.Item.IRON_ROD);
        registerItem(ObsidianAxe, Name.Item.OBSIDIAN_AXE);
        registerItem(ObsidianBoots, Name.Item.OBSIDIAN_BOOTS);
        registerItem(ObsidianChestplate, Name.Item.OBSIDIAN_CHESTPLATE);
        registerItem(ObsidianHammer, Name.Item.OBSIDIAN_HAMMER);
        registerItem(ObsidianHelmet, Name.Item.OBSIDIAN_HELMET);
        registerItem(ObsidianHoe, Name.Item.OBSIDIAN_HOE);
        registerItem(ObsidianIngot, Name.Item.OBSIDIAN_INGOT);
        registerItem(ObsidianLeggings, Name.Item.OBSIDIAN_LEGGINGS);
        registerItem(ObsidianPickaxe, Name.Item.OBSIDIAN_PICKAXE);
        registerItem(ObsidianRod, Name.Item.OBSIDIAN_ROD);
        registerItem(ObsidianShovel, Name.Item.OBSIDIAN_SHOVEL);
        registerItem(ObsidianSword, Name.Item.OBSIDIAN_SWORD);
        registerItem(StoneHammer, Name.Item.STONE_HAMMER);
        registerItem(WoodHammer, Name.Item.WOOD_HAMMER);
        registerItem(DebugItem, Name.Item.DEBUG_ITEM);
        registerItem(NBTDebugItem, Name.Item.NBT_DEBUG_ITEM);
        registerItem(DevilCompound, Name.Item.DEVIL_COMPOUND);
        registerItem(AdminHammer, Name.Item.ADMIN_HAMMER);
        registerItem(BottomlessVoid, Name.Item.BOTTOMLESS_VOID);
        registerItem(StoneGen, Name.Item.STONE_GEN);
        registerItem(Hammer, Name.Item.HAMMER);
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
        CreativeTabBVKS.add(list, creativeTab, DebugItem);
        CreativeTabBVKS.add(list, creativeTab, NBTDebugItem);
    }

    private static void registerItem(Item item, String name){
        GameRegistry.registerItem(item, Ref.RESOURCE_PREFIX + "item_" + name);
    }
}