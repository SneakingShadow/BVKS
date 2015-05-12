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
    private static float BaseEfficiency = 2F;
    private static float BaseHammerEfficiency = 1.8F;

    //Admin
    public static Item.ToolMaterial AdminHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.AdminHammer, Integer.MAX_VALUE, Integer.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Integer.MAX_VALUE);

    //devil stuff
    public static Item.ToolMaterial DevilPickaxe = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DevilPickaxe, 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilShovel = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DevilShovel, 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilSword = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DevilSword, 100, 30000, 100F, 100000F, 30);
    public static Item.ToolMaterial DevilAxe = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DevilAxe, 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilHoe = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DevilHoe, 100, 1000000, 100000, 1000000, 30);
    public static Item.ToolMaterial DevilHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DevilHammer, 100, 1000000, 100000, 1000000, 30);

    public static Item.ToolMaterial Obsidian = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.ObsidianPickaxe, 4, 1000, BaseEfficiency*3.2F, 4F, 12);
    //Hammers
    public static Item.ToolMaterial WoodHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.WoodHammer, 0, 59, BaseHammerEfficiency, 0.0F, 15);
    public static Item.ToolMaterial StoneHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.StoneHammer, 1, 131, BaseHammerEfficiency*2, 1.0F, 5);
    public static Item.ToolMaterial IronHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.IronHammer, 2, 250, BaseHammerEfficiency*3, 2.0F, 14);
    public static Item.ToolMaterial GoldHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.GoldHammer, 0, 32, BaseHammerEfficiency*6, 0.0F, 22);
    public static Item.ToolMaterial DiamondHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.DiamondHammer, 3, 1561, BaseHammerEfficiency*4, 3.0F, 10);
    public static Item.ToolMaterial ObsidianHammer = EnumHelper.addToolMaterial(Ref.RESOURCE_PREFIX+Names.Items.ObsidianHammer, 4, 1000, BaseHammerEfficiency*3.2F, 4F, 12);
}
