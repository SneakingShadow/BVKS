package com.sneakingshadow.bvks.multiblock.structureblock.special;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.world.World;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class SBlockNull extends StructureBlock {

    public boolean blockIsValid(World world, int x, int y, int z){
        return true;
    }

}
