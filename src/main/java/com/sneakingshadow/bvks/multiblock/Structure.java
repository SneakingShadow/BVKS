package com.sneakingshadow.bvks.multiblock;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class Structure {

    private MultiBlock multiBlock;
    private World world;
    private Vec3 cornerPosition;
    private int rotationX;
    private int rotationY;
    private int rotationZ;

    /**
     * Represents the structure in world.
     *
     * @param world
     * @param cornerPosition coordinate of the start corner of the structure.
     * @param rotationX rotation of the structure around the x-axis.
     * @param rotationY rotation of the structure around the y-axis.
     * @param rotationZ rotation of the structure around the z-axis.
     *
     * */
    public Structure(MultiBlock multiBlock, World world, Vec3 cornerPosition, int rotationX, int rotationY, int rotationZ) {
        this.multiBlock = multiBlock;
        this.world = world;
        this.cornerPosition = cornerPosition;
        this.rotationX = rotationX;
        this.rotationY = rotationY;
        this.rotationZ = rotationZ;
    }

    public boolean stillValid() {
        return multiBlock.validate(world, cornerPosition, rotationX, rotationY, rotationZ);
    }

    public MultiBlock getMultiBlock() {
        return multiBlock;
    }

    /**
     * Reads structure from nbt
     * */
    public Structure(NBTTagCompound nbtTagCompound) {
        this.readFromNBT(nbtTagCompound);
    }

    /**
     * Useful for saving multiblock structure, not needing to do 'expensive' checks unless needed to.
     * */
    public NBTTagCompound writeToNBT(NBTTagCompound nbtTagCompound) {
        //Write to tag compound
        return nbtTagCompound;
    }

    /**
     * Useful for updating structure
     * */
    public Structure readFromNBT(NBTTagCompound nbtTagCompound) {
        //Write to internal variables
        return this;
    }

}
