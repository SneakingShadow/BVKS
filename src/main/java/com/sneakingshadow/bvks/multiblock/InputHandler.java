package com.sneakingshadow.bvks.multiblock;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

class InputHandler {

    @NotNull
    static StructureArray getStructureArray(Object[] objects) {
        StructureArray structureArray = new StructureArray();
        ArrayList<Object> arrayList = InputSorter.sortInput(objects);

        //Handle the structure modifiers.

        return structureArray;
    }

}
