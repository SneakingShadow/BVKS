package sneakingshadow.bvks.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import sneakingshadow.bvks.init.ModItems;

/**
 * Created by SneakingShadow on 20.03.2016.
 */
public class TileEntityBottomlessVoidAccessor extends TileEntityBVKSISidedInventory {

    private ItemStack itemStack = null;

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);
        itemStack = nbtTagCompound.hasKey("BottomlessVoid") ? ItemStack.loadItemStackFromNBT(nbtTagCompound.getCompoundTag("BottomlessVoid")) : null;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);
        if (itemStack != null) {
            nbtTagCompound.setTag("BottomlessVoid", itemStack.writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     *
     * @param side
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return side < 2 ? new int[] {0} : new int[] {1};
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     *
     * @param slot
     * @param itemStack
     * @param side
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
        return slot == 0 && side < 2 && itemStack.getItem() == ModItems.BottomlessVoid;
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     *
     * @param slot
     * @param itemStack
     * @param side
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
        return slot == 0 && side < 2 || slot != 0 && side > 1;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return 2;
    }

    /**
     * Returns the stack in slot i
     *
     * @param slot
     */
    @Override
    public ItemStack getStackInSlot(int slot) {
        return slot == 0 ? itemStack : null;
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
        return slot == 0
                ? itemStack != null ? itemStack.copy() : null
                : null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     *
     * @param slot
     * @param itemStack
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        if (slot == 0) {
            this.itemStack = itemStack;
        }
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     *
     * @param slot
     * @param itemStack
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return slot == 0 && itemStack.getItem() == ModItems.BottomlessVoid;
    }

}
