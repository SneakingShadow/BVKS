package sneakingshadow.bvks.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

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



}
