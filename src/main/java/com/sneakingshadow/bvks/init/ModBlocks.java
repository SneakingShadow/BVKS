package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.block.BlockBVKS;
import com.sneakingshadow.bvks.block.BlockDevilOre;
import com.sneakingshadow.bvks.reference.Reference;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockBVKS blockDevilOre = new BlockDevilOre();

    public static void init()
    {
        GameRegistry.registerBlock(blockDevilOre, "devilOre");
    }
}
