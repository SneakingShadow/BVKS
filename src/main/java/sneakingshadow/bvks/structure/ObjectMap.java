package sneakingshadow.bvks.structure;

import sneakingshadow.bvks.structure.modifer.CharacterModifier;
import sneakingshadow.bvks.structure.modifer.StringModifier;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SneakingShadow on 23.07.2016.
 */
public class ObjectMap {

    private HashMap<Character,Object> charMap = new HashMap<Character, Object>();
    private HashMap<String,Object> stringMap = new HashMap<String, Object>();

    public ObjectMap put(Object key, Object object) {
        if (key instanceof Character) {
            put((Character)key, object);
            return this;
        }
        if (key instanceof String) {
            put((String)key, object);
            return this;
        }
        return this;
    }

    public ObjectMap put(Character character, Object object) {
        charMap.put(character, object);
        return this;
    }

    public ObjectMap put(String string, Object object) {
        if (string.charAt(0) == '#')
            string = string.substring(1);
        stringMap.put(string,object);
        return this;
    }

    public boolean containsKey(Object object) {
        return object instanceof Character && containsKey((Character)object) ||
                object instanceof String && containsKey((String)object);
    }

    public boolean containsKey(Character character) {
        return charMap.containsKey(character);
    }

    public boolean containsKey(String string) {
        return stringMap.containsKey(string);
    }

    //TODO implement stringMap
    public Object replaceObject(Object object) {
        if (object instanceof Character) {
            Character character = (Character) object;
            if (charMap.containsKey(character)) {
                object = charMap.get(character);
            } else if (!CharacterModifier.contains(character)) {
                object = null;
            }
        }

        if (object instanceof String && !((String)object).isEmpty()) {
            String string = (String)object;

            if (!string.isEmpty() && !(
                            string.charAt(0) == '@' && string.charAt(string.length()-1) == '@'
                        )
                    ) {
                ArrayList<Object> arrayList = new ArrayList<Object>();
                for (int j = 0; j < string.length(); j++) {
                    Character character = string.charAt(j);
                    if (character == ' ') {
                        arrayList.add(null);
                    } else if (character == '@') {
                        arrayList.add(
                                "@"+ string.substring(1+j++,j=StringModifier.nextInstance(string,j,'@')) +"@"
                        );
                    } else if (character == '\'') {
                        arrayList.add(
                                stringMap.get(
                                        string.substring(
                                                1+j++,j=StringModifier.nextInstance(string,j,'\'')
                                        )
                                )
                        );
                    } else if (charMap.containsKey(character) || CharacterModifier.contains(character)) {
                        arrayList.add(character);
                    }
                }

                if (arrayList.isEmpty()) {
                    object = null;
                } else if (arrayList.size() == 1) {
                    object = replaceObject(arrayList.get(0));
                } else {
                    object = arrayList;
                }
            }
        }

        if (object instanceof ArrayList) {
            object = replaceObjects((ArrayList) object);
        }
        return object;
    }

    public ArrayList<Object> replaceObjects(ArrayList arrayList) {
        ArrayList<Object> objectList = new ArrayList<Object>();
        for (Object object : arrayList) {
            objectList.add(replaceObject(object));
        }
        return objectList;
    }

}