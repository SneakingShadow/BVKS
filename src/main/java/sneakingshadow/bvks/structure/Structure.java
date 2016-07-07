package sneakingshadow.bvks.structure;

import net.minecraft.world.World;
import sneakingshadow.bvks.util.LogHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Structure {

    private Object[][][] structure;
    public Boolean valid = true;

    /**
     *  null or ' '= anything, doesn't matter
     *  "/" = next layer to the side.
     *  "//" = next layer up.
     *  Characters can replace objects, but must be initialized afterwards, if not they are ignored.
     *  OreDictionary is supported, but the strings must start with '@' or be in an ArrayList<Object>
     *  ArrayList<Object> are allowed to specify multiple choices in one blockspace, and can include characters.
     * */
    public Structure(Object... objects) {
        this(objects, 1,1,1);
    }
    /**
     *  null or ' '= anything, doesn't matter.
     *  "/" = next layer to the side.
     *  "//" = next layer up.
     *  Characters can replace objects, but must be initialized afterwards, if not they are ignored.
     *  OreDictionary is supported, but the strings must start with '@' or be in an ArrayList<Object>
     *  ArrayList<Object> are allowed to specify multiple choices in one blockspace, and can include characters.
     * */
    public Structure(int xCap, int yCap, int zCap, Object... objects) {
        this(objects, xCap, yCap, zCap);
    }

    private Structure(Object[] objects, int xCap, int yCap, int zCap) {

        if (objects.length == 0) {
            valid = false;
            return;
        }

        structure = new Object[xCap][yCap][zCap];
        int x=0;
        int y=0;
        int z=0;

        HashMap<Character, Object> chars = new HashMap<Character, Object>();
        boolean bool = true;

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof String) {
                String string = (String) objects[i];
                if (string.isEmpty() || string.charAt(0) == '@' && string.length() <= 1) {

                } else if (string.charAt(0) == '@') {

                } else {
                    for (int j = 0; j < string.length(); j++) {
                        if (string.charAt(j) == '/') {
                            if (string.charAt(j + 1) == '/') {
                                j++;
                                x = 0;
                                y++;
                                z = 0;
                            } else {
                                x = 0;
                                z++;
                            }
                        }
                    }
                }
            } else if (i < objects.length-1 && objects[i] instanceof Character) {
                chars.put((Character)objects[i++], objects[i]);
            } else {
                addToStructure(x++, y, z, objects[i]);
            }
        }

        valid = false;
        for (int ix = 0; ix < structure.length; ix++) {
            for (int iy = 0; iy < structure[ix].length; iy++) {
                for (int iz = 0; iz < structure[ix][iy].length; iz++) {

                    if (structure != null) {
                        bool = true;

                        if (structure[ix][iy][iz] instanceof Character) {
                            if ((Character)structure[ix][iy][iz] != ' ' &&
                                    chars.containsKey((Character) structure[ix][iy][iz])) {
                                structure[ix][iy][iz] = chars.get((Character) structure[ix][iy][iz]);
                            } else {
                                structure[ix][iy][iz] = null;
                                bool = false;
                            }
                        } else if (structure[ix][iy][iz] instanceof ArrayList) {
                            structure[ix][iy][iz] = ((ArrayList) structure[ix][iy][iz]).toArray();
                        }

                        valid = valid || bool;
                    }

                }
            }
        }

        //TODO REMOVE
        String string = "{ ";
        for (int ix = 0; ix < structure.length; ix++) {
            string = string + "{ ";
            for (int iy = 0; iy < structure[0].length; iy++) {
                string = string + "{ ";
                for (int iz = 0; iz < structure[0][0].length; iz++) {
                    string = string + ( structure[ix][iy][iz] != null ? structure[ix][iy][iz].toString() : "null" ) + ", ";
                }
                string = string + "},";
            }
            string = string + "},";
        }
        string = string + "};";
        LogHelper.info(string);
    }

    public StructureInWorld findStructure(World world, int x, int y, int z) {
        return findStructure(world, x, y, z, 0, 0 ,0);
    }

    public StructureInWorld findStructure(World world, int x, int y, int z, int arrayX, int arrayY, int arrayZ) {
        if (!valid)
            return null;

        arrayX = arrayX < structure.length ? arrayX : 0;
        arrayY = arrayY < structure[0].length ? arrayY : 0;
        arrayZ = arrayZ < structure[0][0].length ? arrayZ : 0;

        if ( StructureUtil.compare(world, x, y, z, structure[arrayX][arrayY][arrayZ]) ) {

            Vec center = new Vec(x,y,z);
            Vec corner = new Vec(x-arrayX, y-arrayY, z-arrayZ);

            for (int rotation = 0; rotation < 4; rotation++) {

                Vec vec = corner.rotate(center, rotation);
                if ( checkStructure(world, vec.x, vec.y, vec.z, rotation) ) {
                    return new StructureInWorld(this, vec.x, vec.y, vec.z, rotation);
                }

            }
        }

        for (int ix = 0; ix < structure.length; ix++) {
            for (int iy = 0; iy < structure[ix].length; iy++) {
                for (int iz = 0; iz < structure[ix][iy].length; iz++) {

                    if ( StructureUtil.compare(world, x, y, z, structure[ix][iy][iz]) ) {

                        Vec center = new Vec(x,y,z);
                        Vec corner = new Vec(x-ix, y-iy, z-iz);

                        for (int rotation = 0; rotation < 4; rotation++) {

                            Vec vec = corner.rotate(center, rotation);
                            if ( checkStructure(world, vec.x, vec.y, vec.z, rotation) ) {
                                return new StructureInWorld(this, vec.x, vec.y, vec.z, rotation);
                            }

                        }
                    }

                }
            }
        }

        return null;
    }

    public boolean checkStructure(World world, int x, int y, int z, int rotation) {
        Vec center = new Vec(x,y,z);

        for (int ix = 0; ix < structure.length; ix++) {
            for (int iy = 0; iy < structure[ix].length; iy++) {
                for (int iz = 0; iz < structure[ix][iy].length; iz++) {
                    Vec current = (new Vec(x+ix,y+iy,z+iz)).rotate(center, rotation);

                    if (!compare(world, current, structure[ix][iy][iz])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private void addToStructure(int x, int y, int z, Object obj) {

        int maxY = Math.max(y,structure[0].length);
        int maxZ = Math.max(z,structure[0][0].length);

        if (x >= structure.length) {
            structure = Arrays.copyOf(structure, x+1);
            replaceNull(structure, new Object[maxY][maxZ]);
        }
        if(y >= structure[0].length) {
            for (int ix = 0; ix < structure.length; ix++) {
                structure[ix] = Arrays.copyOf(structure[ix], y+1);
                replaceNull(structure[ix], new Object[maxZ]);
                if(z >= structure[0][0].length) {
                    for (int iy = 0; iy < structure[x].length; iy++) {
                        structure[ix][iy] = Arrays.copyOf(structure[ix][iy],z+1);
                    }
                }
            }
        }else{
            if(z >= structure[0][0].length) {
                for (int ix = 0; ix < structure.length; ix++) {
                    for (int iy = 0; iy < structure[x].length; iy++) {
                        structure[ix][iy] = Arrays.copyOf(structure[ix][iy],z+1);
                    }
                }
            }
        }

        structure[x][y][z] = obj;

    }

    private void replaceNull(Object[] objects, Object object) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = object;
            }
        }
    }

    private String oreDictionary(String string) {
        return string.substring(1);
    }

    private boolean compare(World world, Vec vec, Object object) {
        return StructureUtil.compare(world, vec.x, vec.y, vec.z, object);
    }

    private class Vec {

        public int x;
        public int y;
        public int z;

        private Vec(int x, int y, int z) {
            this.x = x; this.y = y; this.z = z;
        }

        /**
         * @param vec point to rotate around
         * @param rot how many 90 degrees it should be rotated. Rot = 3 ==> 270 degrees.
         */
        private Vec rotate(Vec vec, int rot) {

            int numX = rot == 0 ? x :
                    rot == 1 ? z + vec.x - vec.z :
                            rot == 2 ? 2*vec.x - x :
                                    vec.x + vec.z - z;
            int numZ = rot == 0 ? z :
                    rot == 1 ? vec.x + vec.z - x :
                            rot == 2 ? 2*vec.z - z :
                                    x - vec.x + vec.z;

            return new Vec(numX,y,numZ);
        }

    }
}
