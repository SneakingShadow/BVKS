package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.special.SBlockNull;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
class StructureArray {

    private ArrayList<ArrayList<ArrayList<StructureBlock>>> structure = new ArrayList<ArrayList<ArrayList<StructureBlock>>>();

    StructureArray() {
        structure.add(new ArrayList<ArrayList<StructureBlock>>());
        structure.get(0).add(new ArrayList<StructureBlock>());
        structure.get(0).get(0).add(new SBlockNull());
    }


    void set(int x, int y, int z, StructureBlock structureBlock) {
        ensureCapacity(x,y,z);
        structure.get(x).get(y).add(z, structureBlock == null ? new SBlockNull() : structureBlock);
    }

    StructureBlock get(int x, int y, int z) {
        if (x < sizeX() && y < sizeY() && z < sizeZ())
            return structure.get(x).get(y).get(z);
        return new SBlockNull();
    }

    boolean blockIsValid(World world, Vec3 worldPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {
        return get((int)arrayPosition.xCoord, (int)arrayPosition.yCoord, (int)arrayPosition.zCoord)
                .blockIsValid(world, worldPosition, arrayPosition, rotationX, rotationY, rotationZ);
    }


    int sizeX() {
        return structure.size();
    }

    int sizeY() {
        return structure.get(0).size();
    }

    int sizeZ() {
        return structure.get(0).get(0).size();
    }



    private void ensureCapacity(int x, int y, int z) {
        boolean x_bool = x > sizeX(); // x is too large
        boolean y_bool = y > sizeY(); // y is too large
        boolean z_bool = z > sizeZ(); // z is too large

        //Doesn't need to go through anything
        if (!x_bool && !y_bool && !z_bool)
            return;

        //Doesn't need to go through x array unless y array or z array are too small
        if (y_bool || z_bool)
            //Go through and ensure current x array
            for (int ix = 0; ix < sizeX(); ix++)
            {
                //Doesn't need to go through y array unless z is too small
                if (z_bool)
                    for (int iy = 0; iy < sizeY(); iy++)
                        //Ensure z array
                        for (int iz = sizeZ(); iz < z + 1; iz++)
                            structure.get(ix).get(iy).add(new SBlockNull());

                //Ensure y array. Doesn't need to check if y_bool, as iy < y+1 serves this function
                for (int iy = sizeY(); iy < y + 1; iy++)
                    structure.get(ix).add(getEmptyArray(z));
            }

        //Ensure structure
        for (int ix = sizeX(); ix < x+1; ix++)
            structure.add(getEmptyArray(y, z));
    }

    private int maxY(int y) {
        return Math.max(y+1, sizeY());
    }

    private int maxZ(int z) {
        return Math.max(z+1, sizeZ());
    }

    private ArrayList<StructureBlock> getEmptyArray(int z) {
        ArrayList<StructureBlock> arrayList = new ArrayList<StructureBlock>();
        for (int iz = 0; iz < maxZ(z); iz++) {
            arrayList.add(new SBlockNull());
        }
        return arrayList;
    }

    private ArrayList<ArrayList<StructureBlock>> getEmptyArray(int y, int z) {
        ArrayList<ArrayList<StructureBlock>> arrayList = new ArrayList<ArrayList<StructureBlock>>();
        for (int iy = 0; iy < maxY(y); iy++) {
            arrayList.add(getEmptyArray(z));
        }
        return arrayList;
    }

    @Override
    public String toString() {
        String string = "";

        for (int x = 0; x < sizeX(); x++) {
            string += "{\n";
            for (int y = 0; y < sizeY(); y++) {
                string += "    {\n";
                for (int z = 0; z < sizeZ(); z++) {
                    string += "        " + get(x,y,z).toString() + ",\n";
                }
                string += "    },\n";
            }
            string += "},\n";
        }

        return string;
    }
}
