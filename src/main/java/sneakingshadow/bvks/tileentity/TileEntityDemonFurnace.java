package sneakingshadow.bvks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import sneakingshadow.bvks.util.NBTHelper;

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

    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        itemStacks = NBTHelper.nbtToItems( (NBTTagList)nbtTagCompound.getTag("Items") );
    }

    public void writeToNBT(NBTTagCompound nbtTagCompound){
        super.writeToNBT(nbtTagCompound);
        nbtTagCompound.setTag( "Items", NBTHelper.itemsToNBT(itemStacks) );
    }

    public void updateEntity() {
        if (this.worldObj != null && !this.worldObj.isRemote) {
            for (int i : slotsImport) {
                if (itemStacks[i] != null) {
                    ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(itemStacks[i]);
                    int num = canSmelt(itemStack);
                    if (num != 0) {
                        sortExport(itemStack, num);
                        markDirty();
                    }
                }
            }

            //TODO Make the furnace auto-eject items
        }
    }

    private void sortExport(ItemStack itemStack, int num) {
        if(num == 2)
            for (int i : slotsExport) {
                if (itemStacks[i].isItemEqual(itemStack)){
                    int num2 = itemStack.getMaxStackSize()-itemStacks[i].stackSize;
                    if (itemStack.stackSize <= num2) {
                        itemStacks[i].stackSize += itemStack.stackSize;
                        return;
                    }else{
                        itemStacks[i].stackSize += num2;
                        itemStack.stackSize -= num2;
                    }
                }
            }
        else
            for (int i : slotsExport) {
                if (itemStacks[i] == null) {
                    itemStacks[i] = itemStack;
                    return;
                }
            }
    }

    private int canSmelt(ItemStack itemStack){
        if (itemStack == null)
            return 0;
        int size = itemStack.stackSize;
        boolean flag = false;
        for (int i : slotsExport) {
            if (itemStacks[i] == null)
                flag = true;
            else if (itemStacks[i].isItemEqual(itemStack))
                size -= itemStack.getMaxStackSize() - itemStacks[i].stackSize;
        }
        return size <= 0 ? 2: flag ? 1:0;
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

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
        return itemStacks[slot];
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
        if (itemStacks[slot] == null)
            return null;
        return itemStacks[slot].splitStack(amount);
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
     * @param slot
     * @param itemStack
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        if (!this.isItemValidForSlot(slot, itemStack))
            return;
        itemStacks[slot] = itemStack;
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
        return 64;
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
        return exists(slot, slotsImport) && canSmelt(itemStack) != 0 || (exists(slot, slotsFuel) && TileEntityFurnace.isItemFuel(itemStack));
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

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
        if (side == top)
            return exists(slot, slotsTop);
        return side != bottom && !exists(slot, slotsBottom) && !exists(slot, slotsTop);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        return side == bottom && exists(slot, slotsBottom);
    }

}
