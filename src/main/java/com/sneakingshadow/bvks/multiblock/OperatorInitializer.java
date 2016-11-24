package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.operator.Operator;

public abstract class OperatorInitializer extends ValueInitializer {

    public OperatorInitializer(Object object) {
        super(object);
    }

    abstract Operator getOperator();

}
