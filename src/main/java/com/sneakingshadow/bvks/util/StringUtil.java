package com.sneakingshadow.bvks.util;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 25.11.2016.
 */
public class StringUtil {

    /**
     * Splits the string wherever character is found.
     * Strings that were encased in character would have that character at the start.
     *
     * Example
     *     splitString("String 1@String 2@ String 3", '@') -> ArrayList<String> "String 1", "@String 2", " String 3" </String>
     * */
    private static ArrayList<String> splitString(String string, Character character) {
        ArrayList<String> arrayList = new ArrayList<String>();

        string += character;
        int start = 0;
        int end = string.indexOf(character);
        while (end != -1) {
            String string_object = string.substring(start, end);

            if (!string_object.isEmpty())
                arrayList.add( string_object );

            start = end;
            if (character.equals(string_object.charAt(0))) {
                start++;
            }
            end = string.indexOf(character, end+1);
        }

        return arrayList;
    }

}
