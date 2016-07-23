package sneakingshadow.bvks.structure.modifer;

import net.minecraft.world.World;
import sneakingshadow.bvks.structure.MultiBlockInit;
import sneakingshadow.bvks.structure.ObjectMap;
import sneakingshadow.bvks.structure.Vec;

import java.util.HashMap;

/**
 * Created by SneakingShadow on 17.07.2016.
 */
public class CharacterModifier extends Modifier{

    public static Character notChar = '!';
    private static Characters specialChars = new Characters();

    private Char solidBlock = new Char('+') {
        @Override
        public boolean compare(World world, int x, int y, int z) {
            return world.getBlock(x,y,z).getMaterial().isSolid();
        }
    };
    private Char airBlock = new Char('_') {
        @Override
        public boolean compare(World world, int x, int y, int z) {
            return world.isAirBlock(x,y,z);
        }
    };
    private Char replaceableBlock = new Char('-') {
        @Override
        public boolean compare(World world, int x, int y, int z) {
            return world.getBlock(x,y,z).isReplaceable(world,x,y,z);
        }
    };
    private Char liquid = new Char('~') {
        @Override
        public boolean compare(World world, int x, int y, int z) {
            return world.getBlock(x,y,z).getMaterial().isLiquid();
        }
    };
    private Char opaque = new Char('*') {
        @Override
        public boolean compare(World world, int x, int y, int z) {
            return world.getBlock(x,y,z).getMaterial().isOpaque();
        }
    };

    public CharacterModifier() {
        specialChars.addChar(solidBlock);
        specialChars.addChar(airBlock);
        specialChars.addChar(replaceableBlock);
        specialChars.addChar(liquid);
        specialChars.addChar(opaque);
    }

    @Override
    public boolean compareMod(World world, int x, int y, int z, Object object, int rot, ObjectMap objectMap) {
        if (object instanceof Character && contains((Character)object)) {
            return specialChars.compare(world,x,y,z,(Character)object);
        }
        return false;
    }

    @Override
    public boolean structureMod(MultiBlockInit.ObjectArray multiBlock, Vec vec, Object object) {
        if (object instanceof Character) {
            if (contains((Character)object)) {
                Character obj = (Character) object;
                multiBlock.addToStructure(vec, obj);
            }
            return true;
        }
        return false;
    }

    @Override
    public int skipObjects(int i, Object[] objects, ObjectMap objectMap) {
        return skip(!contains((Character)objects[i]),i, objects, objectMap);
    }

    public static boolean contains(Character character) {
        return specialChars.contains(character);
    }

    private static abstract class Char {
        private Character character;

        public Char(Character character) {
            this.character = character;
        }

        public Character getCharacter() {
            return character;
        }

        public abstract boolean compare(World world, int x, int y, int z);
    }

    private static class Characters {

        HashMap<Character, Char> hashMap = new HashMap<Character, Char>();

        public void addChar(Char character) {
            hashMap.put(character.getCharacter(), character);
        }

        public boolean contains(Character character) {
            return hashMap.containsKey(character);
        }
        public boolean compare(World world, int x, int y, int z, Character object) {
            return hashMap.get(object).compare(world,x,y,z);
        }

    }

}
