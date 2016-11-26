package com.sneakingshadow.bvks.multiblock.structureblock;

import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.HashMap;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.STRING_OBJECT;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
public abstract class StructureBlock {

    /**
     * A small un-official check to determine if it should continue checking in world.
     * */
    public abstract boolean startCheckingForStructure(World world,int x,int y,int z);

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

    /**
     * Gets called at the end of structure initialization, in order to let operators and arrayList sort its contained structure blocks out.
     * @return itself.
     *
     * Note:
     *     Mapped string in stringMap start with MultiBlockLists.STRING_OBJECT
     * */
    public StructureBlock map(HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        return this;
    }

    /**
     * Returns the correct object if the object is mapped, but if nothing is valid, it's for example a structure modifier, null is returned.
     * */
    public StructureBlock map(Object object, HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        if (object instanceof StructureBlock)
            return ((StructureBlock) object).map(charMap, stringMap);

        else if (object instanceof Character) {
            StructureBlock structureBlock = charMap.get(object);
            if (structureBlock != null)
                return structureBlock.map(charMap, stringMap);

        } else if (object instanceof String && !((String) object).isEmpty() && STRING_OBJECT.equals(((String) object).charAt(0))) {
            StructureBlock structureBlock = stringMap.get(object);
            if (structureBlock != null)
                return structureBlock.map(charMap, stringMap);
        }
        return null;
    }

}
