package com.sneakingshadow.bvks.structure;

import com.sneakingshadow.bvks.structure.modifer.CharacterModifier;
import com.sneakingshadow.bvks.structure.modifer.StructureModifier;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public class MultiBlockInit {

    private static ArrayList<StructureModifier> modifiers = new ArrayList<StructureModifier>();

    public static void addModifier(StructureModifier modifier) {
        modifiers.add(modifier);
    }

    public static ObjectAndMap initStructure(Object[] objects, int xCap, int yCap, int zCap) {

        ObjectMap objectMap = new ObjectMap();
        ObjectArray structure = new ObjectArray(xCap, yCap, zCap);
        Vec vec = new Vec(0, 0, 0);

        ArrayList<Object> objectList = new ArrayList<Object>();
        addToObjectList(objectList, objects);
        objects = objectList.toArray();

        for (int i = 0; i < objects.length; i++) {

            Object object = objects[i];

            for (StructureModifier mod : modifiers) {
                if (mod.structureMod(structure, vec, object)) {
                    i += mod.skipObjects(i, objects, objectMap);
                    break;
                }
            }

        }

        Object[][][] multiBlock = structure.getArray();

        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {
                    multiBlock[ix][iy][iz] = objectMap.replaceObject(multiBlock[ix][iy][iz]);
                }
            }
        }

        return new ObjectAndMap(multiBlock, objectMap);
    }

    private static void addToObjectList(ArrayList<Object> objectList, Object[] objects) {

        for (Object object : objects) {
            if (object instanceof MultiBlock.StructureList) {
                addToObjectList(objectList, ((MultiBlock.StructureList)object).getObjects());
            } else {
                objectList.add(object);
            }
        }

    }

    public static class ObjectArray {

        private Object[][][] multiBlock;

        public ObjectArray(int xCap, int yCap, int zCap) {
            multiBlock = new Object[xCap][yCap][zCap];
        }

        private Object[][][] getArray() {
            return multiBlock;
        }

        public Object getObject(int x, int y, int z) {
            return multiBlock
                    [Math.min(x,multiBlock.length)]
                    [Math.min(y,multiBlock[0].length)]
                    [Math.min(z,multiBlock[0][0].length)];
        }

        public void addToStructure(Vec vec, Object obj) {
            int maxY = Math.max(vec.y, multiBlock[0].length);
            int maxZ = Math.max(vec.z, multiBlock[0][0].length);

            if (vec.x >= multiBlock.length) {
                multiBlock = Arrays.copyOf(multiBlock, vec.x+1);
                replaceNull(multiBlock, new Object[maxY][maxZ]);
            }
            if(vec.y >= multiBlock[0].length) {
                for (int ix = 0; ix < multiBlock.length; ix++) {
                    multiBlock[ix] = Arrays.copyOf(multiBlock[ix], vec.y+1);
                    replaceNull(multiBlock[ix], new Object[maxZ]);
                    if(vec.z >= multiBlock[0][0].length) {
                        for (int iy = 0; iy < multiBlock[vec.x].length; iy++) {
                            multiBlock[ix][iy] = Arrays.copyOf(multiBlock[ix][iy],vec.z+1);
                        }
                    }
                }
            }else{
                if(vec.z >= multiBlock[0][0].length) {
                    for (int ix = 0; ix < multiBlock.length; ix++) {
                        for (int iy = 0; iy < multiBlock[vec.x].length; iy++) {
                            multiBlock[ix][iy] = Arrays.copyOf(multiBlock[ix][iy],vec.z+1);
                        }
                    }
                }
            }

            add(vec.x, vec.y, vec.z, obj);
            if (obj != CharacterModifier.notChar) {
                vec.x++;
            }
        }

        private void add(int x, int y, int z, Object object) {
            if (multiBlock[x][y][z] != null) {
                ArrayList<Object> arrayList = new ArrayList<Object>();
                arrayList.add(multiBlock[x][y][z]);
                arrayList.add(object);
                multiBlock[x][y][z] = arrayList;
            }else {
                multiBlock[x][y][z] = object;
            }
        }

        private void replaceNull(Object[] objects, Object object) {
            for (int i = 0; i < objects.length; i++) {
                if (objects[i] == null) {
                    objects[i] = object;
                }
            }
        }

    }

    public static class ObjectAndMap {
        public Object[][][] multiBlock;
        public ObjectMap objectMap;

        public ObjectAndMap(Object[][][] objects, ObjectMap map) {
            multiBlock = objects;
            objectMap = map;
        }
    }
}
