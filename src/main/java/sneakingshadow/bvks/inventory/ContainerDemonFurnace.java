package sneakingshadow.bvks.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import sneakingshadow.bvks.inventory.Slot.SlotExport;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

/**
 * Created by SneakingShadow on 26.12.2015.
 */
public class ContainerDemonFurnace extends ContainerBVKS {

    private TileEntityDemonFurnace tileEntity;

    public ContainerDemonFurnace(InventoryPlayer inventoryPlayer, TileEntityDemonFurnace tile) {
        this.tileEntity = tile;

        //Fuel
        this.addSlotToContainer(new Slot(tile, 0, 10, 42));
        this.addSlotToContainer(new Slot(tile, 1, 26, 42));
        this.addSlotToContainer(new Slot(tile, 2, 42, 42));
        this.addSlotToContainer(new Slot(tile, 3, 58, 42));

        //Import
        this.addSlotToContainer(new Slot(tile, 4, 10, 10));
        this.addSlotToContainer(new Slot(tile, 5, 26, 10));
        this.addSlotToContainer(new Slot(tile, 6, 42, 10));
        this.addSlotToContainer(new Slot(tile, 7, 58, 10));
        this.addSlotToContainer(new Slot(tile, 8, 10, 26));
        this.addSlotToContainer(new Slot(tile, 9, 26, 26));
        this.addSlotToContainer(new Slot(tile, 10, 42, 26));
        this.addSlotToContainer(new Slot(tile, 11, 58, 26));

        //Waste
        this.addSlotToContainer(new SlotExport(tile, 12, 90, 42));
        this.addSlotToContainer(new SlotExport(tile, 13, 106, 42));
        this.addSlotToContainer(new SlotExport(tile, 14, 122, 42));
        this.addSlotToContainer(new SlotExport(tile, 15, 138, 42));

        //Export
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 16, 90, 10));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 17, 106, 10));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 18, 122, 10));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 19, 138, 10));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 20, 90, 26));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 21, 106, 26));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 22, 122, 26));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 23, 138, 26));
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

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges(){

    }

}
