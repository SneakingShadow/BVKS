package sneakingshadow.bvks.structure;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 07.07.2016.
 */
public class MultiBlockUtil {

    public static char not = '!';
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
     * Simply adds @ to the start of string
     * */
    public static String oreDict(String string) {
        return "@"+string;
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

}
