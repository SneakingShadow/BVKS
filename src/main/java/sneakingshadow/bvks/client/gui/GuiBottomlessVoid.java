package sneakingshadow.bvks.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.reference.Name;

public class GuiBottomlessVoid extends GuiContainerBVKS{

    public ItemStack itemStack;

    public GuiBottomlessVoid(Container container, EntityPlayer entityPlayer, int slot) {
        super( Name.Item.BOTTOMLESS_VOID, container, 176, 136);
        this.itemStack = entityPlayer.inventory.mainInventory[slot];

        this.setDebug();
    }

    @Override
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    public void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        String s = itemStack.getTagCompound().hasKey("Count") ? String.valueOf(itemStack.getTagCompound().getLong("Count")) : "";
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }
}
