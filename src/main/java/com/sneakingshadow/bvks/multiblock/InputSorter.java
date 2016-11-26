package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.initializer.OperatorInitializer;
import com.sneakingshadow.bvks.multiblock.structureblock.SBlockArrayList;
import com.sneakingshadow.bvks.multiblock.structureblock.SBlockBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.SBlockOreDictionary;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.operator.Operator;
import com.sneakingshadow.bvks.multiblock.structureblock.special.SBlockNull;
import com.sneakingshadow.bvks.util.StringUtil;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.*;

class InputSorter {

    /**
     * Sorts all the inputs, and does the mapping.
     * */
    static ArrayList<Object> sortInput(Object[] objects) {
        HashMap<Character, StructureBlock> charMap = new HashMap<Character, StructureBlock>();
        HashMap<String, StructureBlock> stringMap = new HashMap<String, StructureBlock>();

        ArrayList<Object> arrayList = sortInput(objects, true, charMap, stringMap);
        arrayList = map(arrayList, charMap, stringMap);

        return arrayList;
    }

    static ArrayList<Object> sortInput(Object[] objects, boolean doMapping, HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        ArrayList<Object> arrayList = inputList(objects, new ArrayList<Object>());
        arrayList = brackets(arrayList);
        arrayList = arrayListSort(arrayList, charMap, stringMap);
        arrayList = oreDictionary(arrayList);
        arrayList = specialValues(arrayList);
        arrayList = operator(arrayList);

        //Allows arrayListSort to sort its content in this manner without conflicts.
        if (doMapping) {
            mapObjects(arrayList, charMap, stringMap);
        }
        arrayList = clearMappedAndInvalid(arrayList);
        arrayList = extractStrings(arrayList);

        return arrayList;
    }

    /**
     * Extracts input list
     * */
    private static ArrayList<Object> inputList(Object[] objects, ArrayList<Object> arrayList) {
        for (Object object : objects)
            if (object instanceof InputList)
                inputList(((ArrayList) object).toArray(), arrayList);
            else
                arrayList.add(object);

        return arrayList;
    }

    /**
     * Creates arrayLists from what is surrounded in brackets
     * */
    private static ArrayList<Object> brackets(ArrayList<Object> objects) {
        int bracketsNotClosed = 0;
        ArrayList<Object> bracketList = new ArrayList<Object>();
        ArrayList<Object> inputList = new ArrayList<Object>();

        for (Object object : objects) {

            if (object instanceof Character) {
                int num = bracketsNotClosed;

                if (BRACKET_START.equals(object))
                    bracketsNotClosed++;
                else if (BRACKET_END.equals(object))
                {
                    //Subtract one, unless lower, then set to 0.
                    bracketsNotClosed = bracketsNotClosed > 0 ? bracketsNotClosed-1 : 0;
                }

                if (bracketsNotClosed == num && bracketsNotClosed > 0)
                    bracketList.add(object);
                else
                    inputList.add(object);
            } else if (object instanceof String) {
                ArrayList<String> stringArray = StringUtil.splitString(
                        (String) object, new Character[] {BRACKET_START, BRACKET_END}
                );

                for (String string : stringArray) {
                    Character character = string.charAt(0);

                    int num = bracketsNotClosed;
                    boolean bool = false;

                    if (BRACKET_START.equals(character)) {
                        bracketsNotClosed++;
                        bool = true;
                    }
                    else if (BRACKET_END.equals(character))
                    {
                        //Subtract one, unless lower, then set to 0.
                        bracketsNotClosed = bracketsNotClosed > 0 ? bracketsNotClosed-1 : 0;
                        bool = true;
                    }

                    string = bool ? string.substring(1,string.length()) : string;
                    if (bracketsNotClosed == num && bracketsNotClosed > 0)
                        bracketList.add(string);
                    else
                        inputList.add(string);
                }
            } else
                if (bracketsNotClosed > 0)
                    bracketList.add(object);
                else
                    inputList.add(object);
        }

        return inputList;
    }

    /**
     * Sorts all arrayLists and turns them into StructureBlocks
     * */
    private static ArrayList<Object> arrayListSort(ArrayList<Object> objects, HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : objects)
            if (object instanceof ArrayList) {
                arrayList.add(
                        new SBlockArrayList(
                                sortInput( ((ArrayList) object).toArray(), false, charMap, stringMap)
                        )
                );
            } else
                arrayList.add(object);

