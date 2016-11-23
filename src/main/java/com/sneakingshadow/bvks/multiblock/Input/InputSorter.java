package com.sneakingshadow.bvks.multiblock.Input;

import com.sneakingshadow.bvks.multiblock.InputList;
import com.sneakingshadow.bvks.multiblock.Operators;
import com.sneakingshadow.bvks.multiblock.operator.Operator;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class InputSorter {

    /**
     * Returns null if invalid.
     *
     * Returns everything that should be regarded as structure block as a StructureBlock.
     * Returns everything that should be regarded as an operator as an Operator.
     * Returns everything that should be regarded as a modifier as a Modifier.
     * */
    private static Object ensureObject(Object object) {

        if (object instanceof Character) {
            Operator operator = Operators.getOperator((Character)object);

            if (operator != null)
                return operator;
            else
                return object;
        }

        if (object instanceof ArrayList) {
            ArrayList<Object> arrayList = cleanList(
                    ((ArrayList)object).toArray(),
                    new ArrayList<Object>()
            );

            if (!arrayList.isEmpty())
                return arrayList;

        }

        return null;
    }

    /**
     * Removes bad arguments, modifies the input, and makes the input ready to be transformed to a multiblock.
     * Note: Null is not a bad argument, but from ensureObject it is.
     * */
    static ArrayList<Object> sortInput(Object[] objects) {
        ArrayList<Object> inputList = inputList(objects, new ArrayList<Object>());
        inputList = InputBracket.getList(inputList.toArray(), new ArrayList<Object>());

        return inputList;
    }

    static ArrayList<Object> getList(Object[] objects, ArrayList<Object> inputList) {
        for (Object object : objects)
            if (object instanceof InputList)
                getList(((InputList)object).toArray(), inputList);
            else
                inputList.add(object);

        return inputList;
    }

}
