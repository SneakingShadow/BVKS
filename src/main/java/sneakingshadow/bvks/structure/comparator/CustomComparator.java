package sneakingshadow.bvks.structure.comparator;

import net.minecraft.world.World;

/**
 * Created by SneakingShadow on 17.07.2016.
 *
 * Allows for custom comparing
 */
public abstract class CustomComparator {

    /**
     * @param rotation number of 90 degree rotations around center point of structure. Default 0.
     * */
    public abstract boolean compare(World world, int x, int y, int z, int rotation);

}
