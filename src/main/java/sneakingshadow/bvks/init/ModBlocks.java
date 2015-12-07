package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import sneakingshadow.bvks.block.BlockBVKS;
import sneakingshadow.bvks.block.BlockDebugBlock;
import sneakingshadow.bvks.block.BlockDemonAltar;
import sneakingshadow.bvks.block.BlockDevilOre;
import sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

import java.util.List;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModBlocks
{
    public static final Block DebugBlock = new BlockDebugBlock();

    public static final Block DevilOre = new BlockDevilOre();
    public static final Block DevilCobblestone = new BlockBVKS().setBlockName(Names.Blocks.DEVIL_COBBLESTONE);
    public static final Block SmoothObsidian = new BlockBVKS().setBlockName(Names.Blocks.SMOOTH_OBSIDIAN);
    public static final Block DemonAltar = new BlockDemonAltar();

    public static void init(){
        registerBlock(DebugBlock, Names.Blocks.DEBUG_BLOCK);
        registerTile(TileEntityDebugBlock.class, Names.Blocks.DEBUG_BLOCK);

        registerBlock(DevilOre, Names.Blocks.DEVIL_ORE);
        registerBlock(DevilCobblestone, Names.Blocks.DEVIL_COBBLESTONE);
        registerBlock(SmoothObsidian, Names.Blocks.SMOOTH_OBSIDIAN);
        registerBlock(DemonAltar, Names.Blocks.DEMON_ALTAR);
    }

    private static void registerBlock(Block block, String name){
        GameRegistry.registerBlock(block, Ref.RESOURCE_PREFIX + "block_" + name);
    }

    private static void registerTile(Class<? extends TileEntity> clazz, String name){
        GameRegistry.registerTileEntity(clazz, Ref.RESOURCE_PREFIX + "tile_" + name);
    }

    public static void add(List list){
        CreativeTabBVKS.add(list, new Block[]{
                DevilOre,
                SmoothObsidian,
                DevilCobblestone,
                DemonAltar
        });
        CreativeTabBVKS.add(list, DebugBlock);
    }
}
