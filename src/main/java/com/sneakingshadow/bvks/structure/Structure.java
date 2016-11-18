package com.sneakingshadow.bvks.structure;

import com.sneakingshadow.bvks.init.ModMultiBlocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.world.World;

public class Structure {

    private boolean valid = true;
    public MultiBlock multiBlock;
    public int x,y,z,rotationX,rotationY,rotationZ,structureID,multiBlockID;

    /**
     *  A multi block structure in world.
     *
     */
    public Structure(MultiBlock multiBlock, int x, int y, int z, int rotationX, int rotationY, int rotationZ, int structureID) {
        this.multiBlock = multiBlock;
        this.x = x; this.y = y; this.z = z;
        this.rotationX = rotationX; this.rotationY = rotationY; this.rotationZ = rotationZ;
        this.structureID = structureID; this.multiBlockID = multiBlock.getID();
    }

    /**
     *  A multi block structure in world.
     *
     */
    public Structure(MultiBlock multiBlock, int x, int y, int z, int rotationY, int structureID) {
        this(multiBlock, x, y, z, 0, rotationY, 0, structureID);
    }

    public Structure() {
        valid = false;
    }

    public boolean getValid() {
        return valid;
    }

    public boolean structureValid(World world) {
        return valid && multiBlock.checkStructure(world, x, y, z, rotationX, rotationY, rotationZ);
    }

    public MultiBlock getMultiBlock() {
        return multiBlock;
    }

    public static void writeToNBT(NBTTagCompound nbtTagCompound, Structure structure) {
        writeToNBT(nbtTagCompound, structure, "multiBlock");
    }
    public static void writeToNBT(NBTTagCompound nbtTagCompound, Structure structure, String tagName) {
        NBTTagCompound structureCompound = new NBTTagCompound();

        structureCompound.setTag(tag_x, new NBTTagInt(structure.x));
        structureCompound.setTag(tag_y, new NBTTagInt(structure.y));
        structureCompound.setTag(tag_z, new NBTTagInt(structure.z));
        structureCompound.setTag(tag_rotationX, new NBTTagInt(structure.rotationX));
        structureCompound.setTag(tag_rotationY, new NBTTagInt(structure.rotationY));
        structureCompound.setTag(tag_rotationZ, new NBTTagInt(structure.rotationZ));
        structureCompound.setTag(tag_structureID, new NBTTagInt(structure.structureID));
        structureCompound.setTag(tag_multiBlockID, new NBTTagInt(structure.multiBlockID));

        nbtTagCompound.setTag(tagName, structureCompound);
    }

    public static Structure readFromNBT(NBTTagCompound nbtTagCompound) {
        return readFromNBT(nbtTagCompound, tag_multiBlock);
    }
    public static Structure readFromNBT(NBTTagCompound nbtTagCompound, String tagName) {
        if (!validNBT(nbtTagCompound, tagName))
            return new Structure();

        NBTTagCompound structureCompound = nbtTagCompound.getCompoundTag(tagName);

        int x = structureCompound.getInteger(tag_x);
        int y = structureCompound.getInteger(tag_y);
        int z = structureCompound.getInteger(tag_z);
        int rotationX = structureCompound.getInteger(tag_rotationX);
        int rotationY = structureCompound.getInteger(tag_rotationY);
        int rotationZ = structureCompound.getInteger(tag_rotationZ);
        int structureID = structureCompound.getInteger(tag_structureID);
        int multiBlockID = structureCompound.getInteger(tag_multiBlockID);

        return new Structure(ModMultiBlocks.getMultiblock(multiBlockID),x,y,z,rotationX,rotationY,rotationZ,structureID);
    }

    private static boolean validNBT(NBTTagCompound nbtTagCompound, String tagName) {
        if (nbtTagCompound.hasNoTags() || !nbtTagCompound.hasKey(tagName))
            return false;

        NBTTagCompound structureCompound = nbtTagCompound.getCompoundTag(tagName);
        return (
                        structureCompound.hasKey(tag_x) &&
                        structureCompound.hasKey(tag_y) &&
                        structureCompound.hasKey(tag_z) &&
                        structureCompound.hasKey(tag_rotationX) &&
                        structureCompound.hasKey(tag_rotationY) &&
                        structureCompound.hasKey(tag_rotationZ) &&
                        structureCompound.hasKey(tag_structureID) &&
                        structureCompound.hasKey(tag_multiBlockID) &&
                        ModMultiBlocks.hasMultiBlockID(structureCompound.getInteger(tag_multiBlockID))
        );
    }

    private static final String tag_x = "x";
    private static final String tag_y = "y";
    private static final String tag_z = "z";
    private static final String tag_rotationX = "rotationX";
    private static final String tag_rotationY = "rotationY";
    private static final String tag_rotationZ = "rotationZ";
    private static final String tag_structureID = "structureID";
    private static final String tag_multiBlockID = "multiBlockID";
    private static final String tag_multiBlock = "multiBlock";

}
