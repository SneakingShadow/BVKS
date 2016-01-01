package sneakingshadow.bvks.inventory.Slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotImport extends SlotBVKS{

    public SlotImport(IInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition) {
        super(inventory, slotIndex, xDisplayPosition, yDisplayPosition);
    }

    public boolean isItemValid(ItemStack itemStack) {
        return inventory.isItemValidForSlot(slotNumber,itemStack);
    }
}
