package sneakingshadow.bvks.structure.modifer;

import net.minecraft.world.World;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public interface CompareModifier {

    boolean compareMod(World world, int x, int y, int z, Object object);

}