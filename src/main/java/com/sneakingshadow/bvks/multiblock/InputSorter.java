package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.SBlockArrayList;
import com.sneakingshadow.bvks.multiblock.structureblock.SBlockOreDictionary;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.special.SBlockNull;
import com.sneakingshadow.bvks.util.ArrayListHelper;

import java.util.ArrayList;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.*;

class InputSorter {

    static ArrayList<Object> sortList(Object[] objects) {
        ArrayList<Object> arrayList = inputList(objects, new ArrayList<Object>());
        arrayList = brackets(arrayList.toArray(), new ArrayList<Object>());
        arrayList = arrayListSort(arrayList.toArray(), new ArrayList<Object>());
        arrayList = oreDictionary(arrayList.toArray(), new ArrayList<Object>());
        arrayList = specialCharacter(arrayList.toArray(), new ArrayList<Object>());

        return arrayList;
    }

    private static ArrayList<Object> inputList(Object[] objects, ArrayList<Object> arrayList) {
        for (Object object : objects)
            if (object instanceof InputList)
                inputList(ArrayListHelper.toArray(object), arrayList);
            else
                arrayList.add(object);

        return arrayList;
    }

    private static ArrayList<Object> brackets(Object[] objects, ArrayList<Object> inputList) {
        int bracketsNotClosed = 0;
        ArrayList<Object> bracketList = new ArrayList<Object>();

        for (Object object : objects) {
            if (object instanceof Character) {
                int num = bracketsNotClosed;
                bracketsNotClosed = characterBracket((Character) object, bracketsNotClosed);

                addToList(object, bracketsNotClosed == num && bracketsNotClosed > 0, bracketList, inputList);
            } else if (object instanceof String) {
                String string = (String) object;
                String string_output = "";

                for (int j = 0; j < string.length(); j++) {
                    int num = bracketsNotClosed;
                    bracketsNotClosed = characterBracket(string.charAt(j), bracketsNotClosed);

                    if (bracketsNotClosed == num && bracketsNotClosed > 0)
                        bracketList.add(object);
                    else
                        string_output += string.charAt(j);
                }

                if (!string_output.isEmpty())
                    addToList(string_output, bracketsNotClosed > 0, bracketList, inputList);
            } else
                addToList(object, bracketsNotClosed > 0, bracketList, inputList);
        }

        return inputList;
    }

    //Used for brackets
    private static int characterBracket(Character character, int bracketsNotClosed) {
        if (character.equals(BRACKET_START))
            bracketsNotClosed++;
        else if (character.equals(BRACKET_END))
        {
            //Subtract one, unless lower, then set to 0.
            bracketsNotClosed = bracketsNotClosed > 0 ? bracketsNotClosed-1 : 0;
        }
        return bracketsNotClosed;
    }

    private static ArrayList<Object> arrayListSort(Object[] objects, ArrayList<Object> arrayList) {
        for (Object object : objects)
            if (object instanceof ArrayList) {
                arrayList.add(
                        new SBlockArrayList(
                                sortList( ArrayListHelper.toArray(object) )
                        )
                );
            } else
                arrayList.add(object);

        return arrayList;
    }

    private static ArrayList<Object> oreDictionary(Object[] objects, ArrayList<Object> arrayList) {
        boolean nextIsOre = false;

        for (Object object : objects) {
            if (object instanceof Character && ORE_DICTIONARY.equals(object)) {
                nextIsOre = true;
            } else if (object instanceof String) {
                String string_object = (String) object;

                if (nextIsOre)
                    arrayList.add(new SBlockOreDictionary(string_object));
                else {
                    String string = "";
                    boolean foundOreCharacter = false;
                    String ore_name = "";

                    for (int i = 0; i < string_object.length(); i++) {
                        Character character = string_object.charAt(i);

                        if (ORE_DICTIONARY.equals(character)) {
                            if (foundOreCharacter) {
                                foundOreCharacter = false;
                                arrayList.add(new SBlockOreDictionary(ore_name));
                                ore_name = "";
                            } else {
                                foundOreCharacter = true;
                                arrayList.add(string);
                                string = "";
                            }
                        } else if (foundOreCharacter)
                            ore_name += character;
                        else
                            string += character;
                    }
                }
            } else
                arrayList.add(object);
        }
        
        return arrayList;
    }

    private static ArrayList<Object> specialCharacter(Object[] objects, ArrayList<Object> arrayList) {
        for (Object object : objects) {
            if (object == null)
                arrayList.add(new SBlockNull());
            else {
                StructureBlock structureBlock = MultiBlockLists.getSpecialValue(object);
                if (structureBlock != null)
                    arrayList.add(structureBlock);
            }
        }

        return arrayList;
    }

    private static ArrayList<Object> operator(Object[] objects, ArrayList<Object> arrayList) {
        return arrayList;
    }

    //   private static ArrayList<Object> List(Object[] objects, ArrayList<Object> arrayList) {}



    private static void addToList(Object object, boolean bool, ArrayList<Object> true_list, ArrayList<Object> false_list) {
        if (bool)
            true_list.add(object);
        else
            false_list.add(object);
    }

}
