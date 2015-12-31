package sneakingshadow.bvks.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityFurnace;
import sneakingshadow.bvks.reference.Dir;
import sneakingshadow.bvks.util.NBTHelper;

import java.util.ArrayList;

public class TileEntityDemonFurnace extends TileEntityBVKSISidedInventory {

    public static final int[] slotsTop = slots(4,11);
    public static final int[] slotsSide = slots(0,3);
    public static final int[] slotsBottom = slots(12,23);
    public static final int[] slotsFuel = slots(0,3);
    public static final int[] slotsWaste = slots(12,15);
    public static final int[] slotsImport = slots(4,11);
    public static final int[] slotsExport = slots(16,23);

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
        for (int i : slotsImport) {
            if (itemStacks[i] != null) {
                ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(itemStacks[i]);
                if (itemStack != null) {
                    ArrayList<Integer> list = getValidSlots(itemStack);
                    if (!list.isEmpty()) {
                        int num = emptySpace(list, itemStack);
                        num = ((int) (num / itemStack.stackSize));
                        num = num > itemStacks[i].stackSize ? itemStacks[i].stackSize : num;
                        itemStacks[i].stackSize -= num;
                        if (itemStacks[i].stackSize == 0)
                            itemStacks[i] = null;
                        num = num*itemStack.stackSize;
                        for (int j : list) {
                            if (num == 0)
                                break;
                            if (itemStacks[j] == null) {
                                itemStacks[j] = itemStack.copy();
                                itemStacks[j].stackSize = 0;
                            }
                            int num2 = itemStack.getMaxStackSize() - itemStacks[j].stackSize;
                            itemStacks[j].stackSize += num2 > num ? num : num2;
                            num -= num2 > num ? num : num2;
                        }
                        this.markDirty();
                    }
                }
            }

            //TODO Make the furnace auto-eject items
        }
    }

    private ArrayList<Integer> getValidSlots(ItemStack itemStack) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : slotsExport)
            if ( itemStacks[i] != null && itemStacks[i].isItemEqual(itemStack) && itemStack.getMaxStackSize() != itemStacks[i].stackSize)
                list.add(i);
        for (int i : slotsExport) // Making sure the empty slots are last, because I want to fill partially filled slots first.
            if (itemStacks[i] == null)
                list.add(i);
        return list;
    }

    private int emptySpace(ArrayList<Integer> list, ItemStack itemStack) {
        int num = 0;
        for (int i : list)
            if (itemStacks[i] == null)
                num += itemStack.getMaxStackSize();
            else
                num += itemStack.getMaxStackSize() - itemStacks[i].stackSize;
        return num;
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
        if (itemStacks[slot] != null)
            if (itemStacks[slot].stackSize > amount)
                return itemStacks[slot].splitStack(amount);
            else{
                ItemStack itemStack = itemStacks[slot];
                itemStacks[slot] = null;
                return itemStack;
            }
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
    public boolean isUseableByPlayer(EntityPlayer entityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && entityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
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
        return slotExists(slot, slotsImport) && itemStack != null && FurnaceRecipes.smelting().getSmeltingResult(itemStack) != null || (slotExists(slot, slotsFuel) && TileEntityFurnace.isItemFuel(itemStack));
    }

    /*----------------------------------------------------------------------------------------------------------------------*/

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side == Dir.up ?
                slotsTop : side == Dir.down ?
                slotsBottom :
                slotsSide;
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        return slotExists( slot, this.getAccessibleSlotsFromSide(side) ) && this.isItemValidForSlot(slot, itemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        return side == Dir.down && slotExists(slot, slotsBottom);
    }
}
