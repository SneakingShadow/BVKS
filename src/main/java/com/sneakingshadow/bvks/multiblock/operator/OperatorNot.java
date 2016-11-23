package com.sneakingshadow.bvks.multiblock.operator;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class OperatorNot extends Operator {

    StructureBlock operand;

    public boolean blockIsValid(World world, Vec3 worldPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {
        return !operand.blockIsValid(world, worldPosition, arrayPosition, rotationX, rotationY, rotationZ);
    }

    /**
     * @param inputList
     * @param position
     * @return positions to be removed in inputList.
     */
    @Override
    public int[] takeOperands(ArrayList<StructureBlock> inputList, int position) {
        operand = inputList.get(position+1);
        return new int[position+1];
    }

    /**
     * @param inputList
     * @param position
     * @return operator is used validly.
     *
     * If false operator is deleted from inputList.
     * !inputList.isEmpty() is allready checked.
     */
    @Override
    public boolean valid(ArrayList<StructureBlock> inputList, int position) {
        return clearPosition(inputList, position);
    }
}
