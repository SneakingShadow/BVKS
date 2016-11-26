package com.sneakingshadow.bvks.multiblock.structureblock.special;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.world.World;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.LIQUID;

public class SBlockLiquid extends StructureBlock {

    public boolean blockIsValid(World world, int x, int y, int z){
        return world.getBlock(x,y,z).getMaterial().isLiquid();
    }

    /**
     * A small un-official check to determine if it should continue checking in world.
     */
    @Override
    public boolean startCheckingForStructure(World world, int x, int y, int z) {
        return blockIsValid(world, x, y, z);
    }

    public String toString() {
        return "'" + LIQUID + "'";
    }

}
