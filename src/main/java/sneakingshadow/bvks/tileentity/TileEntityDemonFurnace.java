package sneakingshadow.bvks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class TileEntityDemonFurnace extends TileEntityBVKSISidedInventory {

    int[] slotsTop = slots(4,11);
    int[] slotsSide = slots(0,3);
    int[] slotsBottom = slots(12,23);
    int[] slotsFuel = slots(0,3);
    int[] slotsWaste = slots(12,15);
    int[] slotsImport = slots(4,11);
    int[] slotsExport = slots(16,23);

    ItemStack[] itemStacks = new ItemStack[24];
    //TODO Make the block explode on 666th use

    public void updateEntity() {

        for (int i : slotsImport) {
            ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(itemStacks[i]);
            if (itemStack != null)
                for (int j : slotsExport) {
                    if (itemStacks[j] == null)
                        itemStacks[j] = itemStack;
                }
        }



    }



    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return 24;
    }

    /**
     * Returns the stack in slot i
     *
     * @param slot
     */
    @Override
    public ItemStack getStackInSlot(int slot) {
        return null;
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
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     *
     * @param slot
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
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
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName() {
        return null;
    }

    /**
     * Returns if the inventory is named
     */
    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     *
     * @param entityPlayer
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     *
     * @param slot
     * @param itemStack
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return false;
    }



    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == top ?
                slotsTop : side == bottom ?
                slotsBottom :
                slotsSide;
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        return false;
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        return false;
    }

}
