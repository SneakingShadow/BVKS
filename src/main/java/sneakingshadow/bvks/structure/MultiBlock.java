package sneakingshadow.bvks.structure;

import net.minecraft.world.World;

import java.util.ArrayList;

public class MultiBlock {

    private ArrayList<StructureArray> multiBlocks = new ArrayList<StructureArray>();
    private ArrayList<ObjectMap> objectMaps = new ArrayList<ObjectMap>();
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
     *  "\\" = next layer up.
     *  if '!' is placed before an object, it will check that it's not that.
     *  '+' = full block
     *  '_' = air block
     *  '-' = replaceable block
     *  '~' = liquid
     *  '*' = opaque
     *  Characters in strings can represent objects
     *      Binding an object to a character:
     *          (character, object)
     *  OreDictionary is supported, but the strings must start and end with "@".
     *      If it comes after a character, both with and without "@" is supported
     *  ArrayList<Object> are allowed to specify multiple choices in one block-space, can include characters (both in string and as characters), but can't include "/".
     * */
    private MultiBlock(Object[] objects, int xCap, int yCap, int zCap) {
        if (objects.length == 0) {
            valid = false;
            return;
        }

        addStructure(objects, xCap, yCap, zCap);
    }

    public boolean addStructure(Object... objects) {
        return addStructure(objects,1,1,1);
    }

    public boolean addStructure(int xCap, int yCap, int zCap, Object... objects) {
        return addStructure(objects, xCap, yCap, zCap);
    }

    public Structure findStructure(World world, int x, int y, int z) {
        if (!valid)
            return new Structure();

        for (int structureID = 0; structureID < multiBlocks.size(); structureID++) {
            Structure structure = findStructure(world, x, y, z, structureID);
            if (structure.getValid()) {
                return structure;
            }
        }
        return new Structure();
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

    public Structure findStructure(World world, int x, int y, int z, int arrayX, int arrayY, int arrayZ, int structureID) {
        Object[][][] multiBlock = multiBlocks.get(structureID).getMultiBlock();
        ObjectMap objectMap = objectMaps.get(structureID);

        if (
                arrayX < 1 ||
                arrayY < 1 ||
                arrayZ < 1 ||
                arrayX > multiBlock.length ||
                arrayY > multiBlock[0].length ||
                arrayZ > multiBlock[0][0].length
                ) {
            return new Structure();
        }
        arrayX--; arrayY--; arrayZ--;

        if ( MultiBlockComparing.compare(world, x, y, z, multiBlock[arrayX][arrayY][arrayZ], objectMap) ) {

            Vec center = new Vec(x,y,z);
            Vec corner = new Vec(x-arrayX, y-arrayY, z-arrayZ);

            for (int rotation = 0; rotation < 4; rotation++) {

                Vec vec = corner.rotateY(center, rotation);

                if ( checkStructure(world, vec.x, vec.y, vec.z, rotation) ) {
                    return new Structure(this, vec.x, vec.y, vec.z, rotation, structureID);
                }

            }
        }

        return new Structure();
    }

    public Structure findStructure(World world, int x, int y, int z, int structureID) {
        Object[][][] multiBlock = multiBlocks.get(structureID).getMultiBlock();
        ObjectMap objectMap = objectMaps.get(structureID);


        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {

                    if ( MultiBlockComparing.compare(world, x, y, z, multiBlock[ix][iy][iz], objectMap) ) {

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
        ObjectMap objectMap = objectMaps.get(structureID);

        Vec center = new Vec(x,y,z);

        for (int ix = 0; ix < multiBlock.length; ix++) {
            for (int iy = 0; iy < multiBlock[ix].length; iy++) {
                for (int iz = 0; iz < multiBlock[ix][iy].length; iz++) {
                    Vec current = (new Vec(x+ix,y+iy,z+iz)).rotateY(center, rotation);

                    if (!compare(world, current, multiBlock[ix][iy][iz], rotation, objectMap)) {
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

    private boolean compare(World world, Vec vec, Object object, int rotation, ObjectMap objectMap) {
        return MultiBlockComparing.compare(world, vec.x, vec.y, vec.z, object, rotation, objectMap);
    }

    private boolean addStructure(Object[] objects, int xCap, int yCap, int zCap) {
        MultiBlockInit.ObjectAndMap objectAndMap = MultiBlockInit.initStructure(objects, xCap, yCap, zCap);
        Object[][][] multiBlock = objectAndMap.multiBlock;
        ObjectMap objectMap = objectAndMap.objectMap;

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
            objectMaps.add(objectMap);
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
        ArrayList<Object> objects = new ArrayList<Object>();

        public StructureList(Object... objects) {
            add(objects);
        }

        public Object[] getObjects() {
            return objects.toArray();
        }

        public void add(Object... objects) {
            for (Object object : objects) {
                this.objects.add(object);
            }
        }

        public String toString() {
            return getClass().getName() + ": " + objects.toString();
        }
    }

    @Override
    public String toString() {
        String string = super.toString() + System.lineSeparator();
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
