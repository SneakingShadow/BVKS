package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import sneakingshadow.bvks.block.*;
import sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

import java.util.List;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModBlocks
{
    public static final Block DevilOre = new BlockDevilOre();
    public static final Block DevilCobblestone = new BlockBVKS().setBlockName(Name.Block.DEVIL_COBBLESTONE);
    public static final Block SmoothObsidian = new BlockBVKS().setBlockName(Name.Block.SMOOTH_OBSIDIAN);
    public static final Block DemonAltar = new BlockDemonAltar();
    public static final Block DemonFurnace = new BlockDemonFurnace();

    public static final Block DebugBlock = new BlockDebugBlock();

    public static void init(){
        blocks();
        tileEntities();
        registerBlock(DebugBlock, Name.Block.DEBUG_BLOCK);
        registerTile(TileEntityDebugBlock.class, Name.Block.DEBUG_BLOCK);
    }

    private static void blocks(){
        registerBlock(DevilOre, Name.Block.DEVIL_ORE);
        registerBlock(DevilCobblestone, Name.Block.DEVIL_COBBLESTONE);
        registerBlock(SmoothObsidian, Name.Block.SMOOTH_OBSIDIAN);
        registerBlock(DemonAltar, Name.Block.DEMON_ALTAR);
        registerBlock(DemonFurnace, Name.Block.DEMON_FURNACE);
    }

    private static void tileEntities(){
        registerTile(TileEntityDemonFurnace.class, Name.Block.DEMON_FURNACE);
    }

    private static void registerBlock(Block block, String name){
        GameRegistry.registerBlock(block, Ref.RESOURCE_PREFIX + "block_" + name);
    }

    private static void registerTile(Class<? extends TileEntity> clazz, String name){
        GameRegistry.registerTileEntity(clazz, Ref.RESOURCE_PREFIX + "tile_" + name);
    }

    public static void add(List list, CreativeTabs creativeTab){
        CreativeTabBVKS.add(list, creativeTab, new Block[]{
                DevilOre,
                SmoothObsidian,
                DevilCobblestone,
                DemonAltar,
                DemonFurnace,
        });
        CreativeTabBVKS.add(list, creativeTab, DebugBlock);
    }
}
