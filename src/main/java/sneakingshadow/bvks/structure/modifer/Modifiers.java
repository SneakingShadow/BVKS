package sneakingshadow.bvks.structure.modifer;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.structure.MultiBlockComparing;
import sneakingshadow.bvks.structure.MultiBlockInit;
import sneakingshadow.bvks.structure.ObjectMap;
import sneakingshadow.bvks.structure.Vec;
import sneakingshadow.bvks.structure.comparator.CustomComparator;

import java.util.ArrayList;

import static sneakingshadow.bvks.structure.MultiBlockComparing.compare;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public class Modifiers {

    private static CompareModifier nullMod = new CompareModifier() {
        @Override
        public boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap) {
            return object == null;
        }
    };
    private static CompareModifier blockMod = new CompareModifier() {
        @Override
        public boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap) {
            return object instanceof Block &&
                    world.getBlock(x,y,z) == object;
        }
    };
    private static CompareModifier itemMod = new CompareModifier() {
        @Override
        public boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap) {
            return object instanceof Item &&
                    Item.getItemFromBlock( world.getBlock(x,y,z) ) == object ;
        }
    };
    private static CompareModifier itemStackMod = new CompareModifier() {
        @Override
        public boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap) {
            return object instanceof ItemStack &&
                    Item.getItemFromBlock(world.getBlock(x,y,z)) == ((ItemStack)object).getItem() &&
                    world.getBlockMetadata(x,y,z) == ((ItemStack)object).getItemDamage();
        }
    };
    private static CompareModifier arrayListMod = new CompareModifier() {
        @Override
        public boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap) {
            if (object instanceof ArrayList) {
                ArrayList list = (ArrayList) object;
                boolean bool = true;
                for (Object obj:list){
                    if (obj instanceof Character && ((Character)obj) == CharacterModifier.notChar) {
                        bool = false;
                    } else if ( bool == compare(world,x,y,z,obj, rot, objectMap) ) {
                        return true;
                    } else {
                        bool = true;
                    }
                }
            }
            return false;
        }
    };
    private static CompareModifier comparatorMod = new CompareModifier() {
        @Override
        public boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap) {
            return object instanceof CustomComparator && ((CustomComparator)object).compare(world,x,y,z,rot, objectMap);
        }
    };
    private static StructureModifier objectMod = new StructureModifier() {
        @Override
        public boolean structureMod(MultiBlockInit.ObjectArray multiBlock, Vec vec, Object object) {
            multiBlock.addToStructure(vec, object);
            return true;
        }
    };
    private static Modifier stringMod = new StringModifier();
    private static Modifier charMod = new CharacterModifier();

    public static void init() {
        MultiBlockComparing.addModifier(nullMod);
        MultiBlockComparing.addModifier(blockMod);
        MultiBlockComparing.addModifier(itemMod);
        MultiBlockComparing.addModifier(itemStackMod);
        MultiBlockComparing.addModifier(stringMod);
        MultiBlockComparing.addModifier(charMod);
        MultiBlockComparing.addModifier(arrayListMod);
        MultiBlockComparing.addModifier(comparatorMod);
        MultiBlockInit.addModifier(charMod);
        MultiBlockInit.addModifier(stringMod);
        MultiBlockInit.addModifier(objectMod);
    }

}
