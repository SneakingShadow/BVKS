package sneakingshadow.bvks.tileentity;

import net.minecraft.inventory.ISidedInventory;

public abstract class TileEntityBVKSISidedInventory extends TileEntityBVKSIInventory implements ISidedInventory {

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
}
