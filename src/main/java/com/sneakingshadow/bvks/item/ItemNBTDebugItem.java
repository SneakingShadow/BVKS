package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.item.ItemBVKS;
import com.sneakingshadow.bvks.reference.Name;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemNBTDebugItem extends ItemBVKS {

    public ItemNBTDebugItem() {
        super(Name.Item.NBT_DEBUG_ITEM);
        this.setMaxStackSize(1);
        this.setFull3D();
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        if(!world.restoringBlockSnapshots && !world.isRemote)
            for (int i = 0; i < entityPlayer.inventory.getSizeInventory(); i++) {
                ItemStack itemStack1 = entityPlayer.inventory.getStackInSlot(i);
                if(itemStack1 != null) {
                    System.out.println("Slot: " + i);
                    System.out.println("Metadata: " + itemStack1.getItemDamage());
                    System.out.println("NBT tag: " + itemStack1.getTagCompound());
                }
            }
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        if(!world.restoringBlockSnapshots && !world.isRemote){
            System.out.println("Block: " + world.getBlock(x,y,z));
            System.out.println("Metadata: " + world.getBlockMetadata(x, y, z));
            NBTTagCompound nbtTagCompound = new NBTTagCompound();
            if(world.getTileEntity(x,y,z) != null){
                world.getTileEntity(x,y,z).writeToNBT(nbtTagCompound);
                System.out.println("nbt tag: " + nbtTagCompound);
            }else
                System.out.println("Has no tile entity.");
        }
        return false;
    }
}
