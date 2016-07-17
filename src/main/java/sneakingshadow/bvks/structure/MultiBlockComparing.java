package sneakingshadow.bvks.structure;

import net.minecraft.world.World;
import sneakingshadow.bvks.structure.modifer.CompareModifier;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public class MultiBlockComparing {

    private static ArrayList<CompareModifier> modifiers = new ArrayList<CompareModifier>();

    public static void addModifier(CompareModifier modifier) {
        modifiers.add(modifier);
    }

    /**
     * Used by MultiBlock to compare objects to block in world.
     * */
    public static boolean compare(World world, int x, int y, int z, Object object) {
        for (CompareModifier mod : modifiers) {
            if ( mod.compareMod(world, x,y,z, object) ) {
                return true;
            }
        }
        return false;
    }

}
