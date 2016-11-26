package com.sneakingshadow.bvks.multiblock;

class ValueInitializer {

    private Object specialValue;

    ValueInitializer(Object object) {
        specialValue = object;
    }

    public Object getSpecialValue() {
        return specialValue;
    }

    public boolean isSpecialValue(Object object) {
        return specialValue.equals(object);
    }

}
