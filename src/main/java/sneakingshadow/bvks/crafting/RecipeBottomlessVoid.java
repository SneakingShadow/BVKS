package sneakingshadow.bvks.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.ItemBottomlessVoid;
import sneakingshadow.bvks.reference.Tags;

public class RecipeBottomlessVoid {

    public static class Extract implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            boolean flag = false;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null) {
                    if (stack.getItem() instanceof ItemBottomlessVoid && stack.getItemDamage() != 0 && ItemBottomlessVoid.hasItems(stack) && !flag)
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

            if (itemStack != null) {
                int stored = (int) ItemBottomlessVoid.getStored(itemStack);
                if (itemStack.getItemDamage() != 0 && stored > 0) {
                    itemStack.setItemDamage(3);
                    ItemStack stack = new ItemStack(ItemBottomlessVoid.getItem(itemStack), Math.min(Math.min(64, stored), ItemBottomlessVoid.getMaxStackSize(itemStack)), ItemBottomlessVoid.getMeta(itemStack));
                    if(!ItemBottomlessVoid.getStackTagNull(itemStack))
                        stack.setTagCompound(ItemBottomlessVoid.getStackTag(itemStack));
                    return stack;
                }
            }
            return null;
        }

        @Override
        public int getRecipeSize() {
            return 10;
        }

        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }

    }

    public static class SetType implements IRecipe {

        @Override
        public boolean matches(InventoryCrafting inventoryCrafting, World world) {
            int flag = 0;
            int flag2 = 0;
            boolean flag3 = true;

            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null) {
                    if (stack.getItem() instanceof ItemBottomlessVoid && stack.getItemDamage() == 0)
                        flag++;
                    if (!(stack.getItem() instanceof ItemBottomlessVoid))
                        flag2++;
                }
            }

            return flag!=0 && flag2!=0 && flag<2 && flag2<2 && flag3;
        }

        @Override
        public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
            ItemStack itemStack = null;
            ItemStack itemStack2 = null;
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null && stack.getItem() instanceof ItemBottomlessVoid)
                    itemStack = stack;
            }
            for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++) {
                ItemStack stack = inventoryCrafting.getStackInSlot(i);
                if (stack != null && !(stack.getItem() instanceof ItemBottomlessVoid))
                    itemStack2 = stack;
            }

            if (itemStack != null && itemStack2 != null && itemStack.getItemDamage()==0) {
                ItemStack copy = itemStack.copy();

                copy.setItemDamage(1);

                ItemBottomlessVoid.setStored(copy, 1);
                ItemBottomlessVoid.setID(copy, Item.getIdFromItem(itemStack2.getItem()));
                ItemBottomlessVoid.setName(copy, itemStack2.getDisplayName());
                ItemBottomlessVoid.setMeta(copy, itemStack2.getItemDamage());
                if(itemStack2.stackTagCompound != null){
                    ItemBottomlessVoid.setStackTag(copy, itemStack2.stackTagCompound);
                    ItemBottomlessVoid.setStackTagNull(copy, true);
                }else
                    ItemBottomlessVoid.setStackTagNull(copy, true);
                ItemBottomlessVoid.setMaxStackSize(copy, itemStack2.getMaxStackSize());

                return copy;
            }
            return null;
        }

        @Override
        public int getRecipeSize() {
            return 10;
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
                    if (stack.getItem() instanceof ItemBottomlessVoid && stack.getItemDamage() != 0 && !ItemBottomlessVoid.hasItems(stack) && !flag)
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
                if (stack != null && stack.getItem() instanceof ItemBottomlessVoid)
                    itemStack = stack;
            }
            if (itemStack != null) {
                ItemStack copy = itemStack.copy();
                copy.setItemDamage(0);
                Tags.clearBVKSTags(copy);
                return copy;
            }
            return null;
        }

        @Override
        public int getRecipeSize() {
            return 10;
        }

        @Override
        public ItemStack getRecipeOutput() {
            return null;
        }

    }
}