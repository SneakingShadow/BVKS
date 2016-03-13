package sneakingshadow.bvks.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryBottomlessVoid extends InventoryBVKS {

    private long count;
    private ItemStack itemStored;
    public ItemStack itemInventory;

    public InventoryBottomlessVoid(ItemStack itemStack) {
        this.itemInventory = itemStack;
        if (itemStack.getItemDamage() != 0) {
            this.count = itemStack.getTagCompound().getLong("Count");
            this.itemStored = ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag("Item"));
        } else {
            this.count = 0;
            this.itemStored = null;
        }
        updateCount();
    }

    private void updateCount() {
        if (this.count == 0)
            this.itemStored = null;
        else
            this.itemStored.stackSize = this.count < this.itemStored.getMaxStackSize() ? (int)this.count : this.itemStored.getMaxStackSize();
    }

    @Override
    public void markDirty() {
        updateCount();
        if (this.count == 0) {
            this.itemInventory.getTagCompound().removeTag("Count");
            this.itemInventory.getTagCompound().removeTag("Item");
        } else {
            this.itemInventory.getTagCompound().setLong("Count", this.count);
            this.itemInventory.getTagCompound().setTag("Item", this.itemStored.writeToNBT(new NBTTagCompound()));
        }
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return 1;
    }

    /**
     * Returns the stack in slot i
     *
     * @param slot
     */
    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.itemStored;
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
        amount = amount > count ? (int)count : amount;
        ItemStack itemStack = this.itemStored.copy();
        itemStack.stackSize = amount;
        this.count -= amount;
        markDirty();
        return itemStack;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     *
     * @param slot
     * @param itemStack
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        this.itemStored = itemStack;
        this.count = this.itemStored != null ? this.itemStored.stackSize : 0;
        markDirty();
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     *
     * @param slot
     * @param itemStack
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return this.count == 0 || itemStored.equals(itemStack);
    }

}
