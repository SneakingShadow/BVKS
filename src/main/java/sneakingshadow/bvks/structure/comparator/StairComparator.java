package sneakingshadow.bvks.structure.comparator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.world.World;

import java.util.ArrayList;

public class StairComparator extends CustomComparator {

    Block block = null;
    ArrayList<Integer> directions = new ArrayList<Integer>();

    /*
    * The direction the thinnest part of the stair faces.
    *
    * Direction is only based on direction when the block isn't rotated.
    *
    *    NORTH_WEST     NORTH     NORTH_EAST
    *       WEST                     EAST
    *    SOUTH_WEST     SOUTH     SOUTH_EAST
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
    public StairComparator(int... directions) {
        this(null, directions);
    }
    /**
     * Has to be given direction arguments, if not it'll always return false.
     * */
    public StairComparator(Block block, int... directions) {
        this.block = block;
        for (int num : directions) {
            this.directions.add(num);
        }
    }

    /**
     * @param world
     * @param x
     * @param y
     * @param z
     * @param rotation number of 90 degree rotations around center point of structure. Default 0.
     */
    @Override
    public boolean compare(World world, int x, int y, int z, int rotation) {
        if (block == null ? world.getBlock(x,y,z) instanceof BlockStairs : world.getBlock(x,y,z) == block) {
            int num = rotate(world.getBlockMetadata(x,y,z), rotation);
            for (int dir : directions) {
                if (num == dir) {
                    return true;
                }
            }
        }
        return false;
    }

    private int rotate(int meta, int rot) {
        for (int i = 0; i < rot; i++) {
            meta = meta == 2 ? 1 :
                    meta == 1 ? 3 :
                            meta == 3 ? 0 :
                                    2;
        }
        return meta;
    }
}
