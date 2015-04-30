package com.sneakingshadow.bvks.crafting;

import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.item.ItemDebugItem;
import com.sneakingshadow.bvks.item.base.ItemBVKSStorage;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class StorageItemRecipes implements IRecipe{
    /** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;
    private NBTTagCompound storageTag = new NBTTagCompound();

    public StorageItemRecipes(ItemStack itemStack)
    {
        this.recipeOutput = itemStack;
        this.recipeOutput.setTagCompound(new NBTTagCompound());

        cleanTag();
    }

    private void cleanTag(){
        storageTag.setInteger(Names.ItemStorage.id, -1);
        storageTag.setInteger(Names.ItemStorage.meta, 0);
        storageTag.setLong(Names.ItemStorage.storedAmount, 0);
        storageTag.setString(Names.ItemStorage.name, "");
        storageTag.setBoolean(Names.ItemStorage.active, false);
        storageTag.setTag(Names.ItemStorage.stackTag, new NBTTagCompound());
        storageTag.setBoolean(Names.ItemStorage.stackTagNull, true);
        storageTag.setInteger(Names.ItemStorage.removingAmount, 0);
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting inventoryCrafting, World p_77569_2_)
    {
        int num = 0;
        int num2 = 0;
        int x = 0;
        int y = 0;
        boolean flag = false;
        boolean flag2 = true;
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(j, i);

                if (itemStack != null) {
                    if (itemStack.getItem() instanceof ItemBVKSStorage){
                        if(itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info).getInteger(Names.ItemStorage.id) > 0)
                            flag = true;
                        num2++;
                    }else{
                        num++;
                        flag2 = false;
                    }
                    x=i;
                    y=j;
                }

                if(num >= 2 || num2 >= 2)
                    return false;
            }
        }
        return ( (num==1 && num2==1) && !flag ) || (flag && flag2);
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting)
    {
        cleanTag();

        ItemStack itemStack = getStorageItemStack(inventoryCrafting);
        if(itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());
        ItemStack output;
        ItemStack itemStack2 = getItemStack(inventoryCrafting);

        if(itemStack2 != null)
            itemStack.stackTagCompound.setTag(Names.ItemStorage.info, (NBTTagCompound)storageTag.copy());

        NBTTagCompound tag = itemStack.stackTagCompound.getCompoundTag(Names.ItemStorage.info);
        if(itemStack2 != null) {
            tag.setInteger(Names.ItemStorage.id, Item.getIdFromItem(itemStack2.getItem()));
            tag.setInteger(Names.ItemStorage.meta, itemStack2.getItemDamage());
            tag.setString(Names.ItemStorage.name, itemStack2.getDisplayName());
            tag.setLong(Names.ItemStorage.storedAmount, 1);
            if (itemStack2.stackTagCompound != null) {
                NBTTagCompound stackTag = (NBTTagCompound) itemStack2.stackTagCompound.copy();
                stackTag.setByte("Count", (byte) 0);
                tag.setTag(Names.ItemStorage.stackTag, stackTag);
                tag.setBoolean(Names.ItemStorage.stackTagNull, false);
            }
            int[] placement = getItemStackLocation(inventoryCrafting);

            output = itemStack.copy();
        }else{
            if(tag.getLong( Names.ItemStorage.storedAmount ) != 0) {

                int[] nums = getStorageItemStackLocation(inventoryCrafting);
                inventoryCrafting.getStackInRowAndColumn(nums[0],nums[1]).stackSize = 2;

                output = new ItemStack(Item.getItemById(tag.getInteger(Names.ItemStorage.id)), 1, tag.getInteger(Names.ItemStorage.meta));
                if (tag.getLong(Names.ItemStorage.storedAmount) > 64) {
                    output.stackSize = 64;
                    storageTag.setInteger(Names.ItemStorage.removingAmount, 64);
                } else {
                    output.stackSize = (int) tag.getLong(Names.ItemStorage.storedAmount);
                    storageTag.setInteger(Names.ItemStorage.removingAmount, (int) tag.getLong(Names.ItemStorage.storedAmount));
                }
                if (!tag.getBoolean(Names.ItemStorage.stackTagNull))
                    output.stackTagCompound = tag.getCompoundTag(Names.ItemStorage.stackTag);
            }else{
                output = new ItemStack(ModItems.DevilVoid);
            }
        }
        LogHelper.info("returning output");
        return output;
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize() { return 2; }

    private static ItemStack getItemStack(InventoryCrafting inventoryCrafting){
        int[] placement = getItemStackLocation(inventoryCrafting);
        if(placement != null)
            return inventoryCrafting.getStackInRowAndColumn(placement[0], placement[1]);
        return null;
    };

    private static int[] getItemStackLocation(InventoryCrafting inventoryCrafting){
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(i,j);
                if(itemStack != null && !(itemStack.getItem() instanceof ItemBVKSStorage)){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static ItemStack getStorageItemStack(InventoryCrafting inventoryCrafting){
        int[] placement = getStorageItemStackLocation(inventoryCrafting);
        if(placement != null)
            return inventoryCrafting.getStackInRowAndColumn(placement[0], placement[1]);
        return null;
    };

    private static int[] getStorageItemStackLocation(InventoryCrafting inventoryCrafting){
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(i,j);
                if(itemStack != null && itemStack.getItem() instanceof ItemBVKSStorage){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

