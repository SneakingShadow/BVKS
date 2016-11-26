package com.sneakingshadow.bvks.crafting;

import com.sneakingshadow.bvks.init.ModItems;
import com.sneakingshadow.bvks.item.ItemBottomlessVoid;
import com.sneakingshadow.bvks.util.BottomlessVoidHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class RecipeBottomlessVoid {

    public static class Extract implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack != null) {
                    if (!flag && itemStack.getItem() == ModItems.BottomlessVoid && BottomlessVoidHelper.hasItems(itemStack))
                        flag = true;
                    else return false;
                }
            }

            return flag;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            ItemStack itemStack = null;
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null) {
                    itemStack = stack;
                    break;
                }
            }
            return BottomlessVoidHelper.extractStack(itemStack);
        }

        @Override
        public int getRecipeSize() {
            return 1;
        }

        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }

    }

    public static class SetType implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag1 = false;
            boolean flag2 = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack != null) {
                    if (itemStack.getItem() == ModItems.BottomlessVoid){
                        if (itemStack.getItemDamage() != 0 || flag1)
                            return false;
                        flag1 = true;
                    }else{
                        if (flag2)
                            return false;
                        flag2 = true;
                    }
                }
            }

            return flag1 && flag2;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            ItemStack itemStack = null, itemStore = null;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null)
                    if(stack.getItem() == ModItems.BottomlessVoid)
                        itemStack = stack.copy();
                    else
                        itemStore = stack.copy();
            }

            BottomlessVoidHelper.setItemStored(itemStack, itemStore);
            BottomlessVoidHelper.setCount(itemStack,1);
            return itemStack;
        }

        @Override
        public int getRecipeSize() {
            return 2;
        }

        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }

    }

    public static class Clear implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack != null) {
                    if (!flag && itemStack.getItem() == ModItems.BottomlessVoid
                            && itemStack.getItemDamage() != 0 && !BottomlessVoidHelper.hasItems(itemStack))
                        flag = true;
                    else return false;
                }
            }
            return flag;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            ItemStack itemStack = null;
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null)
                    itemStack = stack.copy();
            }
            BottomlessVoidHelper.removeTags(itemStack);
            return itemStack;
        }

        @Override
        public int getRecipeSize() {
            return 1;
        }

        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }

    }

    public static class Add implements IRecipe {

        /**
         * Used to compare if a recipe matches current crafting inventory
         *
         * @param inventoryCrafting
         * @param world
         */
        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = true;
            ItemStack itemVoid = null;
            ItemStack[] itemStacks = new ItemStack[8];
            int j = 0;
            for (int i = 0; i<inventoryCrafting.getSizeInventory() ; i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null) {
                    if (stack.getItem() instanceof ItemBottomlessVoid) {
                        itemVoid = stack;
                    } else {
                        itemStacks[j++] = stack;
                    }
                }
            }
            for (int i = 0; i < itemStacks.length ; i++) {
                if (itemStacks[i] == null)
                    break;
                flag = flag && BottomlessVoidHelper.storesItem(itemVoid, itemStacks[i]);
            }
            return flag;
        }

        /**
         * Returns an Item that is the result of this recipe
         *
         * @param inventoryCrafting
         */
        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            ItemStack itemStack = null;
            for (int i = 0; i < inventoryCrafting.getSizeInventory() ; i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null && stack.getItem() instanceof ItemBottomlessVoid) {
                    itemStack = stack;
                }
            }
            return itemStack;
        }

        /**
         * Returns the size of the recipe area
         */
        @Override
        public int getRecipeSize() {
            return 9;
        }

        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }
    }
}