package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.initializer.OperatorInitializer;
import com.sneakingshadow.bvks.multiblock.initializer.SpecialCharacterInitializer;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.operator.Operator;
import com.sneakingshadow.bvks.multiblock.structureblock.operator.OperatorAnd;
import com.sneakingshadow.bvks.multiblock.structureblock.operator.OperatorNot;
import com.sneakingshadow.bvks.multiblock.structureblock.operator.OperatorOr;
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
    public static final Character BRACKET_START = '(';
    public static final Character BRACKET_END = ')';
    public static final Character NOT = '!';
    public static final Character AND = '&';
    public static final Character OR = '|';

    //Modifiers
    public static final Character ORE_DICTIONARY = '@';

    //Mapping
    public static final Character STRING_OBJECT = '^';

    //Structure modifiers
    public static final Character NEXT_LINE = '/';
    public static final Character NEXT_LEVEL = '\\';

    private static ArrayList<Character> specialCharactersUsed = new ArrayList<Character>();

    private static ArrayList<Character> otherCharactersUsed = ArrayListHelper.getArrayList(
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            STRING_OBJECT, ORE_DICTIONARY, BRACKET_START, BRACKET_END, NEXT_LINE, NEXT_LEVEL
    );

    private static ArrayList<SpecialCharacterInitializer> specialCharacterInitializerList = ArrayListHelper.getArrayList(
            privateRegister(
                    new SpecialCharacterInitializer(NULL) {
                        @Override
                        public StructureBlock getStructureBlock() {
                            return new SBlockNull();
                        }
                    }
            ),
            privateRegister(
                    new SpecialCharacterInitializer(FULL_BLOCK) {
                        @Override
                        public StructureBlock getStructureBlock() {
                            return new SBlockFull();
                        }
                    }
            ),
            privateRegister(
                    new SpecialCharacterInitializer(AIR) {
                        @Override
                        public StructureBlock getStructureBlock() {
                            return new SBlockAir();
                        }
                    }
            ),
            privateRegister(
                    new SpecialCharacterInitializer(REPLACEABLE_BLOCK) {
                        @Override
                        public StructureBlock getStructureBlock() {
                            return new SBlockReplaceable();
                        }
                    }
            ),
            privateRegister(
                    new SpecialCharacterInitializer(LIQUID) {
                        @Override
                        public StructureBlock getStructureBlock() {
                            return new SBlockLiquid();
                        }
                    }
            ),
            privateRegister(
                    new SpecialCharacterInitializer(OPAQUE_MATERIAL) {
                        @Override
                        public StructureBlock getStructureBlock() {
                            return new SBlockOpaqueMaterial();
                        }
                    }
            ),
            privateRegister(
                    new SpecialCharacterInitializer(OPAQUE_LIGHT) {
                        @Override
                        public StructureBlock getStructureBlock() {
                            return new SBlockLightOpaque();
                        }
                    }
            )
    );

    private static ArrayList<OperatorInitializer> operatorInitializerList = ArrayListHelper.getArrayList(
            privateRegister(
                    new OperatorInitializer(NOT) {
                        @Override
                        public Operator getOperator() {
                            return new OperatorNot();
                        }
                    }
            ),
            privateRegister(
                    new OperatorInitializer(AND) {
                        @Override public Operator getOperator() {
                            return new OperatorAnd();
                        }
                    }
            ),
            privateRegister(
                    new OperatorInitializer(OR) {
                        @Override public Operator getOperator() {
                            return new OperatorOr();
                        }
                    }
            )
    );

    public static boolean specialCharacterUsed(Character value) {
        for (Character character : specialCharactersUsed)
            if (character.equals(value))
                return false;

        return true;
    }

    private static boolean characterUsed(Character value) {
        for (Character character : otherCharactersUsed)
            if (character.equals(value))
                return false;

        return specialCharacterUsed(value);
    }



    //-------------Special Values-------------//
    /**
     * @return structure block from special value, or null if invalid value.
     * */
    public static StructureBlock getSpecialCharacter(Character character) {
        for (SpecialCharacterInitializer initializer : specialCharacterInitializerList)
            if (initializer.isSpecialCharacter(character))
                return initializer.getStructureBlock();

        return null;
    }

    /**
     * Special values are registered here.
     * @return successful
     * */
    public static boolean register(SpecialCharacterInitializer specialCharacterInitializer) {
        if (characterUsed(specialCharacterInitializer.getCharacter())) {
            specialCharacterInitializerList.add(specialCharacterInitializer);
            specialCharactersUsed.add(specialCharacterInitializer.getCharacter());
            return true;
        }
        return false;
    }

    private static SpecialCharacterInitializer privateRegister(SpecialCharacterInitializer specialCharacterInitializer) {
        register(specialCharacterInitializer);
        return specialCharacterInitializer;
    }

    //-------------Operators-------------//
    /**
     * @return returns operator, and null if invalid value
     * */
    public static ArrayList<OperatorInitializer> getOperatorList() {
        return operatorInitializerList;
    }

    /**
     * Operators are registered here.
     * @return successful
     * */
    public static boolean register(OperatorInitializer operatorInitializer) {
        if (characterUsed(operatorInitializer.getCharacter())) {
            operatorInitializerList.add(operatorInitializer);
            otherCharactersUsed.add(operatorInitializer.getCharacter());
            return true;
        }
        return false;
    }

    private static OperatorInitializer privateRegister(OperatorInitializer operatorInitializer) {
        register(operatorInitializer);
        return operatorInitializer;
    }
}
