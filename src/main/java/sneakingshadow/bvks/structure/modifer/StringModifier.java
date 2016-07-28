package sneakingshadow.bvks.structure.modifer;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import sneakingshadow.bvks.structure.MultiBlockInit;
import sneakingshadow.bvks.structure.ObjectMap;
import sneakingshadow.bvks.structure.Vec;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 23.07.2016.
 */
public class StringModifier extends Modifier {

    @Override
    public boolean structureMod(MultiBlockInit.ObjectArray multiBlock, Vec vec, Object object) {
        if (object instanceof String) {
            String string = (String)object;
            if (!string.isEmpty()) {
                if (string.charAt(0)=='#') {
                    return true;
                }
                for (int j = 0; j < string.length(); j++) {
                    Character character = string.charAt(j);
                    if (character == ' ') {
                        multiBlock.addToStructure(vec, null);
                    } else if (character == '@') {
                        multiBlock.addToStructure(vec, "@"+ string.substring(1+j++,j=nextInstance(string,j,'@')) +"@");
                    } else if (character == '\'') {
                        multiBlock.addToStructure(vec, "'"+ string.substring(1+j++,j=nextInstance(string,j,'\'')) +"'");
                    } else if (character == '/') {
                        vec.x = 0;
                        vec.z++;
                    } else if (character == '\\' ){
                        vec.x = 0;
                        vec.y++;
                        vec.z = 0;
                    } else {
                        multiBlock.addToStructure(vec, character);
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int skipObjects(int i, Object[] objects, ObjectMap objectMap) {
        return skip(((String)objects[i]).charAt(0) == '#',i, objects, objectMap);
    }

    @Override
    public boolean compareMod(World world, int x, int y, int z, Object object, int rotationX, int rotationY, int rotationZ, ObjectMap objectMap) {
        if (object instanceof String ) {
            String string = (String) object;
            if (!string.isEmpty()) {
                ArrayList<ItemStack> itemList = OreDictionary.getOres(string.substring(1, string.length() - 1));
                for (ItemStack itemStack : itemList) {
                    if (OreDictionary.itemMatches(itemStack, new ItemStack(world.getBlock(x, y, z), 1, world.getBlockMetadata(x, y, z)), false)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int nextInstance(String string, int i, Character character) {
        for (; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                return i;
            }
        }
        return string.length()-1;
    }

}
