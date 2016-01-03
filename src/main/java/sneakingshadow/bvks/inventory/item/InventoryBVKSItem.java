package sneakingshadow.bvks.inventory.item;

import net.minecraft.item.ItemStack;

public abstract class InventoryBVKSItem extends InventoryBVKS {

    public ItemStack itemInventory;

    public InventoryBVKSItem(ItemStack itemStack) {
        this.itemInventory = itemStack;
    }

    /**
     *  Save information to the item.
     *  Gets called by markDirty()
     */
    abstract void writeToNBT();

    @Override
    public void markDirty() {
        writeToNBT();
    }
}
