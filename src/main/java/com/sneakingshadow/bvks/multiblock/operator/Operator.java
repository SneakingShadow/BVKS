package com.sneakingshadow.bvks.multiblock.operator;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public abstract class Operator extends StructureBlock {

    /**
     * @return positions to be removed in inputList
     * */
    public abstract int[] takeOperands(ArrayList<StructureBlock> inputList, int position);

    /**
     * @return operator is used validly
     *
     * If return false, then operator is deleted from inputList
     * !inputList.isEmpty() is allready checked.
     * */
    public abstract boolean valid(ArrayList<StructureBlock> inputList, int position);

    private Object key;

    public void mapToObject(Object object) {
        key = object;
    }

    public Object getKey() {
        return key;
    }

    public static boolean clearPosition(ArrayList<StructureBlock> inputList, int position){
        return position >= 0 && position < inputList.size() && !(inputList.get(position) instanceof Operator);
    }

    public static boolean clearPositions(ArrayList<StructureBlock> inputList, int... positions){
        Boolean bool = true;
        for (int position : positions) {
            bool &= clearPosition(inputList, position);
        }
        return bool;
    }

    public static class OperatorBlank extends Operator {

        @Override
        public int[] takeOperands(ArrayList<StructureBlock> inputList, int position) {
            return new int[0];
        }

        @Override
        public boolean valid(ArrayList<StructureBlock> inputList, int position) {
            return false;
        }

    }

}
