package sneakingshadow.bvks.util;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by SneakingShadow on 01.06.2016.
 */
public class BottomlessVoidHelper {

    private static final String TAG_ITEM = "item";
    private static final String TAG_COUNT = "count";

    /*
    *    metadata = 0: Data not set.
    *    metadata = 1: Data set. Not sucking up items.
    *    metadata = 2: Data set. Sucking up items.
    *
    *
    *
    *    Bottomless void, nbt tag structure.
    *
    *    stacktag {
    *        (tagCompound)item {
    *             itemStack.writeToNBT(new nbtTagCompound)
    *        }
    *        (long) count
    *    }
    *
    */

    private static void setupTags(ItemStack itemStack) {
        if(!itemStack.hasTagCompound()) {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static long getCount(ItemStack itemStack) {
        return (itemStack.getItemDamage() != 0 && itemStack.hasTagCompound()) ? itemStack.getTagCompound().getLong(TAG_COUNT) : 0;
    }

    public static void setCount(ItemStack itemStack, long count) {
        setupTags(itemStack);
        itemStack.getTagCompound().setLong(TAG_COUNT, count < 0 ? 0 : count);
    }

    public static boolean hasItems(ItemStack itemStack) {
        return getCount(itemStack) > 0;
    }

    public static long addToCount(ItemStack itemStack, long num) {
        long count = getCount(itemStack);
        long ret = 0;
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

    public static void setItemStored(ItemStack itemStack, ItemStack itemStoring) {
        if (itemStoring == null) {
            return;
        }
        setupTags(itemStack);
        itemStack.setItemDamage(itemStack.getItemDamage() == 0 ? 1 : itemStack.getItemDamage());
        itemStoring.stackSize = 1;
        itemStack.stackTagCompound.setTag(TAG_ITEM, itemStoring.writeToNBT(new NBTTagCompound()));
    }

    public static ItemStack getItemStored(ItemStack itemStack) {
        return itemStack.getItemDamage() == 0 ? null : getItem(itemStack);
    }

    private static ItemStack getItem(ItemStack itemStack) {
        return itemStack.hasTagCompound() && itemStack.getItemDamage() != 0 ?
                ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag(TAG_ITEM)) :
                null;
    }

    /**
     * Returns null if it doesn't have a set item or it's
     * */
    public static ItemStack getItemStack(ItemStack itemStack){
        return hasItems(itemStack) ? getItem(itemStack) : null;
    }

    public static boolean storesBlock(ItemStack itemStack) {
        ItemStack itemStored = getItemStored(itemStack);
        return itemStored != null && itemStored.getItem() instanceof ItemBlock;
    }

    public static boolean storesItem(ItemStack itemStack, ItemStack itemCompared) {
        if (itemStack.getItemDamage() != 0) {
            ItemStack itemStack1 = getItemStored(itemStack);
            return itemCompared != null && itemStack1.getItem() == itemCompared.getItem() &&
                    itemStack1.getItemDamage() == itemCompared.getItemDamage() &&
                    (!itemStack1.hasTagCompound() && !itemCompared.hasTagCompound() ||
                            itemStack1.hasTagCompound() && itemCompared.hasTagCompound() &&
                                    itemStack1.getTagCompound().equals(itemCompared.getTagCompound()));
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

    public static void removeTags(ItemStack itemStack) {
        itemStack.setItemDamage(0);
        if (itemStack.getTagCompound() != null){
            itemStack.getTagCompound().removeTag(TAG_ITEM);
            itemStack.getTagCompound().removeTag(TAG_COUNT);
            if (itemStack.getTagCompound().hasNoTags()){
                itemStack.setTagCompound(null);
            }
        }
    }

    public static Block getBlock(ItemStack itemStack) {
        Block block = null;
        if (itemStack.getItemDamage() != 0) {
            ItemStack itemStack1 = getItem(itemStack);
            block = Block.getBlockFromItem(itemStack.getItem());
        }
        return block;
    }
}