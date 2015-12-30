package sneakingshadow.bvks.client.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import sneakingshadow.bvks.inventory.ContainerDemonFurnace;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

public class GuiDemonFurnace extends GuiContainerBVKS {

    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");

    public GuiDemonFurnace(InventoryPlayer inventoryPlayer, TileEntityDemonFurnace tileEntity) {
        super(new ContainerDemonFurnace(inventoryPlayer, tileEntity));
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() {
        this.drawGuiContainerBackgroundLayer(1,1,1);
    }
}
