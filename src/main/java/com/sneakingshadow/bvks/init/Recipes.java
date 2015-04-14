package com.sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
    public static void init()
    {
        OreDictionary.registerOre("blockObsidian", Blocks.obsidian);
        OreDictionary.registerOre("ingotObsidian", ModItems.ObsidianIngot);
        OreDictionary.registerOre("gemDevil", ModItems.DevilGem);
        OreDictionary.registerOre("ingotDevil", ModItems.DevilIngot);
        OreDictionary.registerOre("stickIron", ModItems.IronRod);
        OreDictionary.registerOre("stickObsidian", ModItems.ObsidianRod);

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilPickaxe, "iii", " s ", " s ", 'i', ModItems.DevilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilAxe, "ii", "is", " s", 'i', ModItems.DevilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilSword, "i", "i", "s", 'i', ModItems.DevilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilShovel, "i", "s", "s", 'i', ModItems.DevilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilHoe, "ii", " s", " s", 'i', ModItems.DevilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilHammer, "iii", "isi", " s ", 'i', ModItems.DevilIngot, 's', "stickObsidian"));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianPickaxe, "iii", " s ", " s ", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianAxe, "ii", "is", " s", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianSword, "i", "i", "s", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianShovel, "i", "s", "s", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianHoe, "ii", " s", " s", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianHammer, "iii", "isi", " s ", 'i', "ingotObsidian", 's', "stickIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilHelmet, "iii", "i i", 'i', ModItems.DevilIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilChestplate, "i i", "iii", "iii", 'i', ModItems.DevilIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilLeggings, "iii", "i i", "i i", 'i', ModItems.DevilIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilBoots, "i i", "i i", 'i', ModItems.DevilIngot));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianHelmet, "iii", "i i", 'i', ModItems.ObsidianIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianChestplate, "i i", "iii", "iii", 'i', ModItems.ObsidianIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianLeggings, "iii", "i i", "i i", 'i', ModItems.ObsidianIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianBoots, "i i", "i i", 'i', ModItems.ObsidianIngot));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ObsidianRod, "o", "o", 'o', "ingotObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.IronRod, "o", "o", 'o', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.DevilCompound, "idi", "dgd", "idi", 'i', "ingotIron", 'd', "gemDiamond", 'g', ModItems.DevilGem));

        GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(ModItems.ObsidianIngot), 0.01F);
        GameRegistry.addSmelting(ModItems.DevilCompound, new ItemStack(ModItems.DevilIngot), 1F);
    }
}
