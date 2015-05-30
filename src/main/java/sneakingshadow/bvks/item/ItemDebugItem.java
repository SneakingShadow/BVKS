package sneakingshadow.bvks.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.util.LogHelper;

import java.util.List;

public class ItemDebugItem extends ItemBVKS {

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Use at own risk!");
    }

    public ItemDebugItem() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.DEBUG_ITEM);
        this.setFull3D();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(!world.isRemote && !world.restoringBlockSnapshots) {
            if (entityPlayer.isSneaking()) {
                LogHelper.info("sneaking");
            } else {
                LogHelper.info("standing");
            }
            LogHelper.info(super.getUnlocalizedName());
            LogHelper.info(super.getUnlocalizedName(itemStack));
        }

        return itemStack;
    }
}
