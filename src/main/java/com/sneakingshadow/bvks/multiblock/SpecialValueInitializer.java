package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;

public abstract class SpecialValueInitializer extends ValueInitializer {

    /**
     * Input what object should be mapped to what structure block.
     * If that value is used, it will return a structure block in getStructureBlock()
     *
     * This uses .equals to compare values
     * */
    public SpecialValueInitializer(Object object) {
        super(object);
    }

    /**
     * @return new structure block object
     * */
    public abstract StructureBlock getStructureBlock();

}
