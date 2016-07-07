package sneakingshadow.bvks.structure;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 07.07.2016.
 */
public class StructureUtil {

    public static String oreDictionary(String string) {
        return "@"+string;
    }

    public static ArrayList<Object> arrayList(Object... objects) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : objects) {
            arrayList.add(object);
        }

        return arrayList;
    }

    public static boolean compare(World world, int x, int y, int z, Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof Block && world.getBlock(x,y,z) == object){
            return true;
        }
        if (object instanceof Item && Item.getItemFromBlock( world.getBlock(x,y,z) ) == object ) {
            return true;
        }
        if (object instanceof ItemStack) {
            ItemStack itemStack = (ItemStack)object;
            if ( compare(world, x, y, z, itemStack.getItem()) &&
                    world.getBlockMetadata(x,y,z) == itemStack.getItemDamage()) {
                return true;
            }
        }
        if (object instanceof String) {
            ArrayList<ItemStack> arrayList = OreDictionary.getOres((String) object);
            for (ItemStack itemStack:arrayList){
                if ( OreDictionary.itemMatches(itemStack, new ItemStack( world.getBlock(x,y,z), 1, world.getBlockMetadata(x,y,z) ), false ) ) {
                    return true;
                }
            }
        }
        if (object instanceof ArrayList) {
            ArrayList list = (ArrayList) object;
            for (Object obj:list){
                if ( compare(world,x,y,z,obj) ) {
                    return true;
                }
            }
        }

        return false;
    }

}
