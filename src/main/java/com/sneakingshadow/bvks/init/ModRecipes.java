package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.crafting.RecipeBottomlessVoid;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModRecipes
{
    public static void registerOreDic() {
        OreDictionary.registerOre("blockObsidian", Blocks.obsidian);
        OreDictionary.registerOre("ingotObsidian", ModItems.obsidianIngot);
        OreDictionary.registerOre("gemDevil", ModItems.devilGem);
        OreDictionary.registerOre("ingotDevil", ModItems.devilIngot);
        OreDictionary.registerOre("stickIron", ModItems.ironRod);
        OreDictionary.registerOre("stickObsidian", ModItems.obsidianRod);
    }

    //OreDictionary.WILDCARD_VALUE

    public static void shapedRecipes()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilPickaxe, "iii", " s ", " s ", 'i', ModItems.devilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilAxe, "ii", "is", " s", 'i', ModItems.devilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilSword, "i", "i", "s", 'i', ModItems.devilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilShovel, "i", "s", "s", 'i', ModItems.devilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilHoe, "ii", " s", " s", 'i', ModItems.devilIngot, 's', "stickObsidian"));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianPickaxe, "iii", " s ", " s ", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianAxe, "ii", "is", " s", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianSword, "i", "i", "s", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianShovel, "i", "s", "s", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianHoe, "ii", " s", " s", 'i', "ingotObsidian", 's', "stickIron"));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilHelmet, "iii", "i i", 'i', ModItems.devilIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilChestplate, "i i", "iii", "iii", 'i', ModItems.devilIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilLeggings, "iii", "i i", "i i", 'i', ModItems.devilIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilBoots, "i i", "i i", 'i', ModItems.devilIngot));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianHelmet, "iii", "i i", 'i', ModItems.obsidianIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianChestplate, "i i", "iii", "iii", 'i', ModItems.obsidianIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianLeggings, "iii", "i i", "i i", 'i', ModItems.obsidianIngot));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianBoots, "i i", "i i", 'i', ModItems.obsidianIngot));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilHammer, "iii", "iii", " s ", 'i', ModItems.devilIngot, 's', "stickObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianHammer, "iii", "iii", " s ", 'i', "ingotObsidian", 's', "stickIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.diamondHammer, "iii", "iii", " s ", 'i', "gemDiamond", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.goldHammer, "iii", "iii", " s ", 'i', "ingotGold", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ironHammer, "iii", "iii", " s ", 'i', "ingotIron", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.stoneHammer, "iii", "iii", " s ", 'i', "cobblestone", 's', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.woodHammer, "iii", "iii", " s ", 'i', "logWood", 's', "stickWood"));

        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.obsidianRod, "o", "o", 'o', "ingotObsidian"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.ironRod, "o", "o", 'o', "ingotIron"));
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.devilCompound, "idi", "dgd", "idi", 'i', "ingotIron", 'd', "gemDiamond", 'g', ModItems.devilGem));
    }

    public static void shapelessRecipes() {

    }

    public static void smelting() {
        GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(ModItems.obsidianIngot), 0.01F);
        GameRegistry.addSmelting(ModItems.devilCompound, new ItemStack(ModItems.devilIngot), 1F);
    }

    public static void customRecipes(){
        GameRegistry.addRecipe(new RecipeBottomlessVoid.Extract());
        GameRegistry.addRecipe(new RecipeBottomlessVoid.SetType());
        GameRegistry.addRecipe(new RecipeBottomlessVoid.Clear());
    }

    public static void init(){
        registerOreDic();
        customRecipes();
        shapedRecipes();
        shapelessRecipes();
        smelting();
    }
}
