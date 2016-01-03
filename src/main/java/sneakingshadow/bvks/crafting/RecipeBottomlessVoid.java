package sneakingshadow.bvks.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import sneakingshadow.bvks.init.ModItems;

public class RecipeBottomlessVoid {

    public static class Extract implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack != null) {
                    if (!flag && itemStack.getItem() == ModItems.BottomlessVoid && itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getLong("Count") != 0)
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
                ItemStack itemStack1 = inventoryCrafting.getStackInSlot(i);
                if (itemStack1 != null)
                    itemStack = itemStack1;
            }
            ItemStack resultStack = ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag("Item"));
            resultStack.stackSize = resultStack.getMaxStackSize() < itemStack.getTagCompound().getLong("Count") ? resultStack.getMaxStackSize() : (int)itemStack.getTagCompound().getLong("Count");
            return resultStack;
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
            ItemStack itemStack1 = null, itemStack2 = null; //Bottomless void, item

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null)
                    if(stack.getItem() == ModItems.BottomlessVoid)
                        itemStack1 = stack;
                    else
                        itemStack2 = stack;
            }

            ItemStack itemStack = itemStack1.copy();
            itemStack.setItemDamage(1);
            if(itemStack.getTagCompound() == null)
                itemStack.setTagCompound(new NBTTagCompound());
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            itemStack2.writeToNBT(nbtTagCompound);
            itemStack.getTagCompound().setTag("Item", nbtTagCompound);
            itemStack.getTagCompound().setLong("Count", 1);
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
                    if (!flag && itemStack.getItem() == ModItems.BottomlessVoid && itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getLong("Count") == 0)
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
            itemStack.getTagCompound().removeTag("Count");
            if (itemStack.getTagCompound().hasNoTags())
                itemStack.setTagCompound(null);

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