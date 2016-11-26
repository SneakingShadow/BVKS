package com.sneakingshadow.bvks.multiblock.structureblock.operator;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashMap;

import static com.sneakingshadow.bvks.multiblock.MultiBlockLists.AND;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class OperatorAnd extends Operator {

    private StructureBlock operand_1;
    private StructureBlock operand_2;

    private Object operand_1_input;
    private Object operand_2_input;

    public boolean blockIsValid(World world, Vec3 worldPosition, Vec3 arrayPosition, int rotationX, int rotationY, int rotationZ) {
        return operand_1.blockIsValid(world, worldPosition, arrayPosition, rotationX, rotationY, rotationZ)
                && operand_2.blockIsValid(world, worldPosition, arrayPosition, rotationX, rotationY, rotationZ);
    }

    /**
     * A small un-official check to determine if it should continue checking in world.
     */
    @Override
    public boolean startCheckingForStructure(World world, int x, int y, int z) {
        return operand_1.startCheckingForStructure(world, x, y, z) && operand_2.startCheckingForStructure(world, x, y, z);
    }

    /**
     * @param inputList
     * @param position
     * @return positions to be removed in an array.
     */
    @Override
    public int[] takeOperands(ArrayList<Object> inputList, int position) {
        operand_1_input = inputList.get(position-1);
        operand_2_input = inputList.get(position+1);
        return new int[]{position - 1, position + 1};
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
    public boolean valid(ArrayList<Object> inputList, int position) {
        return clearPositions(inputList, position-1, position+1);
    }

    /**
     * Gets called at the end of structure initialization, in order to let operators and arrayList sort its contained structure blocks out.
     *
     * Note:
     *     Mapped string in stringMap start with MultiBlockLists.STRING_OBJECT
     * */
    public StructureBlock map(HashMap<Character, StructureBlock> charMap, HashMap<String, StructureBlock> stringMap) {
        operand_1 = mapObject(operand_1_input, charMap, stringMap);
        operand_2 = mapObject(operand_2_input, charMap, stringMap);

        return this;
    }

    public String toString() {
        return operand_1.toString() + " " + AND + " " + operand_2.toString();
    }
}
