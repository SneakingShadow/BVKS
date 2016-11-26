package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.base.ItemBVKS;
import com.sneakingshadow.bvks.multiblock.MultiBlock;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDebugItem extends ItemBVKS {

    private static Block placeBlock = Blocks.cobblestone;

    public ItemDebugItem() {
        super(Name.Item.DEBUG_ITEM);
        this.setMaxStackSize(1);
        this.setFull3D();
        this.setMaxDamage(10);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Use at own risk!");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if (world.isRemote) {
            System.out.println("Debug:\n\n");
            MultiBlock multiBlock = new MultiBlock("ccc", 'c', Blocks.cobblestone);
            System.out.println(multiBlock);
        }

        if (world.isRemote) {
            LogHelper.info(MathHelper.floor_double((double)(entityPlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3);
        }
        return itemStack;
    }

    /**
     * Called to actually place the block, after the location is determined
     * and all permission checks have been made.
     *
     * @param stack The item stack that was used to place the block. This can be changed inside the method.
     * @param player The player who is placing the block. Can be null if the block is not being placed by a player.
     * @param side The side the player (or machine) right-clicked on.
     */
    private boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata, @Nullable NBTTagCompound nbtTagCompound)
    {

        if (!world.setBlock(x, y, z, placeBlock, metadata, 3))
        {
            return false;
        }

        if (world.getBlock(x, y, z) == placeBlock)
        {
            placeBlock.onBlockPlacedBy(world, x, y, z, player, stack);
            placeBlock.onPostBlockPlaced(world, x, y, z, metadata);
            LogHelper.info(world.getTileEntity(x,y,z));
            LogHelper.info(world.getTileEntity(x,y,z) != null);
            if(world.getTileEntity(x,y,z) != null && nbtTagCompound != null){
                NBTTagCompound nbt1 = new NBTTagCompound();
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                tileEntity.writeToNBT(nbt1);
                nbtTagCompound.setString("id", nbt1.getString("id"));
                nbtTagCompound.setInteger("x", nbt1.getInteger("x"));
                nbtTagCompound.setInteger("y", nbt1.getInteger("y"));
                nbtTagCompound.setInteger("z", nbt1.getInteger("z"));
                tileEntity.readFromNBT(nbtTagCompound);
            }
        }

        return true;
    }
}
