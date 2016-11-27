package com.sneakingshadow.bvks.multiblock.structureblock;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class SBlockBlock extends StructureBlock {

    private Block block;
    private int metadata;

    public SBlockBlock(Block block) {
        this(block, -1);
    }

    public SBlockBlock(Block block, int metadata) {
        this.block = block;
        this.metadata = metadata;
    }

    @Override
    public boolean blockIsValid(World world, int x, int y, int z){
        return world.getBlock(x,y,z) == block && (metadata == -1 || metadata == world.getBlockMetadata(x,y,z));
    }

    @Override
    public boolean startCheckingForStructure(World world, int x, int y, int z) {
        return blockIsValid(world, x, y, z);
    }

    @Override
    public String toString() {
        return "["+block.toString()+","+metadata+"]";
    }
}
