package sneakingshadow.bvks.structure.modifer;

import net.minecraft.world.World;
import sneakingshadow.bvks.structure.ObjectMap;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public interface CompareModifier {

    /**
     * @param rotationX
     * @param rotationZ
     * @param objectMap*/
    boolean compareMod(World world, int x, int y, int z, Object object, int rotationX, int rotationY, int rotationZ, ObjectMap objectMap);

}