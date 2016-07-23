package sneakingshadow.bvks.structure.comparator;

import net.minecraft.world.World;
import sneakingshadow.bvks.structure.ObjectMap;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 17.07.2016.
 *
 * Allows for custom comparing
 */
public abstract class CustomComparator {

    /**
     * @param rotation number of 90 degree rotations around center point of structure. Default 0.
     * @param argumentList
     * @param objectMap */
    public abstract boolean compare(World world, int x, int y, int z, int rotation, ArrayList<Object> argumentList, ObjectMap objectMap);

    public boolean compare(World world, int x, int y, int z, int rotation, ObjectMap objectMap) {
        return compare(world, x, y, z, rotation, objectMap.replaceObjects(argumentList), objectMap);
    }

    /**
     * Arguments given to the comparator.
     * Note: The multiblock/structure initialization will replace chars representing objects.
     * */
    protected ArrayList<Object> argumentList = new ArrayList<Object>();

    public CustomComparator(ArrayList<Object> arrayList) {
        argumentList = arrayList;
    }

    public CustomComparator(Object... objects) {
        for (Object object : objects) {
            argumentList.add(object);
        }
    }
}
