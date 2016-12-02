package com.sneakingshadow.bvks.block;

import com.sneakingshadow.bvks.init.ModBlocks;
import com.sneakingshadow.bvks.multiblock.MultiBlock;
import com.sneakingshadow.bvks.multiblock.Structure;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.tileentity.TileEntityDebugBlock;
import com.sneakingshadow.bvks.util.ArrayListHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BlockDebugBlock extends BlockBVKSContainer {

    public BlockDebugBlock(){
        super(Name.Block.DEBUG_BLOCK);
        this.setTileEntity(TileEntityDebugBlock.class, Name.Block.DEBUG_BLOCK);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        if(world.isRemote) {
            MultiBlock multiBlock = new MultiBlock(
                    "ccc\\ c \\\\ ", ModBlocks.debugBlock,
                    'c', Blocks.cobblestone
            ).setRotationXAxis(true).setRotationZAxis(true);

            ArrayList<Structure> arrayList = multiBlock.findStructures(world, x, y, z);

            System.out.println();
            System.out.println(ArrayListHelper.arrayToString(arrayList));
            System.out.println(arrayList.size());
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return null;
    }

    /*@Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {

        int meta = world.getBlockMetadata(x, y, z);

        float[] bound = bounds[meta < 3 ? meta : 3];

        setBlockBounds( bound[0], bound[1], bound[2], bound[3], bound[4], bound[5] );

    }*/


    private static float[][] bounds = {
            { 0.4f,  0.0f, 0.4f,  0.6f,  0.2f,  0.6f}, // meta 0
            { 0.3f,  0.0f, 0.3f,  0.7f,  0.425f, 0.7f}, // meta 1
            { 0.15f, 0.0f, 0.15f, 0.85f, 0.65f,  0.85f }, // meta 2
            { 0.0f,  0.0f, 0.0f,  1.0f,  1.0f,  1.0f}, // meta 3 and higher
    };

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x,y,z);
        float[] bound = bounds[meta < bounds.length ? meta : bounds.length-1];

        return AxisAlignedBB.getBoundingBox((double)x + bound[0], (double)y + bound[1], (double)z + bound[2], (double)x + bound[3], (double)y + bound[4], (double)z + bound[5]);
    }

}
