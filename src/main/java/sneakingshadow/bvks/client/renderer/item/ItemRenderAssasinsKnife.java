package sneakingshadow.bvks.client.renderer.item;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

/**
 * Created by SneakingShadow on 06.01.2016.
 */
public class ItemRenderAssasinsKnife implements IItemRenderer {

    private static RenderItem renderItem = new RenderItem();

    /**
     * Checks if this renderer should handle a specific item's render type
     *
     * @param item The item we are trying to render
     * @param type A render type to compare if this renderer handles
     * @return true if this renderer should handle the given render type,
     * otherwise false
     */
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return ItemRenderType.EQUIPPED == type;
    }

    /**
     * Checks if certain helper functionality should be executed for this renderer.
     * See ItemRendererHelper for more info
     *
     * @param type   The render type
     * @param item   The ItemStack being rendered
     * @param helper The type of helper functionality to be ran
     * @return True to run the helper functionality, false to not.
     */
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    /**
     * Called to do the actual rendering, see ItemRenderType for details on when specific
     * types are run, and what extra data is passed into the data parameter.
     *
     * @param type The render type
     * @param itemStack The ItemStack being rendered
     * @param data Extra Type specific data
     */
    @Override
    public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
        if (data[2] instanceof Entity && ((Entity)data[2]).isInvisible())
            return;
        IIcon icon = itemStack.getIconIndex();
        // Use vanilla code to render the icon in a 16x16 square of inventory slot
        renderItem.renderIcon(0, 0, icon,
                16, 16);
    }

}
