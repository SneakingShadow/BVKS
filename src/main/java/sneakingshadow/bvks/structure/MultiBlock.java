package sneakingshadow.bvks.structure;

import net.minecraft.world.World;

import java.util.ArrayList;

import static sneakingshadow.bvks.structure.MultiBlockComparing.compare;

public class MultiBlock {

    private ArrayList<StructureArray> multiBlocks = new ArrayList<StructureArray>();
    private Boolean valid = false;
    private int ID;

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

        valid = addStructure(objects, xCap, yCap, zCap);
    }

    public boolean addStructure(Object... objects) {
        return addStructure(objects,1,1,1);
    }

    public boolean addStructure(int xCap, int yCap, int zCap, Object... objects) {
        return addStructure(objects, xCap, yCap, zCap);
    }

    public Structure findStructure(World world, int x, int y, int z) {
        return findStructure(world, x, y, z, 1, 1 ,1);
    }

    /**
     * arrayX, arrayY & arrayZ starts at 1, not at 0.
     * */
    public Structure findStructure(World world, int x, int y, int z, int arrayX, int arrayY, int arrayZ) {
        if (!valid)
            return new Structure();

        for (int structureID = 0; structureID < multiBlocks.size(); structureID++) {
            Structure structure = findStructure(world, x, y, z, arrayX, arrayY, arrayZ, structureID);
            if (structure.getValid()) {
                return structure;
            }
        }
        return new Structure();
    }

    /**
     * arrayX, arrayY & arrayZ starts at 1, not at 0.
     * */
    public Structure findStructure(World world, int x, int y, int z, int arrayX, int arrayY, int arrayZ, int structureID) {
        Object[][][] multiBlock = multiBlocks.get(structureID).getMultiBlock();

        arrayX = --arrayX < multiBlock.length ? arrayX : 0;
        arrayY = --arrayY < multiBlock[0].length ? arrayY : 0;
        arrayZ = --arrayZ < multiBlock[0][0].length ? arrayZ : 0;
        arrayX = arrayX < 0 ? 0 : arrayX;
        arrayY = arrayY < 0 ? 0 : arrayY;
        arrayZ = arrayZ < 0 ? 0 : arrayZ;

        if ( compare(world, x, y, z, multiBlock[arrayX][arrayY][arrayZ]) ) {

            Vec center = new Vec(x,y,z);
            Vec corner = new Vec(x-arrayX, y-arrayY, z-arrayZ);

            for (int rotation = 0; rotation < 4; rotation++) {

                Vec vec = corner.rotateY(center, rotation);
                if ( checkStructure(world, vec.x, vec.y, vec.z, rotation) ) {
                    return new Structure(this, vec.x, vec.y, vec.z, rotation, structureID);
                }

            }
        }

        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {

                    if ( compare(world, x, y, z, multiBlock[ix][iy][iz] ) ) {

                        Vec center = new Vec(x,y,z);
                        Vec corner = new Vec(x-ix, y-iy, z-iz);

                        for (int rotation = 0; rotation < 4; rotation++) {

                            Vec vec = corner.rotateY(center, rotation);
                            if ( checkStructure(world, vec.x, vec.y, vec.z, rotation) ) {
                                return new Structure(this, vec.x, vec.y, vec.z, rotation, structureID);
                            }

                        }
                    }

                }
            }
        }

        return new Structure();
    }

    public boolean checkStructure(World world, int x, int y, int z, int rotation) {

        for (int structureID = 0; structureID < multiBlocks.size(); structureID++) {
            if (checkStructure(world, x, y, z, rotation, structureID)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkStructure(World world, int x, int y, int z, int rotation, int structureID) {
        Object[][][] multiBlock = multiBlocks.get(structureID).getMultiBlock();

        Vec center = new Vec(x,y,z);

        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {
                    Vec current = (new Vec(x+ix,y+iy,z+iz)).rotateY(center, rotation);

                    if (!compareVec(world, current, multiBlock[ix][iy][iz], rotation)) {
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

    private boolean compareVec(World world, Vec vec, Object object, int rotation) {
        return compare(world, vec.x, vec.y, vec.z, object, rotation);
    }

    private boolean addStructure(Object[] objects, int xCap, int yCap, int zCap) {
        Object[][][] multiBlock = MultiBlockInit.initStructure(objects, xCap, yCap, zCap);

        boolean bool = false;
        for (Object[][] xMultiBlock : multiBlock) {
            for (Object[] yAMultiBlock : xMultiBlock) {
                for (Object zMultiBlock : yAMultiBlock) {
                    if (zMultiBlock != null) {
                        bool = true;
                        break;
                    }
                }
                if (bool) break;
            }
            if (bool) break;
        }

        if (bool) {
            multiBlocks.add(new StructureArray(multiBlock));
        }
        this.valid = valid || bool;

        return bool;
    }

    private static class StructureArray{

        private Object[][][] multiBlock;

        public StructureArray(Object[][][] multiBlock) {
            this.multiBlock = multiBlock;
        }

        public StructureArray setMultiBlock(Object[][][] structure) {
            multiBlock = structure;
            return this;
        }

        public Object[][][] getMultiBlock() {
            return multiBlock;
        }
    }

    /**
     * Instead of typing the same arguments for all the structures, this allows to store the arguments in a list and will function as if they were typed out normally.
     *
     * NOTE:
     *    MultiBlock( MultiBlock.StructureList("xxx/x x/xxx", MultiBlock.StructureList('x', Blocks.cobblestone)) )
     *              = MultiBlock("xxx/x x/xxx", 'x', Blocks.cobblestone)
     *    MultiBlock( "xxx/x x/xxx", 'x', '!', MultiBlock.StructureList(Blocks.cobblestone, Blocks.glass)
     *              = MultiBlock( "xxx/x x/xxx", 'x', '!', Blocks.cobblestone, Blocks.glass)
     *              = MultiBlock( "xxx/x x/xxx", Blocks.glass, 'x', '!', Blocks.cobblestone)
     *              = MultiBlock( "xxx/x x/xxxg", 'g', Blocks.glass, 'x', '!', Blocks.cobblestone)
     * */
    public static class StructureList {
        Object[] objects;

        public StructureList(Object... objects) {
            this.objects = objects;
        }

        public Object[] getObjects() {
            return objects;
        }
    }

    @Override
    public String toString() {
        String string = getClass().getName() + "@" + Integer.toHexString(hashCode()) + System.lineSeparator();
        for (int structureID = 0; structureID < multiBlocks.size(); structureID++) {
            Object[][][] multiBlock = multiBlocks.get(structureID).getMultiBlock();

            string += "Structure: " + structureID + System.lineSeparator() + "{";
            for (int ix = 0; ix < multiBlock.length; ix++) {
                string += System.lineSeparator() + "   {";
                for (int iy = 0; iy < multiBlock[0].length; iy++) {
                    string += System.lineSeparator() + "      {";
                    for (int iz = 0; iz < multiBlock[0][0].length; iz++) {
                        string += System.lineSeparator() + "         " + (multiBlock[ix][iy][iz] != null ? multiBlock[ix][iy][iz].toString() : "null") + ",";
                    }
                    string += System.lineSeparator() + "      },";
                }
                string += System.lineSeparator() + "   },";
            }
            string += System.lineSeparator() + "};" + System.lineSeparator();
        }
        return string;
    }
}
