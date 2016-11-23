package com.sneakingshadow.bvks.multiblock.structureblock;

import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
public abstract class StructureBlock {

    public boolean blockIsValid(World world, int x, int y, int z){
        return false;
    }

    public boolean blockIsValid(World world, Vec3 worldPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {
        return blockIsValid(world, (int)worldPosition.xCoord, (int)worldPosition.yCoord, (int)worldPosition.zCoord);
    }

    /**
     * Gets called at end of every search for valid structure.
     * */
    public void reset() {}

}
