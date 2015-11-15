package sneakingshadow.bvks.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.util.LogHelper;

import java.util.List;

public class ItemNBTDebugItem extends ItemBVKS {

    public ItemNBTDebugItem() {
        super();
        this.setMaxStackSize(1);
        this.setUnlocalizedName(Names.Items.NBT_DEBUG_ITEM);
        this.setFull3D();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        if(!world.restoringBlockSnapshots && !world.isRemote)
            for (int i = 0; i < entityPlayer.inventory.getSizeInventory(); i++) {
                ItemStack itemStack1 = entityPlayer.inventory.getStackInSlot(i);
                if(itemStack1 != null) {
                    LogHelper.info("Slot: " + i);
                    LogHelper.info("Metadata: " + itemStack1.getItemDamage());
                    LogHelper.info("NBT tag: " + itemStack1.getTagCompound());
                }
            }
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.restoringBlockSnapshots && !world.isRemote){
            LogHelper.info("Block: " + world.getBlock(x,y,z));
            LogHelper.info("Metadata: " + world.getBlockMetadata(x, y, z));
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            if(world.getTileEntity(x,y,z) != null){
                world.getTileEntity(x,y,z).writeToNBT(nbtTagCompound);
                LogHelper.info("nbt tag: " + nbtTagCompound);
            }else
                LogHelper.info("Has no tile entity.");
        }
        return false;
    }
}
