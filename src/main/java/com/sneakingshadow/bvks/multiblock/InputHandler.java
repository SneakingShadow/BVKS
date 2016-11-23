package com.sneakingshadow.bvks.multiblock;


import net.minecraft.util.Vec3;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
class InputHandler {

    static StructureArray getStructure(Object[] objects) {
        StructureArray structure = new StructureArray();

        Vec3 currentPos = Vec3.createVectorHelper(0d,0d,0d);
        HashMap<Character, Object> charMap = new HashMap<Character, Object>();
        HashMap<String, Object> stringMap = new HashMap<String, Object>();

        ArrayList<Object> inputList = InputSorterOld.sortInput(objects);

        return structure;
    }

}
