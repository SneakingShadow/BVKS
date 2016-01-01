package sneakingshadow.bvks.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import sneakingshadow.bvks.inventory.Slot.SlotExport;
import sneakingshadow.bvks.inventory.Slot.SlotImport;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

/**
 * Created by SneakingShadow on 26.12.2015.
 */
public class ContainerDemonFurnace extends ContainerBVKS {

    private TileEntityDemonFurnace tileEntity;

    public ContainerDemonFurnace(InventoryPlayer inventoryPlayer, TileEntityDemonFurnace tile) {
        this.tileEntity = tile;

        int i, j;
        int offset = 170, betweenSlots = 17, startX = 8, startTopY = 16, startBottomY = 56;
        for (i = 0; i < 4; i++) //Fuel
            this.addSlotToContainer(new SlotImport(tile, i, startX + i*betweenSlots, startBottomY));
        for (j = 0; j < 2; j++) //Import
            for (i = 0; i < 4; i++)
                this.addSlotToContainer(new SlotImport(tile, 4 + i + j*4, startX + i*betweenSlots, startTopY + j*betweenSlots));
        for (i = 0; i < 4; i++) //Waste
            this.addSlotToContainer(new SlotExport(tile, i + 12, startX + i*betweenSlots + offset, startBottomY));
        for (j = 0; j < 2; j++) //Export
            for (i = 0; i < 4; i++)
                this.addSlotToContainer(new SlotFurnace(inventoryPlayer.player, tile, 4 + i + j*4 + 12, startX + i*betweenSlots + offset, startTopY + j*betweenSlots));


        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 48 + j * 18, 82 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 48 + i * 18, 140));
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

    public void addCraftingToCrafters(ICrafting iCrafting)
    {
        super.addCraftingToCrafters(iCrafting);
        iCrafting.sendProgressBarUpdate(this, 0, 0);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        for (Object iCrafting: this.crafters)
        ((ICrafting)iCrafting).sendProgressBarUpdate(this, 0,0);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int p_75137_1_, int p_75137_2_){

    }

}
