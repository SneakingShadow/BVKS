package sneakingshadow.bvks.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryBottomlessVoid extends InventoryBVKS {

    public ItemStack itemStack;
    public long count = 0;

    public InventoryBottomlessVoid(ItemStack itemStack) {
        this.itemStack = itemStack;
        if (this.itemStack.getItemDamage() != 0) {
            this.storedStack = ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag("Item"));
            long num = this.itemStack.getTagCompound().getLong("Count");
            this.stackSize = num < this.storedStack.getMaxStackSize() ? (int)num : this.storedStack.getMaxStackSize();
            this.count = itemStack.getTagCompound().getLong("Count");
        } else {
            this.storedStack = null;
            this.stackSize = 0;
            this.count = 0;
        }
    }

    private int stackSize = 0;
    private ItemStack storedStack = null;

    @Override
    public void markDirty() {
        if (this.itemStack.getItemDamage() != 0) {
            long num = this.itemStack.getTagCompound().getLong("Count");
            this.stackSize = num < this.storedStack.getMaxStackSize() ? (int)num : this.storedStack.getMaxStackSize();
            this.storedStack = ItemStack.loadItemStackFromNBT(itemStack.getTagCompound().getCompoundTag("Item"));
        }

        this.itemStack.getTagCompound().setLong("Count", this.stackSize);
        if (this.stackSize != 0) {
            this.itemStack.getTagCompound().setTag("Item", this.storedStack.writeToNBT(new NBTTagCompound()));
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
        return this.stackSize > 0 ? this.storedStack : null;
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
        amount = amount > stackSize ? (int) stackSize : amount;
        ItemStack itemStack = this.storedStack.copy();
        itemStack.stackSize = amount;
        this.stackSize -= amount;
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

        if ( this.itemStack.getItemDamage() == 0 )
        {
            this.itemStack.setItemDamage(1);
            this.storedStack = itemStack;
        }
        if ( this.storedStack.isItemEqual(itemStack) && (this.storedStack.getTagCompound() == null && itemStack.getTagCompound() == null || this.storedStack.getTagCompound() != null && itemStack.getTagCompound() != null && this.storedStack.getTagCompound().equals(itemStack.getTagCompound())) )
        this.stackSize = this.storedStack != null ? this.storedStack.stackSize : 0;


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
        return this.stackSize == 0 || storedStack.equals(itemStack);
    }

    /**
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName() {
        return Long.toString(count);
    }

    /**
     * Returns if the inventory is named
     */
    @Override
    public boolean hasCustomInventoryName() {
        return true;
    }

}