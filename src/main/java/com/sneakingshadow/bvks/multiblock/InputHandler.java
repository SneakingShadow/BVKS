package com.sneakingshadow.bvks.multiblock;


import net.minecraft.util.Vec3;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
class InputHandler {

    static Structure getStructure(Object[] objects) {
        Structure structure = new Structure();
        Vec3 currentPos = Vec3.createVectorHelper(0d,0d,0d);
        ArrayList<Object> inputList = InputSorter.sortInput(objects);


        return structure;
    }

}
