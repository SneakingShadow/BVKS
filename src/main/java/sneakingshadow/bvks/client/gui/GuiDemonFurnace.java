package sneakingshadow.bvks.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import sneakingshadow.bvks.inventory.ContainerDemonFurnace;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

public class GuiDemonFurnace extends GuiContainerBVKS {

    public GuiDemonFurnace(InventoryPlayer inventoryPlayer, TileEntityDemonFurnace tileEntity) {
        super(new ContainerDemonFurnace(inventoryPlayer, tileEntity));
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        this.drawDefaultBackground();
    }

}
