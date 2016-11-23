package com.sneakingshadow.bvks.multiblock.Input;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
class InputUtil {

    static void addToBracket(Object object, boolean bool, ArrayList<Object> list_1, ArrayList<Object> list_2) {
        if (bool)
            list_1.add(object);
        else
            list_2.add(object);
    }

}
