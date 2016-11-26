package com.sneakingshadow.bvks.inventory;

import com.sneakingshadow.bvks.inventory.Slot.SlotImport;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

public class ContainerBottomlessVoid extends ContainerBVKS {

    private InventoryBottomlessVoid inventory;

    public ContainerBottomlessVoid (EntityPlayer entityPlayer, int slot) {
        this.inventory = new InventoryBottomlessVoid( entityPlayer.inventory.mainInventory[slot] );

        this.entityPlayer = entityPlayer;
        this.updateSlots();
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.inventory.isUseableByPlayer(entityPlayer);
    }

    private EntityPlayer entityPlayer;
    public void updateSlots(){
        this.inventorySlots = new ArrayList();
        this.addSlotToContainer(new SlotImport(inventory, 0, 80,8));
        this.addPlayerInventory(entityPlayer.inventory, 8, 54);
    }

}
