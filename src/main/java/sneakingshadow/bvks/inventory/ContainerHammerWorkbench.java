package sneakingshadow.bvks.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

/**
 * Created by SneakingShadow on 13.03.2016.
 */
public class ContainerHammerWorkbench extends ContainerBVKS {

    InventoryPlayer inventoryPlayer;

    public ContainerHammerWorkbench(EntityPlayer entityPlayer, int metadata) {
        inventoryPlayer = entityPlayer.inventory;
    }

    public void updateSlots(){
        this.addPlayerInventory(inventoryPlayer, 42, 117);
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

}
