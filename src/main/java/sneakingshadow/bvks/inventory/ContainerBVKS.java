package sneakingshadow.bvks.inventory;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

/**
 * Created by SneakingShadow on 21.12.2015.
 */
public abstract class ContainerBVKS extends Container {

    public ContainerBVKS addPlayerInventory(InventoryPlayer inventoryPlayer, int xPos, int yPos){
        int i,j;
        for (i = 0; i < 3; ++i)
        {
            for (j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, xPos + j * 18, yPos + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, i, xPos + i * 18, yPos + 58));
        }

        return this;
    }


    /*------------------DEBUG--------------------*/

    public void updateSlots() {

    }
}
