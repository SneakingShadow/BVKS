package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.block.*;
import com.sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Reference;
import com.sneakingshadow.bvks.tileentity.TileEntityDebugBlock;
import com.sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;

import java.util.List;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final Block DevilOre = new BlockDevilOre();
    public static final Block DevilCobblestone = new BlockBVKS(Name.Block.DEVIL_COBBLESTONE);
    public static final Block SmoothObsidian = new BlockBVKS(Name.Block.SMOOTH_OBSIDIAN);
    public static final Block DemonAltar = new BlockDemonAltar();
    public static final Block DemonFurnace = new BlockDemonFurnace();
    public static final Block HammerWorkbench = new BlockHammerWorkbench(Name.Block.HAMMER_WORKBENCH);

    public static final Block DebugBlock = new BlockDebugBlock();

    public static void init(){
        blocks();
        tileEntities();
        registerBlock(DebugBlock);
        registerTile(TileEntityDebugBlock.class, DebugBlock);
    }

    private static void blocks(){
        registerBlock(DevilOre);
        registerBlock(DevilCobblestone);
        registerBlock(SmoothObsidian);
        registerBlock(DemonAltar);
        registerBlock(DemonFurnace);
        registerBlock(HammerWorkbench);
    }

    private static void tileEntities(){
        registerTile(TileEntityDemonFurnace.class, DemonFurnace);
    }

    private static void registerBlock(Block block){
        GameRegistry.registerBlock(block, "block_" + block.getUnlocalizedName().substring( block.getUnlocalizedName().indexOf(':')+1 ) );
    }

    private static void registerTile(Class<? extends TileEntity> clazz, Block block){
        GameRegistry.registerTileEntity(clazz, "tile_" + block.getUnlocalizedName().substring( block.getUnlocalizedName().indexOf(':')+1 ));
    }

    public static void add(List list, CreativeTabs creativeTab){
        CreativeTabBVKS.add(list, creativeTab, new Block[]{
                DevilOre,
                SmoothObsidian,
                DevilCobblestone,
                DemonAltar,
                DemonFurnace,
                HammerWorkbench,
        });
        CreativeTabBVKS.add(list, creativeTab, DebugBlock);
    }
}
