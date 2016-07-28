package sneakingshadow.bvks.structure.comparator;

import net.minecraft.block.BlockStairs;
import net.minecraft.world.World;
import sneakingshadow.bvks.structure.ObjectMap;

import java.util.ArrayList;

public class StairComparator extends RotationComparator {

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
    public StairComparator() {
        setMetaValues();
    }
    /**
     * Has to be given direction arguments, if not it'll always return false.
     * */
    public StairComparator(ArrayList<Object> arrayList, int... directions) {
        super(arrayList, directions);
        setMetaValues();
    }

    public void setMetaValues() {
        this.setMetaValues( new int[] {
                NORTH,
                EAST,
                SOUTH,
                WEST,
        } );
    }

    /**
     * Has to be given direction arguments, if not it'll always return false.
     * */
    public StairComparator(Object... objects) {
        super(objects);
    }

    public boolean emptyArgList(World world, int x, int y, int z, int rotationX, int rotationY, int rotationZ, ObjectMap objectMap) {
        return world.getBlock(x,y,z) instanceof BlockStairs;
    }

}
