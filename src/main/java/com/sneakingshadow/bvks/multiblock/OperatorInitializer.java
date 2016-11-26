package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.operator.Operator;

public abstract class OperatorInitializer extends ValueInitializer {

    /**
     * Input what object should be mapped to what operator.
     *
     * If that value is used, it will return an operator in getOperator()
     * This uses .equals to compare values
     * */
    public OperatorInitializer(Object object) {
        super(object);
    }

    /**
     * @return new operator object
     * */
    public abstract Operator getOperator();

}
