package com.sneakingshadow.bvks.reference;

import com.sneakingshadow.bvks.handler.ConfigurationHandler;
import com.sneakingshadow.bvks.util.LogHelper;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolMaterial {

    //devil stuff
    public static Item.ToolMaterial DevilPickaxe = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilPickaxe", 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilShovel = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilShovel", 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilSword = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilSword", 100, 30000, 100F, 100000F, 30);
    public static Item.ToolMaterial DevilAxe = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilAxe", 100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilHoe = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilHoe", 100, 1000000, 100000, 1000000, 30);
    public static Item.ToolMaterial DevilHammer = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilHammer", 100, 1000000, 100000, 1000000, 30);
}
