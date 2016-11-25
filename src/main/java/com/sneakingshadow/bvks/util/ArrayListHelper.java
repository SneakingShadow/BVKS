package com.sneakingshadow.bvks.util;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class ArrayListHelper {

    /**
     * Initializes an ArrayList with objects.
     * */
    public static <T> ArrayList<T> getArrayList(T... objects) {
        ArrayList<T> arrayList = new ArrayList<T>();

        Collections.addAll(arrayList, objects);

        return arrayList;
    }

    /**
     * For use with to array when the object has not been cast.
     * ArrayListHelper.toArray(object) instead of ((ArrayList) object).toArray()
     * */
    public static Object[] toArray(Object object) {
        if (object instanceof ArrayList)
            return ((ArrayList) object).toArray();
        return new Object[0];
    }

}
