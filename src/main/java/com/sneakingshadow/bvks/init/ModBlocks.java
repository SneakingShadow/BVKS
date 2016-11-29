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
    public static final Block devilOre = new BlockDevilOre();
    public static final Block devilCobblestone = new BlockBVKS(Name.Block.DEVIL_COBBLESTONE);
    public static final Block smoothObsidian = new BlockBVKS(Name.Block.SMOOTH_OBSIDIAN);
    public static final Block demonAltar = new BlockDemonAltar();
    public static final Block demonFurnace = new BlockDemonFurnace();
    public static final Block hammerWorkbench = new BlockHammerWorkbench(Name.Block.HAMMER_WORKBENCH);

    public static final Block debugBlock = new BlockDebugBlock();

    public static void init(){
        blocks();
        tileEntities();
        registerBlock(debugBlock);
        registerTile(TileEntityDebugBlock.class, debugBlock);
    }

    private static void blocks(){
        registerBlock(devilOre);
        registerBlock(devilCobblestone);
        registerBlock(smoothObsidian);
        registerBlock(demonAltar);
        registerBlock(demonFurnace);
        registerBlock(hammerWorkbench);
    }

    private static void tileEntities(){
        registerTile(TileEntityDemonFurnace.class, demonFurnace);
    }

    private static void registerBlock(Block block){
        GameRegistry.registerBlock(block, "block_" + block.getUnlocalizedName().substring( block.getUnlocalizedName().indexOf(':')+1 ) );
    }

    private static void registerTile(Class<? extends TileEntity> clazz, Block block){
        GameRegistry.registerTileEntity(clazz, "tile_" + block.getUnlocalizedName().substring( block.getUnlocalizedName().indexOf(':')+1 ));
    }

    public static void add(List list, CreativeTabs creativeTab){
        CreativeTabBVKS.add(list, creativeTab, new Block[]{
                devilOre,
                smoothObsidian,
                devilCobblestone,
                demonAltar,
                demonFurnace,
                hammerWorkbench,
        });
        CreativeTabBVKS.add(list, creativeTab, debugBlock);
    }
}
