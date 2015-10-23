package sneakingshadow.bvks.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.ItemBottomlessVoid;

public class RecipeBottomlessVoid {

    public static class Extract implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null) {
                    if (stack.getItem() instanceof ItemBottomlessVoid && stack.getItemDamage() != 0 && stack.getTagCompound().getCompoundTag("Item").getLong("Count") != 0 && !flag)
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
                    itemStack = stack;
            }

            return ItemBottomlessVoid.extractStack(itemStack);
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
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null) {
                    if (stack.getItem() instanceof ItemBottomlessVoid){
                        if (stack.getItemDamage() != 0 || flag1) return false;
                        flag1 = true;
                    }else {
                        if (flag2) return false;
                        flag2 = true;
                    }
                }
            }

            return flag1 && flag2;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            ItemStack itemStack1 = null; // Bottomless Void
            ItemStack itemStack2 = null;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null)
                    if(stack.getItem() instanceof ItemBottomlessVoid)
                        itemStack1 = stack;
                    else
                        itemStack2 = stack;
            }

            ItemStack itemStack = itemStack1.copy();
            itemStack.setItemDamage(1);
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            NBTTagCompound itemCompound = itemStack2.getTagCompound();
            nbtTagCompound.setShort("id", itemCompound.getShort("id"));
            nbtTagCompound.setTag("tag", itemCompound.getCompoundTag("tag"));
            nbtTagCompound.setShort("Damage", itemCompound.getShort("Damage"));
            nbtTagCompound.setLong("Count", 1);
            itemStack.getTagCompound().removeTag("Item");
            itemStack.getTagCompound().setTag("Item", nbtTagCompound);

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

    public static class Clear implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null) {
                    if (stack.getItem() instanceof ItemBottomlessVoid && stack.getItemDamage() != 0 && stack.getTagCompound().getCompoundTag("Item").getLong("Count") == 0 && !flag)
                        flag = true;
                    else return false;
                }
            }

            return flag;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            ItemStack itemStack1 = null;
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null)
                    itemStack1 = stack;
            }
            ItemStack itemStack = itemStack1.copy();
            itemStack.setItemDamage(0);
            itemStack.getTagCompound().removeTag("Item");

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
}