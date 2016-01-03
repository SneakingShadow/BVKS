package sneakingshadow.bvks.client.gui;

import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiBottomlessVoid extends GuiContainerBVKS{

    private final ResourceLocation textureLocation = new ResourceLocation(this.location + "bottomless_void.png");

    public GuiBottomlessVoid(Container container) {
        super(container);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textureLocation);
        int k = (this.width - xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }

}
