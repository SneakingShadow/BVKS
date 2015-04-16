package com.sneakingshadow.bvks.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class EnchantmentHelper
{
    /**
     * Remember to check for: !world.isRemote && !world.restoringBlockSnapshots
     */
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

    /**
     * Remember to check for: !world.isRemote && !world.restoringBlockSnapshots
     */
    public static int getLevel(int id, ItemStack itemStack){ return getLevel(id, itemStack.getEnchantmentTagList()); }

    /**
     * Remember to check for: !world.isRemote && !world.restoringBlockSnapshots
     */
    public static int getLevel(Enchantment id, NBTTagList tagList){ return getLevel(id.effectId, tagList); }

    /**
     * Remember to check for: !world.isRemote && !world.restoringBlockSnapshots
     */
    public static int getLevel(Enchantment id, ItemStack itemStack){ return getLevel(id, itemStack.getEnchantmentTagList()); }

    public static NBTTagList setLevel(int level, int id, NBTTagList tagList){
        if(tagList != null){
            boolean booly = true;
            for (int i = 0; i < tagList.tagCount(); i++) {
                if (tagList.getCompoundTagAt(i).getShort("id") == id) {
                    tagList.getCompoundTagAt(i).setShort("lvl", (short) level);

                    booly = false;
                }
            }
            if(booly){
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setShort("id", (short)id);
                tagCompound.setShort("lvl", (short)level);
                tagList.appendTag( tagCompound );
            }
        }
        return tagList;
    }
}
