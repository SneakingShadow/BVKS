package sneakingshadow.bvks.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.SlotFurnace;
import sneakingshadow.bvks.inventory.Slot.SlotExport;
import sneakingshadow.bvks.inventory.Slot.SlotImport;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 26.12.2015.
 */
public class ContainerDemonFurnace extends ContainerBVKS {

    private TileEntityDemonFurnace tileEntity;
    private InventoryPlayer inventoryPlayer;

    public ContainerDemonFurnace(InventoryPlayer inventoryPlayer, TileEntityDemonFurnace tile) {
        this.tileEntity = tile;
        this.inventoryPlayer = inventoryPlayer;

        UpdateSlots();
    }

    public void UpdateSlots(){
        this.inventorySlots = new ArrayList();
        int i,j;
        int offset = 106, betweenSlots = 18, startX = 34, startTopY = 27, startBottomY = 67;
        for (i = 0; i < 4; i++) //Fuel
            this.addSlotToContainer(new SlotImport(this.tileEntity, i, startX + i*betweenSlots, startBottomY));
        for (j = 0; j < 2; j++) //Import
            for (i = 0; i < 4; i++)
                this.addSlotToContainer(new SlotImport(this.tileEntity, 4 + i + j*4, startX + i*betweenSlots, startTopY + j*betweenSlots));
        for (i = 0; i < 4; i++) //Waste
            this.addSlotToContainer(new SlotExport(this.tileEntity, i + 12, startX + i*betweenSlots + offset, startBottomY));
        for (j = 0; j < 2; j++) //Export
            for (i = 0; i < 4; i++)
                this.addSlotToContainer(new SlotFurnace(this.inventoryPlayer.player, this.tileEntity, 4 + i + j*4 + 12, startX + i*betweenSlots + offset, startTopY + j*betweenSlots));

        this.addPlayerInventory(inventoryPlayer, 42, 117);
    }

    /*

    int[] slotsTop = slots(4,11);
    int[] slotsSide = slots(0,3);
    int[] slotsBottom = slots(12,23);

    int[] slotsFuel = slots(0,3);
    int[] slotsImport = slots(4,11);
    int[] slotsWaste = slots(12,15);
    int[] slotsExport = slots(16,23);

    */

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return this.tileEntity.isUseableByPlayer(entityPlayer);
    }

}
