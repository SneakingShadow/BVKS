package sneakingshadow.bvks.structure;

import net.minecraft.world.World;

import static sneakingshadow.bvks.structure.MultiBlockComparing.compare;

public class MultiBlock {

    private Object[][][] multiBlock;
    private Boolean valid;
    private int ID;

    //TODO add id's

    public MultiBlock(Object... objects) {
        this(objects, 1,1,1);
    }
    public MultiBlock(int xCap, int yCap, int zCap, Object... objects) {
        this(objects, xCap, yCap, zCap);
    }

    /**
     *  null or ' '= anything, doesn't matter.
     *  "/" = next layer to the side.
     *  "//" = next layer up.
     *  if '!' is placed before an object, it will check that it's not that.
     *  '+' = full block
     *  '_' = air block
     *  '-' = replaceable block
     *  '~' = liquid
     *  '*' = opaque
     *  Characters can replace objects, but must be initialized afterwards, if not they are ignored.
     *  OreDictionary is supported, but the strings must start with '@' or be in an ArrayList<Object>
     *  ArrayList<Object> are allowed to specify multiple choices in one blockspace, and can include characters.
     * */
    private MultiBlock(Object[] objects, int xCap, int yCap, int zCap) {

        if (objects.length == 0) {
            valid = false;
            return;
        }

        multiBlock = MultiBlockInit.initStructure(objects, xCap, yCap, zCap);

        valid = false;
        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {
                    if (multiBlock[ix][iy][iz] != null) {
                        valid = true;
                        break;
                    }
                }
                if (valid) break;
            }
            if (valid) break;
        }
    }

    public Structure findStructure(World world, int x, int y, int z) {
        return findStructure(world, x, y, z, 0, 0 ,0);
    }

    /**
     * arrayX, arrayY & arrayZ starts at 1, not at 0.
     * */
    public Structure findStructure(World world, int x, int y, int z, int arrayX, int arrayY, int arrayZ) {
        if (!valid)
            return new Structure();

        arrayX = --arrayX < multiBlock.length ? arrayX : 0;
        arrayY = --arrayY < multiBlock[0].length ? arrayY : 0;
        arrayZ = --arrayZ < multiBlock[0][0].length ? arrayZ : 0;

        if ( compare(world, x, y, z, multiBlock[arrayX][arrayY][arrayZ]) ) {

            Vec center = new Vec(x,y,z);
            Vec corner = new Vec(x-arrayX, y-arrayY, z-arrayZ);

            for (int rotation = 0; rotation < 4; rotation++) {

                Vec vec = corner.rotateY(center, rotation);
                if ( checkStructure(world, vec.x, vec.y, vec.z, rotation) ) {
                    return new Structure(this, vec.x, vec.y, vec.z, rotation);
                }

            }
        }

        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {

                    if ( compare(world, x, y, z, multiBlock[ix][iy][iz]) ) {

                        Vec center = new Vec(x,y,z);
                        Vec corner = new Vec(x-ix, y-iy, z-iz);

                        for (int rotation = 0; rotation < 4; rotation++) {

                            Vec vec = corner.rotateY(center, rotation);
                            if ( checkStructure(world, vec.x, vec.y, vec.z, rotation) ) {
                                return new Structure(this, vec.x, vec.y, vec.z, rotation);
                            }

                        }
                    }

                }
            }
        }

        return new Structure();
    }

    public boolean checkStructure(World world, int x, int y, int z, int rotation) {
        Vec center = new Vec(x,y,z);

        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {
                    Vec current = (new Vec(x+ix,y+iy,z+iz)).rotateY(center, rotation);

                    if (!compareVec(world, current, multiBlock[ix][iy][iz])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean valid() {
        return this.valid;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    private boolean compareVec(World world, Vec vec, Object object) {
        return compare(world, vec.x, vec.y, vec.z, object);
    }

    @Override
    public String toString() {
        String string = getClass().getName() + "@" + Integer.toHexString(hashCode()) + System.lineSeparator() + "{";
        for (int ix = 0; ix < multiBlock.length; ix++) {
            string = string + System.lineSeparator() + "   {";
            for (int iy = 0; iy < multiBlock[0].length; iy++) {
                string = string + System.lineSeparator() + "      {";
                for (int iz = 0; iz < multiBlock[0][0].length; iz++) {
                    string = string + System.lineSeparator() + "         " + ( multiBlock[ix][iy][iz] != null ? multiBlock[ix][iy][iz].toString() : "null" ) + ", ";
                }
                string = string + System.lineSeparator() + "      },";
            }
            string = string + System.lineSeparator() + "   },";
        }
        string = string + System.lineSeparator() + "};";
        return string;
    }
}
