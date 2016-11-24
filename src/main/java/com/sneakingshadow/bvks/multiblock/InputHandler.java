package com.sneakingshadow.bvks.multiblock;

import java.util.ArrayList;

class InputHandler {

    static StructureArray getStructure(Object[] objects) {
        StructureArray structureArray = new StructureArray();
        ArrayList<Object> arrayList = InputSorter.sortList(objects);

        return structureArray;
    }

}
