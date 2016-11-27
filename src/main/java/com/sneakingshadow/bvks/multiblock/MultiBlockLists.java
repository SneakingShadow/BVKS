package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.initializer.OperatorInitializer;
import com.sneakingshadow.bvks.multiblock.initializer.SpecialCharacterInitializer;
import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import com.sneakingshadow.bvks.multiblock.structureblock.operator.*;
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
    public static final Character DUPLICATE_LEVEL_0 = '<';
    public static final Character DUPLICATE_LEVEL_1 = '>';
    public static final Character DUPLICATE_LEVEL_2 = '[';
    public static final Character DUPLICATE_LEVEL_3 = ']';

    //Modifiers
    public static final Character ORE_DICTIONARY = '@';

    //Mapping
    public static final Character STRING_OBJECT = '^';

    //Structure modifiers
    public static final Character NEXT_LINE = '/';
    public static final Character NEXT_LEVEL = '\\';

    private static ArrayList<Character> specialCharactersUsed = new ArrayList<Character>();
    private static ArrayList<Character> operatorsUsed = new ArrayList<Character>();

    private static ArrayList<Character> otherCharactersUsed = ArrayListHelper.getArrayList(
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            STRING_OBJECT, ORE_DICTIONARY, BRACKET_START, BRACKET_END, NEXT_LINE, NEXT_LEVEL
    );

    public static void init() {

        //Special characters
        register(
                new SpecialCharacterInitializer(NULL) {
                    @Override
                    public StructureBlock getStructureBlock() {
                        return new SBlockNull();
                    }
                }
        );
        register(
                new SpecialCharacterInitializer(FULL_BLOCK) {
                    @Override
                    public StructureBlock getStructureBlock() {
                        return new SBlockFull();
                    }
                }
        );
        register(
                new SpecialCharacterInitializer(AIR) {
                    @Override
                    public StructureBlock getStructureBlock() {
                        return new SBlockAir();
                    }
                }
        );
        register(
                new SpecialCharacterInitializer(REPLACEABLE_BLOCK) {
                    @Override
                    public StructureBlock getStructureBlock() {
                        return new SBlockReplaceable();
                    }
                }
        );
        register(
                new SpecialCharacterInitializer(LIQUID) {
                    @Override
                    public StructureBlock getStructureBlock() {
                        return new SBlockLiquid();
                    }
                }
        );
        register(
                new SpecialCharacterInitializer(OPAQUE_MATERIAL) {
                    @Override
                    public StructureBlock getStructureBlock() {
                        return new SBlockOpaqueMaterial();
                    }
                }
        );
        register(
                new SpecialCharacterInitializer(OPAQUE_LIGHT) {
                    @Override
                    public StructureBlock getStructureBlock() {
                        return new SBlockLightOpaque();
                    }
                }
        );

        //Operators
        register(
                new OperatorInitializer(NOT) {
                    @Override
                    public Operator getOperator() {
                        return new OperatorNot();
                    }
                }
        );
        register(
                new OperatorInitializer(AND) {
                    @Override public Operator getOperator() {
                        return new OperatorAnd();
                    }
                }
        );
        register(
                new OperatorInitializer(OR) {
                    @Override public Operator getOperator() {
                        return new OperatorOr();
                    }
                }
        );

        //Duplicators
        registerDuplicator(
                new OperatorInitializer(DUPLICATE_LEVEL_0) {
                    @Override public Operator getOperator() {
                        return new OperatorDuplicate();
                    }
                }
        );
        registerDuplicator(
                new OperatorInitializer(DUPLICATE_LEVEL_1) {
                    @Override public Operator getOperator() {
                        return new OperatorDuplicate();
                    }
                }
        );
        registerDuplicator(
                new OperatorInitializer(DUPLICATE_LEVEL_2) {
                    @Override public Operator getOperator() {
                        return new OperatorDuplicate();
                    }
                }
        );
        registerDuplicator(
                new OperatorInitializer(DUPLICATE_LEVEL_3) {
                    @Override public Operator getOperator() {
                        return new OperatorDuplicate();
                    }
                }
        );
    }

    private static ArrayList<SpecialCharacterInitializer> specialCharacterInitializerList = new ArrayList<SpecialCharacterInitializer>();
    private static ArrayList<OperatorInitializer> operatorInitializerList = new ArrayList<OperatorInitializer>();
    private static ArrayList<OperatorInitializer> duplicatorInitializerList = new ArrayList<OperatorInitializer>();

    public static boolean specialCharacterUsed(Character value) {
        return specialCharactersUsed.contains(value);
    }

    public static boolean operatorUsed(Character value) {
        return operatorsUsed.contains(value);
    }

    public static boolean characterUsed(Character value) {
        return otherCharactersUsed.contains(value) || specialCharacterUsed(value) || operatorUsed(value);
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
        if (!characterUsed(specialCharacterInitializer.getCharacter())) {
            specialCharacterInitializerList.add(specialCharacterInitializer);
            specialCharactersUsed.add(specialCharacterInitializer.getCharacter());
            return true;
        }
        return false;
    }

    //-------------Operators-------------//
    /**
     * @return returns list of operator
     * */
    public static ArrayList<OperatorInitializer> getOperatorList() {
        return operatorInitializerList;
    }

    /**
     * Operators are registered here.
     * @return successful
     * */
    public static boolean register(OperatorInitializer operatorInitializer) {
        if (!characterUsed(operatorInitializer.getCharacter())) {
            operatorInitializerList.add(operatorInitializer);
            operatorsUsed.add(operatorInitializer.getCharacter());
            return true;
        }
        return false;
    }

    //------------Duplicators------------//
    /**
     * Duplicators are registered here.
     * @return successful
     * */
    public static boolean registerDuplicator(OperatorInitializer operatorInitializer) {
        if (!characterUsed(operatorInitializer.getCharacter())) {
            duplicatorInitializerList.add(operatorInitializer);
            operatorsUsed.add(operatorInitializer.getCharacter());
            return true;
        }
        return false;
    }

    /**
     * @return returns operator, and null if invalid value
     * */
    public static OperatorInitializer getDuplicator(int number) {
        return duplicatorInitializerList.get(number);
    }

}
