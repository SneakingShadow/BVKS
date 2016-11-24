package com.sneakingshadow.bvks.multiblock.structureblock;

import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
public class SBlockArrayList extends StructureBlock {

    private ArrayList<StructureBlock> arrayList;

    public SBlockArrayList(ArrayList<StructureBlock> arrayList) {
        this.arrayList = arrayList;
    }

    public boolean blockIsValid(World world, Vec3 worldPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {
        for (StructureBlock structureBlock : arrayList)
            if (structureBlock.blockIsValid(world, worldPosition, arrayPosition, rotationX, rotationY, rotationZ))
                return true;

        return false;
    }

}
