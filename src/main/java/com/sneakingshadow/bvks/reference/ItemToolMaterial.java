package com.sneakingshadow.bvks.reference;

import com.sneakingshadow.bvks.handler.ConfigurationHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ItemToolMaterial {

    //devil stuff
    public static Item.ToolMaterial DevilPickaxe = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilPickaxe", ConfigurationHandler.DPickaxeHarvestLevel, ConfigurationHandler.DPickaxeMaxUses, ConfigurationHandler.DPickaxeEfficiency, ConfigurationHandler.DPickaxeDamage, ConfigurationHandler.DPickaxeEnchantability);//100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilShovel = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilShovel", ConfigurationHandler.DShovelHarvestLevel, ConfigurationHandler.DShovelMaxUses, ConfigurationHandler.DShovelEfficiency, ConfigurationHandler.DShovelDamage, ConfigurationHandler.DShovelEnchantability);//100, 30000, 10000F, 5F, 30);
    public static Item.ToolMaterial DevilSword = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilSword", ConfigurationHandler.DSwordHarvestLevel, ConfigurationHandler.DSwordMaxUses, ConfigurationHandler.DSwordEfficiency, ConfigurationHandler.DSwordDamage, ConfigurationHandler.DSwordEnchantability);//100, 30000, 100F, 100000F, 30);
    public static Item.ToolMaterial DevilAxe = EnumHelper.addToolMaterial(Ref.MOD_ID+".devilAxe", ConfigurationHandler.DAxeHarvestLevel, ConfigurationHandler.DAxeMaxUses, ConfigurationHandler.DAxeEfficiency, ConfigurationHandler.DAxeDamage, ConfigurationHandler.DAxeEnchantability);//100, 30000, 10000F, 5F, 30);

}
