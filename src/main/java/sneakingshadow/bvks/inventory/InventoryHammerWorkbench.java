package sneakingshadow.bvks.inventory;

import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.init.ModItems;

/**
 * Created by SneakingShadow on 13.03.2016.
 */
public class InventoryHammerWorkbench extends InventoryBVKS {

    ItemStack[] itemStacks = new ItemStack[2];
    /*
    * 1: Hammer
    * 2: Any item
    * last: Return slot
    */

    public int metadata;

    public InventoryHammerWorkbench (int metadata) {
        this.metadata = metadata
    }

    /**
     * Returns the stack in slot i
     *
     * @param slot
     */
    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot == this.itemStacks.length-1)
            return null;
        return itemStacks[slot];
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     *
     * @param slot
     * @param itemStack
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return slot == 2 || slot == 1 && itemStack.getItem() == ModItems.Hammer;
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     *
     * @param slot
     * @param amount
     */
    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     *
     * @param slot
     * @param itemStack
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {

    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    @Override
    public void markDirty() {

    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return this.itemStacks.length+1;
    }
}
