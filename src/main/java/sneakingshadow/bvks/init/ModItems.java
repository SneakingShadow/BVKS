package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
    public static final net.minecraft.item.Item DevilGem = new ItemBVKS().setUnlocalizedName(Name.Item.DEVIL_GEM).setCreativeTab(CreativeTabBVKS.tabItem);
    public static final net.minecraft.item.Item ObsidianIngot = new ItemBVKS().setUnlocalizedName(Name.Item.OBSIDIAN_INGOT);
    public static final net.minecraft.item.Item IronRod = new ItemBVKS().setUnlocalizedName(Name.Item.IRON_ROD);
    public static final net.minecraft.item.Item DevilArrow = new ItemBVKS().setUnlocalizedName(Name.Item.DEVIL_ARROW);
    public static final net.minecraft.item.Item DevilIngot = new ItemBVKS().setUnlocalizedName(Name.Item.DEVIL_INGOT);
    public static final net.minecraft.item.Item ObsidianRod = new ItemBVKS().setUnlocalizedName(Name.Item.OBSIDIAN_ROD);
    public static final net.minecraft.item.Item DevilCompound = new ItemBVKS().setUnlocalizedName(Name.Item.DEVIL_COMPOUND);
    public static final net.minecraft.item.Item BottomlessVoid = new ItemBottomlessVoid();
    public static final net.minecraft.item.Item StoneGen = new ItemStoneGen();
    public static final net.minecraft.item.Item DevilBow = new ItemDevilBow();
    public static final net.minecraft.item.Item AssassinsKnife = new ItemAssassinsKnife();

    //Armor
    public static final net.minecraft.item.Item DevilBoots = new ItemArmorDevilBoots();
    public static final net.minecraft.item.Item DevilLeggings = new ItemArmorDevilLeggings();
    public static final net.minecraft.item.Item DevilChestplate = new ItemArmorDevilChestplate();
    public static final net.minecraft.item.Item DevilHelmet = new ItemArmorDevilHelmet();
    public static final net.minecraft.item.Item ObsidianBoots = new ItemBVKSArmor(Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.BOOTS).setUnlocalizedName(Name.Item.OBSIDIAN_BOOTS);
    public static final net.minecraft.item.Item ObsidianLeggings = new ItemBVKSArmor(Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.LEGGINGS).setUnlocalizedName(Name.Item.OBSIDIAN_LEGGINGS);
    public static final net.minecraft.item.Item ObsidianChestplate = new ItemBVKSArmor(Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.CHESTPLATE).setUnlocalizedName(Name.Item.OBSIDIAN_CHESTPLATE);
    public static final net.minecraft.item.Item ObsidianHelmet = new ItemBVKSArmor(Name.Armor.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Material.OBSIDIAN, sneakingshadow.bvks.reference.Armor.Type.HELMET).setUnlocalizedName(Name.Item.OBSIDIAN_HELMET);

    /**
     *    Tools
     */
    //Devil
    public static final net.minecraft.item.Item DevilPickaxe = new ItemToolDevilPickaxe();
    public static final net.minecraft.item.Item DevilShovel = new ItemToolDevilShovel();
    public static final net.minecraft.item.Item DevilSword = new ItemToolDevilSword();
    public static final net.minecraft.item.Item DevilAxe = new ItemToolDevilAxe();
    public static final net.minecraft.item.Item DevilHoe = new ItemToolDevilHoe();
    //Obsidian
    public static final net.minecraft.item.Item ObsidianPickaxe = new ItemBVKSPickaxe(Tool.ItemToolMaterial.OBSIDIAN).setUnlocalizedName(Name.Item.OBSIDIAN_PICKAXE);
    public static final net.minecraft.item.Item ObsidianShovel = new ItemBVKSShovel(Tool.ItemToolMaterial.OBSIDIAN).setUnlocalizedName(Name.Item.OBSIDIAN_SHOVEL);
    public static final net.minecraft.item.Item ObsidianSword = new ItemBVKSSword(Tool.ItemToolMaterial.OBSIDIAN).setUnlocalizedName(Name.Item.OBSIDIAN_SWORD);
    public static final net.minecraft.item.Item ObsidianAxe = new ItemBVKSAxe(Tool.ItemToolMaterial.OBSIDIAN).setUnlocalizedName(Name.Item.OBSIDIAN_AXE);
    public static final net.minecraft.item.Item ObsidianHoe = new ItemBVKSHoe(Tool.ItemToolMaterial.OBSIDIAN).setUnlocalizedName(Name.Item.OBSIDIAN_HOE);

    //Hammers
    public static final net.minecraft.item.Item DevilHammer = new ItemBVKSHammer(Tool.ItemToolMaterial.DEVIL_HAMMER, 9, ModItems.DevilShovel){
        @Override
        public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
        {
            list.add("The devil has a taste for worlds");
        }

        @Override
        public boolean isDamageable() { return false; }
    }.setUnlocalizedName(Name.Item.DEVIL_HAMMER);
    public static final net.minecraft.item.Item ObsidianHammer = new ItemBVKSHammer(Tool.ItemToolMaterial.OBSIDIAN_HAMMER, 4, ModItems.ObsidianShovel).setUnlocalizedName(Name.Item.OBSIDIAN_HAMMER);
    public static final net.minecraft.item.Item DiamondHammer = new ItemBVKSHammer(Tool.ItemToolMaterial.DIAMOND_HAMMER, 5, Items.diamond_shovel).setUnlocalizedName(Name.Item.DIAMOND_HAMMER);
    public static final net.minecraft.item.Item GoldHammer = new ItemBVKSHammer(Tool.ItemToolMaterial.GOLD_HAMMER, 3, Items.golden_shovel).setUnlocalizedName(Name.Item.GOLD_HAMMER);
    public static final net.minecraft.item.Item IronHammer = new ItemBVKSHammer(Tool.ItemToolMaterial.IRON_HAMMER, 3, Items.iron_shovel).setUnlocalizedName(Name.Item.IRON_HAMMER);
    public static final net.minecraft.item.Item StoneHammer = new ItemBVKSHammer(Tool.ItemToolMaterial.STONE_HAMMER, 2, Items.stone_shovel).setUnlocalizedName(Name.Item.STONE_HAMMER);
    public static final net.minecraft.item.Item WoodHammer = new ItemBVKSHammer(Tool.ItemToolMaterial.WOOD_HAMMER, 1, Items.wooden_shovel).setUnlocalizedName(Name.Item.WOOD_HAMMER);

    public static final net.minecraft.item.Item AdminHammer = new ItemAdminHammer();
    public static final net.minecraft.item.Item DebugItem = new ItemDebugItem();
    public static final net.minecraft.item.Item NBTDebugItem = new ItemNBTDebugItem();

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
    }

    public static void add(List list){
        CreativeTabBVKS.add(list, new net.minecraft.item.Item[]{
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
        });
        CreativeTabBVKS.add(list, DebugItem);
        CreativeTabBVKS.add(list, NBTDebugItem);
    }

    private static void registerItem(net.minecraft.item.Item item, String name){
        GameRegistry.registerItem(item, Ref.RESOURCE_PREFIX + "item_" + name);
    }
}
