package sneakingshadow.bvks.structure.comparator;

import net.minecraft.world.World;
import sneakingshadow.bvks.structure.MultiBlockComparing;
import sneakingshadow.bvks.structure.ObjectMap;

import java.util.ArrayList;

public class RotationComparator extends CustomComparator {

    public ArrayList<Integer> directions = new ArrayList<Integer>();

    public boolean emptyArgList(World world, int x, int y, int z, int rotationX, int rotationY, int rotationZ, ObjectMap objectMap) {
        return false;
    }

    public boolean compareArgument(World world, int x, int y, int z, int rotationX, int rotationY, int rotationZ, ArrayList<Object> argumentList, ObjectMap objectMap, int i) {
        return MultiBlockComparing.compare(world, x, y, z, argumentList.get(i), rotationX, rotationY, rotationZ, objectMap);
    }

    /**
     * @param world world
     * @param x x
     * @param y y
     * @param z z
     * @param rotationX
     * @param rotationY number of 90 degree rotations around center point of structure. Default 0.
     * @param rotationZ
     * @param argumentList list of arguments given to the comparator, which has its 'character-objects' replaced.
     * @param objectMap Character, Object hashmap in case its needed for comparing.
     */
    @Override
    public boolean compare(World world, int x, int y, int z, int rotationX, int rotationY, int rotationZ, ArrayList<Object> argumentList, ObjectMap objectMap) {
        boolean bool = argumentList.isEmpty() && emptyArgList(world, x, y, z, rotationX, rotationY, rotationZ, objectMap);
        for (int i = 0, j = argumentList.size(); !bool && i < j; i++) {
            bool = compareArgument(world, x, y, z, rotationX, rotationY, rotationZ, argumentList, objectMap, i);
        }
        if (bool) {
            int num = rotate(world.getBlockMetadata(x,y,z), rotationY);
            for (int dir : directions) {
                if (num == dir) {
                    return true;
                }
            }
        }
        return false;
    }

    public RotationComparator addDirections(int... directions) {
        for (int num : directions) {
            this.directions.add(num);
        }
        return this;
    }

    public RotationComparator setNorthMetavalue (int num) {
        north = num;
        return this;
    }
    public RotationComparator setEastMetavalue (int num) {
        east = num;
        return this;
    }
    public RotationComparator setSouthMetavalue (int num) {
        south = num;
        return this;
    }
    public RotationComparator setWestMetavalue (int num) {
        west = num;
        return this;
    }
    /**
     * Order: North, east, south, west
     * */
    public RotationComparator setMetaValues (int[] numbers) {
        if (numbers.length >= 4) {
            north = numbers[0];
            east = numbers[1];
            south = numbers[2];
            west = numbers[3];
        }
        return this;
    }

    private int north = 0;
    private int east  = 1;
    private int south = 2;
    private int west  = 3;
    public final int rotate(int meta, int rotationY) {
        for (int i = 0; i < rotationY; i++) {
            meta = meta == north ? east :
                    meta == east ? south :
                            meta == south ? west :
                                    north;
        }
        return meta;
    }

    public RotationComparator(ArrayList<Object> arrayList, int... directions) {
        super(arrayList);
        for (int num : directions) {
            this.directions.add(num);
        }
    }

    public RotationComparator(Object... objects) {
        super(objects);
    }


}
