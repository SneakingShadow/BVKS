package sneakingshadow.bvks.reference;

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
        public static final ItemArmor.ArmorMaterial Obsidian = EnumHelper.addArmorMaterial(Ref.MOD_ID+".obsidian", 10000, new int[] {3,7,6,2}, 5);
    }

    //CLOTH(5, new int[]{1, 3, 2, 1}, 15),          7
    //CHAIN(15, new int[]{2, 5, 4, 1}, 12),         12
    //IRON(15, new int[]{2, 6, 5, 2}, 9),           15
    //GOLD(7, new int[]{2, 5, 3, 1}, 25),           11
    //DIAMOND(33, new int[]{3, 8, 6, 3}, 10);       20
}
