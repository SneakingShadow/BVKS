package sneakingshadow.bvks.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class ContainerBottomlessVoid extends ContainerBVKS {

    ItemStack itemStack;

    public ContainerBottomlessVoid (InventoryPlayer inventoryPlayer, ItemStack itemStack) {
        this.itemStack = itemStack;



        this.addPlayerInventory(inventoryPlayer, 8, 54);
    }

    //80, 8

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return false;
    }

}
