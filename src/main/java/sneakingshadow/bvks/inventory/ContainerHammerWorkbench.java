package sneakingshadow.bvks.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 13.03.2016.
 */
public class ContainerHammerWorkbench extends ContainerBVKS {

    public InventoryPlayer inventoryPlayer;
    public InventoryHammerWorkbench inventoryCrafting;
    public int metadata;

    public ContainerHammerWorkbench(EntityPlayer entityPlayer, int metadata) {
        this.inventoryPlayer = entityPlayer.inventory;
        this.inventoryCrafting = new InventoryHammerWorkbench(metadata);
        this.metadata = metadata;
        updateSlots();
    }

    public void updateSlots(){
        this.inventorySlots = new ArrayList();
        this.addPlayerInventory(inventoryPlayer, 8, 71);

    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }

}
