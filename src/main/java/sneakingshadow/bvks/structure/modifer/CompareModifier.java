package sneakingshadow.bvks.structure.modifer;

import net.minecraft.world.World;
import sneakingshadow.bvks.structure.ObjectMap;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public interface CompareModifier {

    /**
     * @param rot = 90 degree rotation around center point. Default 0.
     * @param objectMap*/
    boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap);

}