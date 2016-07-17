package sneakingshadow.bvks.structure;

import net.minecraft.world.World;

/**
 * Created by SneakingShadow on 17.07.2016.
 *
 * Allows for custom comparing
 */
public abstract class CustomComparator {

    public abstract boolean compare(World world, int x, int y, int z);

}
