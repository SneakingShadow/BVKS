package com.sneakingshadow.bvks.reference;

import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Armor
{
    public static class Type
    {
        public static int HELMET = 0;
        public static int CHESTPLATE = 1;
        public static int LEGGINGS = 2;
        public static int BOOTS = 3;
    }

    public static class Material
    {
        public static final ItemArmor.ArmorMaterial Devil = EnumHelper.addArmorMaterial(Ref.MOD_ID+".devil", 100000, new int[] {6, 16, 12, 6}, 30);
        public static final ItemArmor.ArmorMaterial Obsidian = EnumHelper.addArmorMaterial(Ref.MOD_ID+".obsidian", 10000, new int[] {4, 9, 7, 4}, 5);
    }


}
