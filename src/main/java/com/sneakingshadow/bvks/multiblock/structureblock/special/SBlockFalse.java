package com.sneakingshadow.bvks.multiblock.structureblock.special;

import com.sneakingshadow.bvks.multiblock.structureblock.StructureBlock;
import net.minecraft.world.World;

public class SBlockFalse extends StructureBlock {
    @Override
    public boolean startCheckingForStructure(World world, int x, int y, int z) {
        return false;
    }

    @Override
    public String toString() {
        return "invalid operator";
    }
}