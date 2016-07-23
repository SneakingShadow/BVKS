package sneakingshadow.bvks.structure;

import sneakingshadow.bvks.structure.modifer.CharacterModifier;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 07.07.2016.
 */
public class MultiBlockUtil {

    public static char not = CharacterModifier.notChar;
    public static char solidBlock = '+';
    public static char airBlock = '_';
    public static char replaceableBlock = '-';
    public static char liquid = '~';
    public static char opaque = '*';
    public static ArrayList<Object> transparent = not(opaque);

    public static ArrayList<Object> not(Object object) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(not);
        arrayList.add(object);
        return arrayList;
    }

    /**
     * Simply adds @ to the start and end of string
     * */
    public static String oreDict(String string) {
        return "@"+string+"@";
    }

    /**
     * Simply adds ' to the start and end of the string
     * */
    public static String stringObject(String string) {
        return "'"+string+"'";
    }

    /**
     * Simply takes all the objects given and adds them to an arraylist.
     * */
    public static ArrayList<Object> arrayList(Object... objects) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : objects) {
            arrayList.add(object);
        }

        return arrayList;
    }

    public static MultiBlock.StructureList structureList(Object... objects) {
        return new MultiBlock.StructureList(objects);
    }

    /**
     * Makes strings for structures readable, but non usable.
     * */
    public static String readableStructureString(String input) {
        String string = "";
        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            string += character;
            if (character == '/') {
                string += System.lineSeparator();
            } else if (character == '\\') {
                string += System.lineSeparator() + System.lineSeparator();
            }
        }
        return string;
    }
}
