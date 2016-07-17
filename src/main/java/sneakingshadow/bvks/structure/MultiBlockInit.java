package sneakingshadow.bvks.structure;

import sneakingshadow.bvks.structure.modifer.CharacterModifier;
import sneakingshadow.bvks.structure.modifer.StructureModifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public class MultiBlockInit {

    private static ArrayList<StructureModifier> modifiers = new ArrayList<StructureModifier>();

    public static void addModifier(StructureModifier modifier) {
        modifiers.add(modifier);
    }

    public static Object[][][] initStructure(Object[] objects, int xCap, int yCap, int zCap) {

        HashMap<Character, Object> charMap = new HashMap<Character, Object>();
        ObjectArray structure = new ObjectArray(xCap, yCap, zCap);
        Vec vec = new Vec(0, 0, 0);

        for (int i = 0; i < objects.length; i++) {

            Object object = objects[i];

            for (StructureModifier mod : modifiers) {
                if (mod.structureMod(structure, vec, object)) {
                    i += mod.skipObjects(i, objects, charMap);
                    break;
                }
            }

        }

        Object[][][] multiBlock = structure.getArray();

        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {

                    if (multiBlock[ix][iy][iz] instanceof Character) {
                        Character character = (Character) multiBlock[ix][iy][iz];
                        if (charMap.containsKey(character)) {
                                multiBlock[ix][iy][iz] = charMap.get(character);
                        } else if (!CharacterModifier.contains(character)) {
                            multiBlock[ix][iy][iz] = null;
                        }
                    }

                }
            }
        }

        return multiBlock;
    }
        /*

        valid = false;
        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {

                    if (multiBlock != null) {
                        Boolean bool = true;

                        if (multiBlock[ix][iy][iz] instanceof Character) {
                            if ((Character) multiBlock[ix][iy][iz] != ' ' &&
                                    chars.containsKey((Character) multiBlock[ix][iy][iz])) {
                                multiBlock[ix][iy][iz] = chars.get((Character) multiBlock[ix][iy][iz]);
                            } else {
                                multiBlock[ix][iy][iz] = null;
                                bool = false;
                            }
                        } else if (multiBlock[ix][iy][iz] instanceof ArrayList) {
                            multiBlock[ix][iy][iz] = ((ArrayList) multiBlock[ix][iy][iz]).toArray();
                        }

                        valid = valid || bool;
                    }

                }
            }
        }
        */


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

}
