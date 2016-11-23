package com.sneakingshadow.bvks.multiblock.operator;

import com.sneakingshadow.bvks.multiblock.Structure;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class OperatorOr extends Operator {

    StructureBlock operand_1;
    StructureBlock operand_2;

    boolean operand_1_bool = true;
    boolean operand_2_bool = true;

    public boolean blockIsValid(World world, Vec3 worldPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {
        operand_1_bool &= operand_1.blockIsValid(world, (int)worldPosition.xCoord, (int)worldPosition.yCoord, (int)worldPosition.zCoord);
        operand_2_bool &= operand_2.blockIsValid(world, (int)worldPosition.xCoord, (int)worldPosition.yCoord, (int)worldPosition.zCoord);
        return operand_1_bool || operand_2_bool;
    }

    /**
     * @param inputList
     * @param position
     * @return positions to be removed in inputList.
     */
    @Override
    public int[] takeOperands(ArrayList<StructureBlock> inputList, int position) {
        StructureBlock operand_1 = inputList.get(position-1);
        StructureBlock operand_2 = inputList.get(position+1);
        return new int[]{position-1,position+1};
    }

    /**
     * @param inputList
     * @param position
     * @return operator is used validly.
     * <p>
     * If false operator is deleted from inputList.
     * !inputList.isEmpty() is allready checked.
     */
    @Override
    public boolean valid(ArrayList<StructureBlock> inputList, int position) {
        return clearPositions(inputList,position-1,position+1);
    }

    public void reset() {
        operand_1_bool = true;
        operand_2_bool = true;
    }
}
