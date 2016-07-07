package sneakingshadow.bvks.structure;

import net.minecraft.block.Block;
import net.minecraft.world.World;

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
     *  ArrayList<Object> are allowed to specify multiple choices in one blockspace, and can include characters.
     * */
    public Structure(Object... objects) {
        this(objects, 1,1,1);
    }
    /**
     *  null or ' '= anything, doesn't matter
     *  "/" = next layer to the side.
     *  "//" = next layer up.
     *  Characters can replace objects, but must be initialized afterwards, if not they are ignored.
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

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof String) {
                String string = (String)objects[i];
                for (int j = 0; j < string.length(); j++) {
                    if (string.charAt(j) == ' ') {
                        addToStructure(x++, y, z, null);
                    }
                    if (string.charAt(j) == '/'){
                        if (string.charAt(j+1) == '/') {
                            j++;
                            x=0; y++; z=0;
                        }else{
                            x=0; z++;
                        }
                    } else {
                        addToStructure(x++, y, z, string.charAt(j));
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
                        Boolean bool = true;

                        if (structure[ix][iy][iz] instanceof Character) {
                            if (chars.containsKey((Character) structure[ix][iy][iz])) {
                                structure[ix][iy][iz] = chars.get((Character) structure[ix][iy][iz]);
                            } else {
                                structure[ix][iy][iz] = null;
                                bool = false;
                            }
                        }else if (structure[ix][iy][iz] instanceof ArrayList) {
                            structure[ix][iy][iz] = ((ArrayList) structure[ix][iy][iz]).toArray();
                        }

                        valid = valid || bool;
                    }

                }
            }
        }

    }

    public StructureInWorld findStructure(World world, int x, int y, int z) {
        return findStructure(world, x, y, z, 0, 0 ,0);
    }

    public StructureInWorld findStructure(World world, int x, int y, int z, int structureX, int structureY, int structureZ) {
        if (!valid)
            return null;

        structureX = structureX < structure.length ? structureX : structure.length-1;
        structureY = structureY < structure[0].length ? structureY : structure[0].length-1;
        structureZ = structureZ < structure[0][0].length ? structureZ : structure[0][0].length-1;

        if ( compare(world, x,y,z, structure[structureX][structureY][structureZ]) ) {

            for (int rotation = 0; rotation < 4; rotation++) {
                if ( checkStructure(world, x, y, z, rotation) ) {
                    return new StructureInWorld(this, x, y, z, rotation);
                }
            }

        }

        for (int ix = 0; ix < structure.length; ix++) {
            for (int iy = 0; iy < structure[ix].length; iy++) {
                for (int iz = 0; iz < structure[ix][iy].length; iz++) {

                    if ( compare(world, x, y, z, structure[ix][iy][iz]) ) {

                        for (int rotation = 0; rotation < 4; rotation++) {
                            if ( checkStructure(world, x-ix, y-iy, z-iz, rotation) ) {
                                return new StructureInWorld(this, x-ix, y-iy, z-iz, rotation);
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

    private boolean compare(World world, Vec vec, Object object) {
        return compare(world, vec.x, vec.y, vec.z, object);
    }

    private boolean compare(World world, int x, int y, int z, Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Block && world.getBlock(x,y,z) == obj){
            return true;
        }
        return false;
    }

    private void addToStructure(int x, int y, int z, Object obj) {

        System.out.println(structure.length);
        System.out.println(x);
        if(x > structure.length) {
            structure = Arrays.copyOf(structure, x+1);
        }
        if(y > structure[x].length) {
            for (int ix = 0; ix < structure.length; ix++) {
                structure[ix] = Arrays.copyOf(structure[ix], y+1);
                if(z > structure[x][y].length) {
                    for (int iy = 0; iy < structure[x].length; iy++) {
                        structure[ix][iy] = Arrays.copyOf(structure[ix][iy],z+1);
                    }
                }
            }
        }else{
            if(z > structure[x][y].length) {
                for (int ix = 0; ix < structure.length; ix++) {
                    for (int iy = 0; iy < structure[x].length; iy++) {
                        structure[ix][iy] = Arrays.copyOf(structure[ix][iy],z+1);
                    }
                }
            }
        }

        structure[x][y][z] = obj;

    }

    private class Vec {

        public int x;
        public int y;
        public int z;

        public Vec(int x, int y, int z) {
            this.x = x; this.y = y; this.z = z;
        }

        /**
         * @param vec point to rotate around
         * @param rot how many 90 degrees it should be rotated. Rot = 3 ==> 270 degrees.
         */
        public Vec rotate(Vec vec, int rot) {

            int numX = rot == 0 ? x :
                    rot == 1 ? z + vec.x - vec.z :
                            rot == 2 ? 2*vec.x - x :
                                    vec.x + vec.z - z;
            int numZ = rot == 0 ? z :
                    rot == 1 ? vec.x + vec.z - x :
                            rot == 2 ? 2*vec.z - z :
                                    x - vec.x + vec.z;

            this.x = numX; this.z = numZ;
            return this;
        }

    }
}
