package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.NEXT_LEVEL;
import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.NEXT_LINE;

class InputHandler {

    static StructureArray getStructureArray(Object[] objects) {
        return getStructureArray(objects, false);
    }

    @NotNull
    static StructureArray getStructureArray(Object[] objects, boolean debug) {
        StructureArray structureArray = new StructureArray();
        ArrayList<Object> arrayList = InputSorter.sortInput(objects, debug);

        int x = 0, y = 0, z = 0;

        for (Object object : arrayList) {
            if (object instanceof StructureBlock)
                structureArray.set(x++,y,z,(StructureBlock)object);

            if (object instanceof Character) {
                if (NEXT_LINE.equals(object)) {
                    z++;
                    x=0;
                }
                if (NEXT_LEVEL.equals(object)) {
                    y++;
                    x=0;
                    z=0;
                }
            }
        }

        return structureArray;
    }

}
