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
        this.addSlotToContainer(new Slot(tile, 0, 0, 0));
        this.addSlotToContainer(new Slot(tile, 1, 0, 0));
        this.addSlotToContainer(new Slot(tile, 2, 0, 0));
        this.addSlotToContainer(new Slot(tile, 3, 0, 0));

        //Import
        this.addSlotToContainer(new Slot(tile, 4, 16, 0));
        this.addSlotToContainer(new Slot(tile, 5, 0, 0));
        this.addSlotToContainer(new Slot(tile, 6, 0, 0));
        this.addSlotToContainer(new Slot(tile, 7, 0, 0));
        this.addSlotToContainer(new Slot(tile, 8, 0, 0));
        this.addSlotToContainer(new Slot(tile, 9, 0, 0));
        this.addSlotToContainer(new Slot(tile, 10, 0, 0));
        this.addSlotToContainer(new Slot(tile, 11, 0, 0));

        //Waste
        this.addSlotToContainer(new SlotExport(tile, 12, 0, 0));
        this.addSlotToContainer(new SlotExport(tile, 13, 0, 0));
        this.addSlotToContainer(new SlotExport(tile, 14, 0, 0));
        this.addSlotToContainer(new SlotExport(tile, 15, 0, 0));

        //Export
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 16, 0, 0));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 17, 0, 0));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 18, 0, 0));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 19, 0, 0));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 20, 0, 0));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 21, 0, 0));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 22, 0, 0));
        this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 23, 0, 0));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
        }
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
