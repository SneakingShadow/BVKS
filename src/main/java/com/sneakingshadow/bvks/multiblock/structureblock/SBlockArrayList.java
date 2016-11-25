package com.sneakingshadow.bvks.multiblock.structureblock;

import com.sneakingshadow.bvks.multiblock.structureblock.special.SBlockNull;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.NEXT_LEVEL;
import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.NEXT_LINE;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
public class SBlockArrayList extends StructureBlock {

    private ArrayList<StructureBlock> arrayList = new ArrayList<StructureBlock>();

    public SBlockArrayList(ArrayList<Object> inputList) {
        for (Object arrayObject : inputList)
            if (arrayObject == null)
                arrayList.add(new SBlockNull());
            else if (!NEXT_LINE.equals(arrayObject) && !NEXT_LEVEL.equals(arrayObject))
                arrayList.add((StructureBlock) arrayObject);


    }

    public boolean blockIsValid(World world, Vec3 worldPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {
        for (StructureBlock structureBlock : arrayList)
            if (structureBlock.blockIsValid(world, worldPosition, arrayPosition, rotationX, rotationY, rotationZ))
                return true;

        return false;
    }

}
