package sneakingshadow.bvks.structure.comparator;

import net.minecraft.block.BlockStairs;
import net.minecraft.world.World;
import sneakingshadow.bvks.structure.MultiBlockComparing;
import sneakingshadow.bvks.structure.ObjectMap;

import java.util.ArrayList;

public class StairComparator extends CustomComparator {

    private ArrayList<Integer> directions = new ArrayList<Integer>();

    /*
    * The direction the thinnest part of the stair faces.
    *
    * Direction is only based on direction when the block isn't rotated.
    *
    *    CHAR_NORTH_WEST     CHAR_NORTH     CHAR_NORTH_EAST
    *       CHAR_WEST                     CHAR_EAST
    *    CHAR_SOUTH_WEST     CHAR_SOUTH     CHAR_SOUTH_EAST
    *
    * */
    public static final int NORTH = 2;
    public static final int EAST = 1;
    public static final int SOUTH = 3;
    public static final int WEST = 0;
    // Corner stairs
    public static final int[] NORTH_EAST = {NORTH, EAST};
    public static final int[] NORTH_WEST = {NORTH, WEST};
    public static final int[] SOUTH_EAST = {SOUTH, EAST};
    public static final int[] SOUTH_WEST = {SOUTH, WEST};

    /**
     * Anything that's instanceof BlockStairs
     * Has to be given direction arguments, if not it'll always return false.
     * */
    public StairComparator() {}
    /**
     * Has to be given direction arguments, if not it'll always return false.
     * */
    public StairComparator(ArrayList<Object> arrayList, int... directions) {
        super(arrayList);
        for (int num : directions) {
            this.directions.add(num);
        }
    }

    /**
     * Has to be given direction arguments, if not it'll always return false.
     * */
    public StairComparator(Object... objects) {
        super(objects);
    }

    public StairComparator addDirections(int... directions) {
        for (int num : directions) {
            this.directions.add(num);
        }
        return this;
    }

    /**
     * @param world world
     * @param x x
     * @param y y
     * @param z z
     * @param rotation number of 90 degree rotations around center point of structure. Default 0.
     * @param argumentList list of arguments given to the comparator, which has its 'character-objects' replaced.
     * @param objectMap Character, Object hashmap in case its needed for comparing.
     */
    @Override
    public boolean compare(World world, int x, int y, int z, int rotation, ArrayList<Object> argumentList, ObjectMap objectMap) {
        boolean bool = argumentList.isEmpty() && world.getBlock(x,y,z) instanceof BlockStairs;
        for (int i = 0; !bool && i < argumentList.size(); i++) {
            bool = MultiBlockComparing.compare(world, x, y, z, argumentList.get(i), rotation, objectMap);
        }
        if (bool) {
            int num = rotate(world.getBlockMetadata(x,y,z), rotation);
            for (int dir : directions) {
                if (num == dir) {
                    return true;
                }
            }
        }
        return false;
    }

    public StairComparator setNorthMetavalue (int num) {
        north = num;
        return this;
    }

    public StairComparator setEastMetavalue (int num) {
        east = num;
        return this;
    }

    public StairComparator setSouthMetavalue (int num) {
        south = num;
        return this;
    }

    public StairComparator setWestMetavalue (int num) {
        west = num;
        return this;
    }

    public StairComparator setMetavalue (int[] numbers) {
        if (numbers.length >= 4) {
            north = numbers[0];
            east = numbers[1];
            south = numbers[2];
            west = numbers[3];
        }
        return this;
    }

    private int north = NORTH;
    private int east  = EAST;
    private int south = SOUTH;
    private int west  = WEST;
    private int rotate(int meta, int rot) {
        for (int i = 0; i < rot; i++) {
            meta = meta == north ? east :
                    meta == east ? south :
                            meta == south ? west :
                                    north;
        }
        return meta;
    }
}