        return arrayList;
    }

    /**
     * Turns OreDictionary strings into StructureBlocks
     * */
    private static ArrayList<Object> oreDictionary(ArrayList<Object> objects) {
        boolean nextIsOre = false;
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : objects) {
            if (object instanceof Character && ORE_DICTIONARY.equals(object)) {
                nextIsOre = true;
            } else if (object instanceof String) {
                String string_object = (String) object;

                if (nextIsOre)
                    arrayList.add(new SBlockOreDictionary(string_object));
                else {
                    ArrayList<String> stringList = StringUtil.splitString(string_object,ORE_DICTIONARY,true);

                    for (String string : stringList) {
                        if (ORE_DICTIONARY.equals(string.charAt(0))) {
                            if (string.length() > 1)
                                arrayList.add(new SBlockOreDictionary(string_object));
                        } else {
                            arrayList.add(string_object);
                        }
                    }
                }
            } else
                arrayList.add(object);
        }
        
        return arrayList;
    }

    /**
     * Turns special values into StructureBlocks
     * */
    private static ArrayList<Object> specialValues(ArrayList<Object> objects) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : objects) {
            if (object instanceof Item) {
                object = Block.getBlockFromItem((Item)object); //This will be handled by another if statement
                if (object == Blocks.air)
                    object = null;  //This will be handled by another if statement
            }

            if (object instanceof Block)
                arrayList.add(new SBlockBlock((Block)object));

            if (object instanceof ItemStack) {
                Block block = Block.getBlockFromItem(((ItemStack) object).getItem());
                if (block == Blocks.air)
                    object = null;  //This will be handled by another if statement.
                else
                    arrayList.add(new SBlockBlock(block, ((ItemStack) object).getItemDamage()));

            }

            if (object == null)
                arrayList.add(new SBlockNull());

            if (object instanceof String)
            {
                String string_object = (String)object;
                String string = "";

                for (int i = 0; i < string_object.length(); i++) {
                    if (MultiBlockLists.specialCharacterUsed(string_object.charAt(i))) {
                        arrayList.add(string);
                        string = "";
                        arrayList.add(MultiBlockLists.getSpecialCharacter(string_object.charAt(i)));
                    } else
                        string += string_object.charAt(i);
                }
            }
        }

        return arrayList;
    }

    /**
     * Turns operator values into Operators
     * */
    private static ArrayList<Object> operator(ArrayList<Object> arrayList) {
        ArrayList<OperatorInitializer> operatorInitializerList = MultiBlockLists.getOperatorList();

        for (OperatorInitializer operatorInitializer : operatorInitializerList){
            ArrayList<Integer> removedEntries = new ArrayList<Integer>();

            for (int i = 0; i < arrayList.size(); i++) {
                if (!removedEntries.contains(i)) {
                    if (operatorInitializer.isSpecialCharacter(arrayList.get(i))) {
                        Operator operator = operatorInitializer.getOperator();

                        ArrayList<Object> temp = removeEntries(arrayList, removedEntries);

                        if ( operator.valid( temp,i ) ) {
                            int[] ints = operator.takeOperands( temp, i );

                            for (int integer : ints)
                                removedEntries.add(integer);
                        }

                        arrayList.add(operator);
                    } else
                        arrayList.add(arrayList.get(i));
                }
            }

            arrayList = removeEntries(arrayList, removedEntries);
        }

        return arrayList;
    }

    //Used by operator to remove specified entries
    private static ArrayList<Object> removeEntries(ArrayList<Object> inputList, ArrayList<Integer> removedEntries) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (int i = 0; i < inputList.size(); i++)
            if (!removedEntries.contains(i))
                arrayList.add(inputList.get(i));

        return arrayList;
    }

    /**
     * Maps all possible strings.
     * Maps all possible characters.
     * Note: Special characters have already been taken care of.
     * */
    private static void mapObjects(ArrayList<Object> inputList, HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        for (int i = 0; i < inputList.size(); i++) {
            Object object = inputList.get(i);

            if (object instanceof Character) {
                Character character = (Character)object;

                if (STRING_OBJECT.equals(character) && !NEXT_LINE.equals(object) && !NEXT_LEVEL.equals(object)) {
                    if (inputList.get(i+1) instanceof String && inputList.get(i+2) instanceof StructureBlock)
                        stringMap.put(STRING_OBJECT + (String)inputList.get(++i), (StructureBlock) inputList.get(++i));

                } else if (inputList.get(i+1) instanceof StructureBlock)
                    charMap.put(character, (StructureBlock) inputList.get(++i));

            }
        }
    }

    /**
     * Clears the arraylist of everything that has been/would be mapped, and that is generally invalid.
     * */
    private static ArrayList<Object> clearMappedAndInvalid(ArrayList<Object> inputList) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (int i = 0; i < inputList.size(); i++) {
            Object object = inputList.get(i);

            if (object instanceof Character && !NEXT_LINE.equals(object) && !NEXT_LEVEL.equals(object)) {
                Character character = (Character)object;

                if (STRING_OBJECT.equals(character)) {
                    if (inputList.get(i+1) instanceof String && inputList.get(i+2) instanceof StructureBlock)
                        i+=2;
                } else if (inputList.get(i+1) instanceof StructureBlock)
                    ++i;
            } else
                arrayList.add(object);
        }

        return arrayList;
    }

    /**
     * Extracts strings into characters and string-objects.
     * */
    private static ArrayList<Object> extractStrings(ArrayList<Object> inputList) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : inputList)
            if (object instanceof String) {
                ArrayList<String> strings = StringUtil.splitString((String)object, STRING_OBJECT, true);

                for (String string : strings)
                    if(!string.isEmpty())
                        if(STRING_OBJECT.equals(string.charAt(0)))
                            if (string.length() > 1)
                                arrayList.add(string);
                        else
                            for (int i = 0; i < string.length(); i++)
                                arrayList.add(string.charAt(i));
            } else
                arrayList.add(object);

        return arrayList;
    }

    /**
     * Extracts strings into characters and string-objects.
     * */
    private static ArrayList<Object> map(ArrayList<Object> inputList, HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : inputList) {
            if (object instanceof StructureBlock) {
                arrayList.add(((StructureBlock) object).map(charMap, stringMap));
            } else if (object instanceof Character && !NEXT_LINE.equals(object) && !NEXT_LEVEL.equals(object)) {
                StructureBlock structureBlock = charMap.get(object);
                arrayList.add(
                    structureBlock != null ?
                            structureBlock.map(charMap, stringMap) : new SBlockNull()
                );
            } else if (object instanceof String) {
                StructureBlock structureBlock = stringMap.get(object);
                arrayList.add(
                        structureBlock != null ?
                                structureBlock.map(charMap, stringMap) : new SBlockNull()
                );
            } else
                arrayList.add(object);
        }

        return arrayList;
    }

}
