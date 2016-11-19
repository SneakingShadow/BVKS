package com.sneakingshadow.bvks.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by SneakingShadow on 01.06.2016.
 */
public class BottomlessVoidHelper {

    private static final String TAG_ITEM = "item";
    private static final String TAG_COUNT = "count";

    private static String[] prefixes = {
            "",                               // | Prefix | Symbol | Exponential | Multiplier
            "K",                              // | kilo   |   k    |   10^3      | 1,000
            "M",                              // | mega   |   M    |   10^6      | 1,000,000
            "G",                              // | giga   |   G    |   10^9      | 1,000,000,000
            "T",                              // | tera   |   T    |   10^12     | 1,000,000,000,000
            "P",                              // | peta   |   P    |   10^15     | 1,000,000,000,000,000
            "E",                              // | exa    |   E    |   10^18     | 1,000,000,000,000,000,000
            "Z",                              // | zetta  |   Z    |   10^21     | 1,000,000,000,000,000,000,000
            "Y",                              // | yotta  |   Y    |   10^24     | 1,000,000,000,000,000,000,000,000
    };

    private static final String TAG_BLOCK = "block";
    private static final String TAG_ITEM_MAX_SIZE = "item_max";

    /*
    *    metadata = 0: Data not set.
    *    metadata = 1: Data set. Not sucking up items from inventory.
    *    metadata = 2: Data set. Sucking up items from inventory.
    *
    *    Bottomless void, nbt tag structure.
    */

    public static void setItemStored(ItemStack itemStack, ItemStack itemStoring) {
        if (itemStoring == null) {
            return;
        }
        ensureStackTag(itemStack);
        itemStack.setItemDamage(itemStack.getItemDamage() == 0 ? 1 : itemStack.getItemDamage());
        ItemStack stack = itemStoring.copy();
        stack.stackSize = 1;
        itemStack.stackTagCompound.setTag(TAG_ITEM, stack.writeToNBT(new NBTTagCompound()));
        itemStack.stackTagCompound.setLong(TAG_COUNT, 1);
        itemStack.stackTagCompound.setBoolean(TAG_BLOCK, Block.getBlockFromItem(stack.getItem()) != Blocks.air);
        itemStack.stackTagCompound.setInteger(TAG_ITEM_MAX_SIZE, stack.getMaxStackSize());
    }

    private static boolean storesItem(ItemStack itemStack) {
        return itemStack.getItemDamage() != 0 && itemStack.hasTagCompound();
    }

    private static ItemStack getItem(ItemStack itemStack) {
        return storesItem(itemStack) ?
                ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag(TAG_ITEM)) :
                null;
    }

    public static long getCount(ItemStack itemStack) {
        return storesItem(itemStack) ?
                itemStack.getTagCompound().getLong(TAG_COUNT) :
                0;
    }

    public static void setCount(ItemStack itemStack, long count) {
        ensureStackTag(itemStack);
        itemStack.getTagCompound().setLong(TAG_COUNT, count < 0 ? 0 : count);
    }

    public static void removeTags(ItemStack itemStack) {
        itemStack.setItemDamage(0);
        if (itemStack.getTagCompound() != null){
            itemStack.getTagCompound().removeTag(TAG_ITEM);
            itemStack.getTagCompound().removeTag(TAG_COUNT);
            itemStack.getTagCompound().removeTag(TAG_BLOCK);
            itemStack.getTagCompound().removeTag(TAG_ITEM_MAX_SIZE);
            if (itemStack.getTagCompound().hasNoTags()){
                itemStack.setTagCompound(null);
            }
        }
    }

    private static void ensureStackTag(ItemStack itemStack) {
        if(!itemStack.hasTagCompound()) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static boolean hasItems(ItemStack itemStack) {
        return getCount(itemStack) > 0;
    }

    /**
     * @return how much was left after adding.
     * */
    public static long addToCount(ItemStack itemStack, long num) {
        long count = getCount(itemStack);
        long ret;
        if (num >= 0) {
            long limit = Long.MAX_VALUE - count;
            count = num > limit ? Long.MAX_VALUE : count + num;
            ret = num > limit ? num - limit : 0;
        }else{
            count = num*(-1) > count ? 0 : count + num;
            ret = num*(-1) > count ? count - num : 0;
        }
        setCount(itemStack, count);
        return ret;
    }

    /**
     * returns null if no item is stored
     * */
    public static ItemStack getItemStored(ItemStack itemStack) {
        return storesItem(itemStack) ?
                getItem(itemStack) :
                null;
    }

    /**
     * Returns null if it doesn't have a set item or it's empty
     * */
    public static ItemStack getItemStack(ItemStack itemStack){
        return hasItems(itemStack) ? getItem(itemStack) : null;
    }

    public static boolean storesBlock(ItemStack itemStack) {
        return storesItem(itemStack) && itemStack.stackTagCompound.getBoolean(TAG_BLOCK);
    }

    /**
     * Checks if the bottomless voids stores the item inputted
     * */
    public static boolean storesItem(ItemStack itemStack, ItemStack itemCompared) {
        if ( storesItem(itemStack) ) {
            ItemStack stack = getItemStored(itemStack);
            return itemCompared != null &&
                    stack.getItem() == itemCompared.getItem() &&
                    stack.getItemDamage() == itemCompared.getItemDamage() &&
                    (!stack.hasTagCompound() && !itemCompared.hasTagCompound() ||
                            stack.hasTagCompound() && itemCompared.hasTagCompound() &&
                                    stack.getTagCompound().equals( itemCompared.getTagCompound() )
                    );
        }
        return false;
    }

    public static ItemStack addItem(ItemStack itemStack, ItemStack itemAdd) {
        if(itemAdd != null && storesItem(itemStack,itemAdd)){
            addToCount(itemStack, itemAdd.stackSize);
            return null;
        }
        return itemAdd;
    }

    public static ItemStack extractStack(ItemStack itemStack) {
        ItemStack returnStack = getItemStack(itemStack);
        long count = getCount(itemStack);
        int max = returnStack.getMaxStackSize();
        returnStack.stackSize = (count > max) ? max : (int)count;
        return returnStack;
    }

    public static Block getBlock(ItemStack itemStack) {
        Block block = null;
        if (itemStack.getItemDamage() != 0) {
            ItemStack itemStack1 = getItem(itemStack);
            block = Block.getBlockFromItem(itemStack.getItem());
        }
        return block;
    }

    private static String compress(long num, int prefix){
        if(Long.toString(num).length() >= 4 && prefixes.length > prefix)
            return compress(num/1000, prefix+1);
        return Long.toString(num) + prefixes[prefix];
    }

    public static String compress(long num){
        return compress(num, 0);
    }

    private static String compress(int num, int prefix){
        if(Long.toString(num).length() >= 4 && prefixes.length > prefix)
            return compress(num/1000, prefix+1);
        return Long.toString(num) + prefixes[prefix];
    }

    public static String compress(int num){
        return compress(num, 0);
    }
}