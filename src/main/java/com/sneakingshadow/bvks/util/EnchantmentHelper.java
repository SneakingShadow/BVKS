package com.sneakingshadow.bvks.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class EnchantmentHelper
{
    public static int getLevel(int id, NBTTagList tagList) {
        if(tagList != null){
            for (int i = 0; i < tagList.tagCount(); i++) {
                if (tagList.getCompoundTagAt(i).getShort("id") == id) {
                    return tagList.getCompoundTagAt(i).getShort("lvl");
                }
            }
        }
        return 0;
    }

    public static int getLevel(int id, ItemStack itemStack){ return getLevel(id, itemStack.getEnchantmentTagList()); }

    public static int getLevel(Enchantment id, NBTTagList tagList){ return getLevel(id.effectId, tagList); }

    public static int getLevel(Enchantment id, ItemStack itemStack){ return getLevel(id, itemStack.getEnchantmentTagList()); }

    public static void setLevel(Enchantment enchantment, int level, ItemStack itemStack){
        NBTTagList tagList = itemStack.getEnchantmentTagList();

        if(tagList != null){
            boolean booly = true;
            for (int i = 0; i < tagList.tagCount(); i++) {
                if (tagList.getCompoundTagAt(i).getShort("id") == enchantment.effectId) {
                    tagList.getCompoundTagAt(i).setShort("lvl", (short) level);

                    booly = false;
                }
            }
            if(booly){
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setShort("id", (short)enchantment.effectId);
                tagCompound.setShort("lvl", (short)level);
                tagList.appendTag( tagCompound );
            }
        }else{
            itemStack.addEnchantment(enchantment, level);
        }
    }

    public static void remove(Enchantment enchantment, ItemStack itemStack){
        NBTTagList tagList = itemStack.getEnchantmentTagList();

        if(tagList != null) {
            for (int i = 0; i < tagList.tagCount(); i++) {
                if(tagList.getCompoundTagAt(i).getShort("id") == enchantment.effectId) {
                    tagList.removeTag(i);
                    return;
                }
            }
        }
    }

    public static void removeAll(ItemStack itemStack){
        itemStack.stackTagCompound.removeTag("ench");
    }

    public static boolean hasEnchant(Enchantment enchantment, ItemStack itemStack){
        NBTTagList tagList = itemStack.getEnchantmentTagList();

        if(tagList != null) {
            for (int i = 0; i < tagList.tagCount(); i++) {
                if(tagList.getCompoundTagAt(i).getShort("id") == enchantment.effectId) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasEnchantOtherThan(Enchantment enchantment, ItemStack itemStack){
        NBTTagList tagList = itemStack.getEnchantmentTagList();

        if(tagList != null) {
            for (int i = 0; i < tagList.tagCount(); i++) {
                if(tagList.getCompoundTagAt(i).getShort("id") != enchantment.effectId) {
                    return true;
                }
            }
        }
        return false;
    }
}
