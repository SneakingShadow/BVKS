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

    public abstract boolean compare(World world, int x, int y, int z, int rotationX, int rotationY, int rotationZ, ArrayList<Object> argumentList, ObjectMap objectMap);

    public boolean compare(World world, int x, int y, int z, int rotationX, int rotationY, int rotationZ, ObjectMap objectMap) {
        return compare(world, x, y, z, rotationX, rotationY, rotationZ, objectMap.replaceObjects(argumentList), objectMap);
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
