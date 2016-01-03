package sneakingshadow.bvks.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IItemInventory {

    /**
     * Returns the number of slots in the inventory.
     */
    int getSizeInventory(ItemStack itemStack);

    /**
     * Returns the stack in slot i
     */
    ItemStack getStackInSlot(ItemStack itemStack, int p_70301_1_);

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    ItemStack decrStackSize(ItemStack itemStack, int p_70298_1_, int p_70298_2_);

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    ItemStack getStackInSlotOnClosing(ItemStack itemStack, int p_70304_1_);

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    void setInventorySlotContents(ItemStack itemStack, int p_70299_1_, ItemStack p_70299_2_);

    /**
     * Returns the name of the inventory
     */
    String getInventoryName(ItemStack itemStack);

    /**
     * Returns if the inventory is named
     */
    boolean hasCustomInventoryName(ItemStack itemStack);

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    int getInventoryStackLimit(ItemStack itemStack);

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    void markDirty(ItemStack itemStack);

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    boolean isUseableByPlayer(ItemStack itemStack, EntityPlayer p_70300_1_);

    void openInventory(ItemStack itemStack);

    void closeInventory(ItemStack itemStack);

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    boolean isItemValidForSlot(ItemStack itemStack, int p_94041_1_, ItemStack p_94041_2_);

}
