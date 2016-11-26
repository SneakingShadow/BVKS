package com.sneakingshadow.bvks.structure.modifer;

import com.sneakingshadow.bvks.structure.MultiBlockInit;
import com.sneakingshadow.bvks.structure.ObjectMap;
import com.sneakingshadow.bvks.structure.Vec;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public abstract class StructureModifier {

    public abstract boolean structureMod(MultiBlockInit.ObjectArray multiBlock, Vec vec, Object object);

    public int skipObjects(int i, Object[] objects, ObjectMap objectMap) {
        return 0;
    }

    public static int skip(Boolean bool, int i, Object[] objects, ObjectMap objectMap) {
        if (!bool)
            return 0;
        Object key = objects[i++];
        int num = 1;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (i < objects.length && objects[i] instanceof Character && objects[i] == CharacterModifier.notChar) {
            arrayList.add(objects[i++]);
            num++;
        }
        if (i < objects.length) {
            if (arrayList.isEmpty()) {
                objectMap.put(key, objects[i]);
            } else {
                arrayList.add(objects[i]);
                objectMap.put(key, arrayList);
            }
        }
        return num;
    }


}
