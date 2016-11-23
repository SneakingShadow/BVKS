package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.operator.*;
import com.sneakingshadow.bvks.util.ArrayListHelper;

import java.util.ArrayList;

/**
 * Created by SneakingShadow on 23.11.2016.
 */
public class Operators {

    public static final Character NOT = '!';
    public static final Character AND = '&';
    public static final Character OR = '|';

    private static ArrayList<OperatorInitializer> operatorList = ArrayListHelper.getArrayList(
            new OperatorInitializer(NOT, OperatorNot.class),
            new OperatorInitializer(AND, OperatorAnd.class),
            new OperatorInitializer(OR, OperatorOr.class)
    );

    /**
     * @return returns operator, and null if none are found
     * */
    public static Operator getOperator(Character character) {
        for (OperatorInitializer initializer : operatorList) {
            if (initializer.isIdentifier(character))
                return initializer.getOperator();
        }
        return null;
    }

    public static void registerOperator(Character character, Class<? extends Operator> clazz) {
        registerOperator(new OperatorInitializer(character, clazz));
    }

    public static void registerOperator(OperatorInitializer operatorInitializer) {
        operatorList.add(operatorInitializer);
    }

    public static class OperatorInitializer{

        public Operator getOperator() {
            if (clazz_bool)
                try {
                    return clazz.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            return new Operator.OperatorBlank();
        }

        private Character character;
        private Class<? extends Operator> clazz;
        private boolean clazz_bool = false;

        public OperatorInitializer(Character character) {
            this.character = character;
        }

        public OperatorInitializer(Character character, Class<? extends Operator> clazz) {
            this(character);
            this.clazz = clazz;
            clazz_bool = true;
        }

        protected boolean isIdentifier(Character character) {
            return character.equals(this.character);
        }

    }

}
