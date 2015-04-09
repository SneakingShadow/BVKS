package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.block.BlockBVKS;
import com.sneakingshadow.bvks.reference.Ref;
import com.sneakingshadow.bvks.block.BlockDevilCobblestone;
import com.sneakingshadow.bvks.block.BlockDevilOre;
import com.sneakingshadow.bvks.block.BlockSmoothObsidian;
import com.sneakingshadow.bvks.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModBlocks
{
    public static final BlockBVKS DevilOre = new BlockDevilOre();
    public static final BlockBVKS DevilCobblestone = new BlockDevilCobblestone();
    public static final BlockBVKS SmoothObsidian = new BlockSmoothObsidian();

    public static void init()
    {
        GameRegistry.registerBlock(DevilOre, Names.Blocks.DevilOre);
        GameRegistry.registerBlock(DevilCobblestone, Names.Blocks.DevilCobblestone);
        GameRegistry.registerBlock(SmoothObsidian, Names.Blocks.SmoothObsidian);

    }
}
