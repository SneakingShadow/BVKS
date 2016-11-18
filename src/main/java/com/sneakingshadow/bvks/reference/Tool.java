package com.sneakingshadow.bvks.reference;

import net.minecraftforge.common.util.EnumHelper;

public class Tool {

    public static class ItemToolMaterial {

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
        public static net.minecraft.item.Item.ToolMaterial ADMIN_HAMMER = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX + Name.Item.ADMIN_HAMMER, Integer.MAX_VALUE, Integer.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Integer.MAX_VALUE);

        //devil stuff
        public static net.minecraft.item.Item.ToolMaterial DEVIL_PICKAXE = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.DEVIL_PICKAXE, 100, 30000,   10000F, 5F,      30);
        public static net.minecraft.item.Item.ToolMaterial DEVIL_SHOVEL  = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.DEVIL_SHOVEL , 100, 30000,   10000F, 5F,      30);
        public static net.minecraft.item.Item.ToolMaterial DEVIL_SWORD   = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.DEVIL_SWORD  , 100, 30000,   100F,   100000F, 30);
        public static net.minecraft.item.Item.ToolMaterial DEVIL_AXE     = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.DEVIL_AXE    , 100, 30000,   10000F, 5F,      30);
        public static net.minecraft.item.Item.ToolMaterial DEVIL_HOE     = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.DEVIL_HOE    , 100, 1000000, 100000, 1000000, 30);
        public static net.minecraft.item.Item.ToolMaterial DEVIL_HAMMER  = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.DEVIL_HAMMER , 100, 1000000, 100000, 1000000, 30);

        public static net.minecraft.item.Item.ToolMaterial OBSIDIAN = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.OBSIDIAN_PICKAXE, 4, 1000, 6.4F, 4F, 12);
        //Hammers
        public static net.minecraft.item.Item.ToolMaterial WOOD_HAMMER = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.WOOD_HAMMER, net.minecraft.item.Item.ToolMaterial.WOOD.getHarvestLevel(), net.minecraft.item.Item.ToolMaterial.WOOD.getMaxUses(), BaseHammerEfficiency * net.minecraft.item.Item.ToolMaterial.WOOD.getEfficiencyOnProperMaterial(), net.minecraft.item.Item.ToolMaterial.WOOD.getDamageVsEntity(), net.minecraft.item.Item.ToolMaterial.WOOD.getEnchantability());
        public static net.minecraft.item.Item.ToolMaterial STONE_HAMMER = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.STONE_HAMMER, net.minecraft.item.Item.ToolMaterial.STONE.getHarvestLevel(), net.minecraft.item.Item.ToolMaterial.STONE.getMaxUses(), BaseHammerEfficiency * net.minecraft.item.Item.ToolMaterial.STONE.getEfficiencyOnProperMaterial(), net.minecraft.item.Item.ToolMaterial.STONE.getDamageVsEntity(), net.minecraft.item.Item.ToolMaterial.STONE.getEnchantability());
        public static net.minecraft.item.Item.ToolMaterial IRON_HAMMER = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX + Name.Item.IRON_HAMMER, net.minecraft.item.Item.ToolMaterial.IRON.getHarvestLevel(), net.minecraft.item.Item.ToolMaterial.IRON.getMaxUses(), BaseHammerEfficiency * net.minecraft.item.Item.ToolMaterial.IRON.getEfficiencyOnProperMaterial(), net.minecraft.item.Item.ToolMaterial.IRON.getDamageVsEntity(), net.minecraft.item.Item.ToolMaterial.IRON.getEnchantability());
        public static net.minecraft.item.Item.ToolMaterial GOLD_HAMMER = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX+ Name.Item.GOLD_HAMMER, net.minecraft.item.Item.ToolMaterial.GOLD.getHarvestLevel(), net.minecraft.item.Item.ToolMaterial.GOLD.getMaxUses(), BaseHammerEfficiency * net.minecraft.item.Item.ToolMaterial.GOLD.getEfficiencyOnProperMaterial(), net.minecraft.item.Item.ToolMaterial.GOLD.getDamageVsEntity(), net.minecraft.item.Item.ToolMaterial.GOLD.getEnchantability());
        public static net.minecraft.item.Item.ToolMaterial DIAMOND_HAMMER = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX + Name.Item.DIAMOND_HAMMER, net.minecraft.item.Item.ToolMaterial.EMERALD.getHarvestLevel(), net.minecraft.item.Item.ToolMaterial.EMERALD.getMaxUses(), BaseHammerEfficiency * net.minecraft.item.Item.ToolMaterial.EMERALD.getEfficiencyOnProperMaterial(), net.minecraft.item.Item.ToolMaterial.EMERALD.getDamageVsEntity(), net.minecraft.item.Item.ToolMaterial.EMERALD.getEnchantability());
        public static net.minecraft.item.Item.ToolMaterial OBSIDIAN_HAMMER = EnumHelper.addToolMaterial(Reference.RESOURCE_PREFIX + Name.Item.OBSIDIAN_HAMMER, OBSIDIAN.getHarvestLevel(), OBSIDIAN.getMaxUses(), BaseHammerEfficiency * OBSIDIAN.getEfficiencyOnProperMaterial(), OBSIDIAN.getDamageVsEntity(), OBSIDIAN.getEnchantability());
    }

    public static class Level {
        public static int WOOD = 0;
        public static int STONE = 1;
        public static int IRON = 2;
        public static int DIAMOND = 3;
        public static int GOLD = 0;
    }

}
