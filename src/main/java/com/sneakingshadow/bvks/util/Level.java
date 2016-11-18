package com.sneakingshadow.bvks.util;

import java.util.ArrayList;

public class Level {

    private ArrayList<ArrayList<Object>> array = new ArrayList<ArrayList<Object>>();

    public Level() {

    }

    public void set(int x, int y, Object object) {
        int i = array.size();
        while (i++ <= y)
        {
            array.add(new ArrayList<Object>());
        }
        ArrayList<Object> arrayList = array.get(y);
        i = arrayList.size();
        while (i++ <= x)
        {
            arrayList.add(null);
        }
        arrayList.set(x, object);
    }

    public Object get(int x, int y) {
        return this.array.get(y).get(x);
    }

}
