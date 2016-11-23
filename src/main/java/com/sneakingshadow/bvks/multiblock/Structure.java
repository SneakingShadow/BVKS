package com.sneakingshadow.bvks.multiblock;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class Structure {

    /**
     * Represents the structure in world.
     * */
    public Structure() {

    }

    /**
     * Creates structure from nbt
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
