package sneakingshadow.bvks.render;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import sneakingshadow.bvks.item.ItemBottomlessVoid;
import sneakingshadow.bvks.util.LogHelper;

public class RenderBottomlessVoid implements IItemRenderer{

    private static RenderItem renderItem = new RenderItem();

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type == ItemRenderType.INVENTORY; // || type == EQUIPPED_FIRST_PERSON
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        // Get icon index for the texture
        IIcon icon = item.getIconIndex();
        // Use vanilla code to render the icon in a 16x16 square of inventory slot
        renderItem.renderIcon(0, 0, ItemBottomlessVoid.itemTransparentIcons[ (item.getItemDamage()==2 ? 2:1) ], 16, 16);
        // Disable texturing, for now we only need colored shapes
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        // The following 3 methods enable transparency of a certain flavor (see second tutorial link above)
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        // Set drawing mode (see first tutorial link above).
        GL11.glBegin(GL11.GL_QUADS);
        // Set semi-transparent black color
        GL11.glColor4f(0F, 0F, 0F, 0.5F);
        // Draw a 8x8 square
        GL11.glVertex3d(0, 0, 0);
        GL11.glVertex3d(0, 8, 0);
        GL11.glVertex3d(8, 8, 0);
        GL11.glVertex3d(8, 0, 0);
        GL11.glEnd();
        // Turn off unneeded transparency flags
        GL11.glDepthMask(true);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
