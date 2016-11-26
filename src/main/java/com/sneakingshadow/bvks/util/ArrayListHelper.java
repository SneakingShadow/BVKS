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

    public static <T> ArrayList<T> fromArray(T[] objects) {
        ArrayList<T> arrayList = new ArrayList<T>();

        Collections.addAll(arrayList,objects);

        return arrayList;
    }

}
