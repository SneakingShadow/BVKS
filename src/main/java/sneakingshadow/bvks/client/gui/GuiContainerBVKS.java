package sneakingshadow.bvks.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import sneakingshadow.bvks.inventory.ContainerBVKS;
import sneakingshadow.bvks.reference.Ref;

public abstract class GuiContainerBVKS extends GuiContainer{

    /**
     * @param x set to 0 to not change value
     * @param y set to 0 to not change value
     */
    public GuiContainerBVKS(Container container, int x, int y) {
        super(container);
        if (x != 0)
            xSize = x;
        if (y != 0)
            ySize = y;
    }

    public GuiContainerBVKS(Container container, int x) {
        this(container, x,0);
    }
    public GuiContainerBVKS(Container container) {
        this(container, 0,0);
    }


    public String location = Ref.RESOURCE_PREFIX+"textures/gui/container/";
    private ResourceLocation textureLocation;

    public void setTextureLocation(String string) {
        this.textureLocation = new ResourceLocation(this.location + string + ".png");
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textureLocation);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }


    /*------------------DEBUG--------------------*/
    private boolean debug = false;

    public void setDebug() {
        this.debug = true;
    }

    @Override
    public void updateScreen() {
        ((ContainerBVKS)this.inventorySlots).updateSlots();
    }
}