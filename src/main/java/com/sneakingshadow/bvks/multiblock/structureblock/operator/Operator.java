package com.sneakingshadow.bvks.multiblock.structureblock.operator;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.*;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public abstract class Operator extends StructureBlock {

    /**
     * Takes, possibly unmapped, operands
     *
     * @return positions to be removed in inputList
     * */
    public abstract int[] takeOperands(ArrayList<Object> inputList, int position);

    /**
     * @return operator is used validly
     *
     * If return false, then operator is deleted from inputList
     * !inputList.isEmpty() is allready checked.
     * */
    public abstract boolean valid(ArrayList<Object> inputList, int position);

    /**
     * Returns if inputted position in array holds a valid structure block or not.
     * */
    public static boolean clearPosition(ArrayList<Object> inputList, int position){
        return position >= 0
                && position < inputList.size()
                && !(inputList.get(position) instanceof Operator)
                && !(inputList.get(position) instanceof Character
                        && (
                                NEXT_LINE.equals(inputList.get(position))
                                || NEXT_LEVEL.equals(inputList.get(position))
                                || STRING_OBJECT.equals(inputList.get(position))
                        )
                );
    }

    public static boolean clearPositions(ArrayList<Object> inputList, int... positions){
        Boolean bool = true;
        for (int position : positions) {
            bool &= clearPosition(inputList, position);
        }
        return bool;
    }

    /**
     * Returns the correct object if the object is mapped,
     * but if nothing is valid, it's for example a structure modifier, a structure block only yielding false is returned, for simplicity.
     * */
    public StructureBlock mapOperator(Object object, HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        StructureBlock structureBlock = super.map(object, charMap, stringMap);

        return structureBlock != null ? structureBlock : new StructureBlock() {
            @Override
            public boolean startCheckingForStructure(World world, int x, int y, int z) {
                return false;
            }

            @Override
            public String toString() {
                return "invalid operator";
            }
        };
    }
}
