package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.operator.Operator;
import com.sneakingshadow.bvks.multiblock.operator.OperatorAnd;
import com.sneakingshadow.bvks.multiblock.operator.OperatorNot;
import com.sneakingshadow.bvks.multiblock.operator.OperatorOr;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.special.*;
import com.sneakingshadow.bvks.util.ArrayListHelper;

import java.util.ArrayList;

public class MultiBlockLists {

    //Special values
    public static final Character NULL = ' ';
    public static final Character FULL_BLOCK = '+';
    public static final Character AIR = '_';
    public static final Character REPLACEABLE_BLOCK = '-';
    public static final Character LIQUID = '~';
    public static final Character OPAQUE_MATERIAL = '*';
    public static final Character OPAQUE_LIGHT = '#';

    //Operators
    public static final Character NOT = '!';
    public static final Character AND = '&';
    public static final Character OR = '|';
    public static final Character ORE_DICTIONARY = '@';

    //Modifiers
    public static final Character BRACKET_START = '(';
    public static final Character BRACKET_END = ')';
    public static final Character NEXT_LINE = '/';
    public static final Character NEXT_LEVEL = '\\';

    private static ArrayList<Object> valuesUsed = ArrayListHelper.getArrayList(
            (Object)NULL, FULL_BLOCK, AIR, REPLACEABLE_BLOCK, LIQUID, OPAQUE_MATERIAL, OPAQUE_LIGHT,
            NOT, AND, OR, ORE_DICTIONARY,
            BRACKET_START, BRACKET_END, NEXT_LINE, NEXT_LEVEL
    );

    private static boolean usedSpecialValue(Object values) {
        for (Object object : valuesUsed)
            if (object.equals(values))
                return false;

        return true;
    }

    private static <T extends ValueInitializer> boolean register(T initializer, ArrayList<T> arrayList) {
        if (usedSpecialValue(initializer.getSpecialValue())) {
            arrayList.add(initializer);
            return true;
        }
        return false;
    }



    //-------------Special Values-------------//
    private static ArrayList<SpecialValueInitializer> specialValueInitializerList = ArrayListHelper.getArrayList(
            new SpecialValueInitializer(NULL) {
                @Override
                StructureBlock getStructureBlock() {
                    return new SBlockNull();
                }
            },
            new SpecialValueInitializer(FULL_BLOCK) {
                @Override
                StructureBlock getStructureBlock() {
                    return new SBlockFull();
                }
            },
            new SpecialValueInitializer(AIR) {
                @Override
                StructureBlock getStructureBlock() {
                    return new SBlockAir();
                }
            },
            new SpecialValueInitializer(REPLACEABLE_BLOCK) {
                @Override
                StructureBlock getStructureBlock() {
                    return new SBlockReplaceable();
                }
            },
            new SpecialValueInitializer(LIQUID) {
                @Override
                StructureBlock getStructureBlock() {
                    return new SBlockLiquid();
                }
            },
            new SpecialValueInitializer(OPAQUE_MATERIAL) {
                @Override
                StructureBlock getStructureBlock() {
                    return new SBlockOpaqueMaterial();
                }
            },
            new SpecialValueInitializer(OPAQUE_LIGHT) {
                @Override
                StructureBlock getStructureBlock() {
                    return new SBlockLightOpaque();
                }
            }
    );

    /**
     * @return structure block from special value, or null if invalid value.
     * */
    public static StructureBlock getSpecialValue(Object value) {
        for (SpecialValueInitializer initializer : specialValueInitializerList)
            if (initializer.isSpecialValue(value))
                return initializer.getStructureBlock();

        return null;
    }

    /**
     * Special values are registered here.
     * @return successful
     * */
    public static boolean register(SpecialValueInitializer specialValueInitializer) {
        return register(specialValueInitializer, specialValueInitializerList);
    }



    //-------------Operators-------------//
    private static ArrayList<OperatorInitializer> operatorInitializerList = ArrayListHelper.getArrayList(
            new OperatorInitializer(NOT) {
                @Override
                Operator getOperator() {
                    return new OperatorNot();
                }
            },
            new OperatorInitializer(AND) {
                @Override
                Operator getOperator() {
                    return new OperatorAnd();
                }
            },
            new OperatorInitializer(OR) {
                @Override
                Operator getOperator() {
                    return new OperatorOr();
                }
            }
    );

    /**
     * @return returns operator, and null if invalid value
     * */
    public static Operator getOperator(Object value) {
        for (OperatorInitializer initializer : operatorInitializerList) {
            if (initializer.isSpecialValue(value))
                return initializer.getOperator();
        }
        return null;
    }

    /**
     * Operators are registered here.
     * @return successful
     * */
    public static boolean register(OperatorInitializer operatorInitializer) {
        return register(operatorInitializer, operatorInitializerList);
    }
}
