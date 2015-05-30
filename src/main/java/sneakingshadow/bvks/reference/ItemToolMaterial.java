package sneakingshadow.bvks.reference;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolMaterial {

    /**
     *
     *      WOOD(0, 59, 2.0F, 0.0F, 15),
     *      STONE(1, 131, 4.0F, 1.0F, 5),
     *      IRON(2, 250, 6.0F, 2.0F, 14),
     *      EMERALD(3, 1561, 8.0F, 3.0F, 10),
     *      GOLD(0, 32, 12.0F, 0.0F, 22);
     *
     */
    private static float BaseHammerEfficiency = 0.75F;

    //Admin
    public static Item.ToolMaterial ADMIN_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.ADMIN_HAMMER, Integer.MAX_VALUE, Integer.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Integer.MAX_VALUE);

    //devil stuff
    public static Item.ToolMaterial DEVIL_PICKAXE = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DEVIL_PICKAXE, 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DEVIL_SHOVEL = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DEVIL_SHOVEL, 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DEVIL_SWORD = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DEVIL_SWORD, 100, 30000, 100F, 100000F, 30);
    public static Item.ToolMaterial DEVIL_AXE = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DEVIL_AXE, 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DEVIL_HOE = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DEVIL_HOE, 100, 1000000, 100000, 1000000, 30);
    public static Item.ToolMaterial DEVIL_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DEVIL_HAMMER, 100, 1000000, 100000, 1000000, 30);

    public static Item.ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.OBSIDIAN_PICKAXE, 4, 1000, 6.4F, 4F, 12);
    //Hammers
    public static Item.ToolMaterial WOOD_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.WOOD_HAMMER, Item.ToolMaterial.WOOD.getHarvestLevel(), Item.ToolMaterial.WOOD.getMaxUses(), BaseHammerEfficiency * Item.ToolMaterial.WOOD.getEfficiencyOnProperMaterial(), Item.ToolMaterial.WOOD.getDamageVsEntity(), Item.ToolMaterial.WOOD.getEnchantability());
    public static Item.ToolMaterial STONE_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.STONE_HAMMER, Item.ToolMaterial.STONE.getHarvestLevel(), Item.ToolMaterial.STONE.getMaxUses(), BaseHammerEfficiency * Item.ToolMaterial.STONE.getEfficiencyOnProperMaterial(), Item.ToolMaterial.STONE.getDamageVsEntity(), Item.ToolMaterial.STONE.getEnchantability());
    public static Item.ToolMaterial IRON_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX + Names.Items.IRON_HAMMER, Item.ToolMaterial.IRON.getHarvestLevel(), Item.ToolMaterial.IRON.getMaxUses(), BaseHammerEfficiency * Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(), Item.ToolMaterial.IRON.getDamageVsEntity(), Item.ToolMaterial.IRON.getEnchantability());
    public static Item.ToolMaterial GOLD_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.GOLD_HAMMER, Item.ToolMaterial.GOLD.getHarvestLevel(), Item.ToolMaterial.GOLD.getMaxUses(), BaseHammerEfficiency * Item.ToolMaterial.GOLD.getEfficiencyOnProperMaterial(), Item.ToolMaterial.GOLD.getDamageVsEntity(), Item.ToolMaterial.GOLD.getEnchantability());
    public static Item.ToolMaterial DIAMOND_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX + Names.Items.DIAMOND_HAMMER, Item.ToolMaterial.EMERALD.getHarvestLevel(), Item.ToolMaterial.EMERALD.getMaxUses(), BaseHammerEfficiency * Item.ToolMaterial.EMERALD.getEfficiencyOnProperMaterial(), Item.ToolMaterial.EMERALD.getDamageVsEntity(), Item.ToolMaterial.EMERALD.getEnchantability());
    public static Item.ToolMaterial OBSIDIAN_HAMMER = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX + Names.Items.OBSIDIAN_HAMMER, OBSIDIAN.getHarvestLevel(), OBSIDIAN.getMaxUses(), BaseHammerEfficiency * OBSIDIAN.getEfficiencyOnProperMaterial(), OBSIDIAN.getDamageVsEntity(), OBSIDIAN.getEnchantability());
}
