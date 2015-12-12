package sneakingshadow.bvks.tileentity;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public class TileEntityBVKSISidedInventory extends TileEntityBVKSIInventory implements ISidedInventory {

    public static int[] slots(int start, int end) {
        int[] integer = new int[end-start+1];
        for (int i=0;i<(end-start+1);i++) {
            integer[i] = start+i;
        }
        return integer;
    }

    public static boolean exists(int slot, int[] slots) {
        for (int i : slots)
            if (i==slot)
                return true;
        return false;
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        return new int[0];
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
