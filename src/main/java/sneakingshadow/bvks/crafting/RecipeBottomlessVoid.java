package sneakingshadow.bvks.crafting;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.ItemBottomlessVoid;

public class RecipeBottomlessVoid {

    public static boolean extract(ItemStack itemStack){
        return itemStack.getItem() instanceof ItemBottomlessVoid && itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getCompoundTag("Item").getLong("Count") != 0;
    }

    public static class Extract implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
                if (itemStack != null) {
                    if (!flag && extract(itemStack))
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
            ItemStack itemStack1 = null;// = new ItemStack(Items.apple); // Bottomless Void
            ItemStack itemStack2 = null;// = new ItemStack(Items.apple);

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
            if(itemStack.getTagCompound() == null)
                itemStack.setTagCompound(new NBTTagCompound());
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            nbtTagCompound.setShort("id", (short)Item.getIdFromItem(itemStack2.getItem()));
            if(itemStack2.getTagCompound() != null)
                nbtTagCompound.setTag("tag", itemStack2.getTagCompound());
            else
                nbtTagCompound.setTag("tag", new NBTTagCompound());
            nbtTagCompound.setShort("Damage", (short) itemStack2.getItemDamage());
            nbtTagCompound.setLong("Count", 1);
            itemStack.getTagCompound().setTag("Item", nbtTagCompound);

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
                    if (!flag && itemStack.getItem() instanceof ItemBottomlessVoid && itemStack.getItemDamage() != 0 && itemStack.getTagCompound().getCompoundTag("Item").getLong("Count") == 0)
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