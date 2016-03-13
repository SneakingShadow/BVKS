package sneakingshadow.bvks.client.gui;

import net.minecraft.inventory.Container;
import sneakingshadow.bvks.reference.Name;

/**
 * Created by SneakingShadow on 13.03.2016.
 */
public class GuiHammerWorkbench extends GuiContainerBVKS {

    private int metadata;

    public GuiHammerWorkbench(Container container, int metadata) {
        super(Name.Block.HAMMER_WORKBENCH + "_" + metadata, container);
        this.metadata = metadata;
    }

    

}
