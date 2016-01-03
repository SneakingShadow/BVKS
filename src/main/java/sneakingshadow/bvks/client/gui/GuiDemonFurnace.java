package sneakingshadow.bvks.client.gui;

import sneakingshadow.bvks.inventory.ContainerDemonFurnace;
import sneakingshadow.bvks.reference.Name;

public class GuiDemonFurnace extends GuiContainerBVKS {

    public GuiDemonFurnace(ContainerDemonFurnace container) {
        super(container, 212+26, 166+36);
        this.setTextureLocation(Name.Block.DEMON_FURNACE);
    }

}
