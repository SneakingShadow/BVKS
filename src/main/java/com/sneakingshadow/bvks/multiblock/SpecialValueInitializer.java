package com.sneakingshadow.bvks.multiblock;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;

public abstract class SpecialValueInitializer extends ValueInitializer {

    public SpecialValueInitializer(Object object) {
        super(object);
    }

    abstract StructureBlock getStructureBlock();

}
