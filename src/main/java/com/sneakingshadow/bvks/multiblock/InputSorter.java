package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.SBlockArrayList;
import com.sneakingshadow.bvks.multiblock.structureblock.SBlockOreDictionary;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.operator.Operator;
import com.sneakingshadow.bvks.multiblock.structureblock.special.SBlockNull;
import com.sneakingshadow.bvks.util.StringUtil;

import java.util.ArrayList;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.*;

class InputSorter {

    static ArrayList<Object> sortList(Object[] objects) {
        ArrayList<Object> arrayList = inputList(objects, new ArrayList<Object>());
        arrayList = brackets(arrayList);
        arrayList = arrayListSort(arrayList);
        arrayList = oreDictionary(arrayList);
        arrayList = specialCharacter(arrayList);
        arrayList = operator(arrayList);

        return arrayList;
    }

    private static ArrayList<Object> inputList(Object[] objects, ArrayList<Object> arrayList) {
        for (Object object : objects)
            if (object instanceof InputList)
                inputList(((ArrayList) object).toArray(), arrayList);
            else
                arrayList.add(object);

        return arrayList;
    }

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

                addToList(object, bracketsNotClosed == num && bracketsNotClosed > 0, bracketList, inputList);
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

                    addToList(bool ? string.substring(1,string.length()) : string, bracketsNotClosed == num && bracketsNotClosed > 0, bracketList, inputList);
                }
            } else
                addToList(object, bracketsNotClosed > 0, bracketList, inputList);

        }

        return inputList;
    }

    private static ArrayList<Object> arrayListSort(ArrayList<Object> objects) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : objects)
            if (object instanceof ArrayList) {
                arrayList.add(
                        new SBlockArrayList(
                                sortList( ((ArrayList) object).toArray() )
                        )
                );
            } else
                arrayList.add(object);

        return arrayList;
    }

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

    private static ArrayList<Object> specialCharacter(ArrayList<Object> objects) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (Object object : objects) {
            if (object == null)
                arrayList.add(new SBlockNull());
            else {
                StructureBlock structureBlock = MultiBlockLists.getSpecialValue(object);
                if (structureBlock != null)
                    arrayList.add(structureBlock);
                else
                    arrayList.add(object);
            }
        }

        return arrayList;
    }

    private static ArrayList<Object> operator(ArrayList<Object> arrayList) {
        ArrayList<OperatorInitializer> operatorInitializerList = MultiBlockLists.getOperatorList();

        for (OperatorInitializer operatorInitializer : operatorInitializerList){
            ArrayList<Integer> removedEntries = new ArrayList<Integer>();

            for (int i = 0; i < arrayList.size(); i++) {
                if (!removedEntries.contains(i)) {
                    if (operatorInitializer.isSpecialValue(arrayList.get(i))) {
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

    //Used by operator
    private static ArrayList<Object> removeEntries(ArrayList<Object> inputList, ArrayList<Integer> removedEntries) {
        ArrayList<Object> arrayList = new ArrayList<Object>();

        for (int i = 0; i < inputList.size(); i++)
            if (!removedEntries.contains(i))
                arrayList.add(inputList.get(i));

        return arrayList;
    }

    private static void addToList(Object object, boolean bool, ArrayList<Object> true_list, ArrayList<Object> false_list) {
        if (bool)
            true_list.add(object);
        else
            false_list.add(object);
    }

}
