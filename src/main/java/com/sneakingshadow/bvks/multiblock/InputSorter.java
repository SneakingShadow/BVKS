package com.sneakingshadow.bvks.multiblock;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 22.11.2016.
 */
class InputSorter {

    /**
     * Returns null if invalid.
     *
     * Returns everything that should be regarded as structure block as a StructureBlock.
     * Returns everything that should be regarded as an operator as an Operator.
     * Returns everything that should be regarded as a modifier as a Modifier.
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

    /**
     * Sorts the input, doesn't modify the input, only removes bad arguments.
     * Note: Null is not a bad argument, but from ensureObject it is.
     * */
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

            Object input = ensureObject(object);
            if (input != null) {
                outputList.add(input);
            }
        }

        return outputList;
    }

}
