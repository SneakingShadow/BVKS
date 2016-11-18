package com.sneakingshadow.bvks.structure;

import com.sneakingshadow.bvks.structure.modifer.CompareModifier;
import net.minecraft.world.World;

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
        return compare(world, x, y, z, object, 0, 0, 0);
    }

    /**
     * Used by MultiBlock to compare objects to block in world.
     * */
    public static boolean compare(World world, int x, int y, int z, Object object, int rotationX, int rotationY, int rotationZ) {
        return compare(world, x, y, z, object, rotationX, rotationY, rotationZ, new ObjectMap());
    }

    /**
     * Used by MultiBlock to compare objects to block in world.
     * */
    public static boolean compare(World world, int x, int y, int z, Object object, ObjectMap objectMap) {
        return compare(world, x, y, z, object, 0, 0, 0, objectMap);
    }

    /**
     * Used by MultiBlock to compare objects to block in world.
     * */
    public static boolean compare(World world, int x, int y, int z, Object object, int rotationX, int rotationY, int rotationZ, ObjectMap objectMap) {
        for (CompareModifier mod : modifiers) {
            if ( mod.compareMod(world, x,y,z, object, rotationX, rotationY, rotationZ, objectMap) ) {
                return true;
            }
        }
        return false;
    }

}
