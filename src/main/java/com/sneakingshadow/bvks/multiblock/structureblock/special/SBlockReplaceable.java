package com.sneakingshadow.bvks.multiblock.structureblock.special;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.world.World;

public class SBlockReplaceable extends StructureBlock {

    public boolean blockIsValid(World world, int x, int y, int z){
        return world.getBlock(x,y,z).isReplaceable(world,x,y,z);
    }

}
