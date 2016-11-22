package com.sneakingshadow.bvks.multiblock;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
class InputSorter {

    /**
     * Returns null if invalid.
     * */
    private static Object ensureObject(Object object) {

        if (object instanceof ArrayList) {
            ArrayList<Object> arrayList = cleanList(
                    ((ArrayList)object).toArray(),
                    new ArrayList<Object>()
            );
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }

        return null;
    }

    static ArrayList<Object> sortInput(Object[] objects) {
        return cleanList(objects, new ArrayList<Object>());
    }

    /**
     * Returns a clean list without invalid inputs.
     * */
    private static ArrayList<Object> cleanList(Object[] objects, ArrayList<Object> outputList) {

        for (Object object : objects) {
            if (object == null) {
                outputList.add(null);
            }

            if (object instanceof InputList) {
                cleanList(
                        ((InputList) object).toArray(),
                        outputList
                );
            }

            Object structureBlock = ensureObject(object);
            if (structureBlock != null) {
                outputList.add(structureBlock);
            }
        }

        return outputList;
    }

}
