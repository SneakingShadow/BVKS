package com.sneakingshadow.bvks.multiblock.structureblock.special;

import com.sneakingshadow.bvks.multiblock.MultiBlockLists;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.world.World;

public class SBlockOpaqueMaterial extends StructureBlock {

    public boolean blockIsValid(World world, int x, int y, int z){
        return world.getBlock(x,y,z).getMaterial().isOpaque();
    }

    /**
     * A small un-official check to determine if it should continue checking in world.
     */
    @Override
    public boolean startCheckingForStructure(World world, int x, int y, int z) {
        return blockIsValid(world, x, y, z);
    }

    public String toString() {
        return "'" + MultiBlockLists.OPAQUE_MATERIAL + "'";
    }

}
