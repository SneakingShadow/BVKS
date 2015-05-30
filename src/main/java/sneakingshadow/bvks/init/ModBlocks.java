package sneakingshadow.bvks.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import sneakingshadow.bvks.block.BlockDebugBlock;
import sneakingshadow.bvks.block.BlockDevilCobblestone;
import sneakingshadow.bvks.block.BlockDevilOre;
import sneakingshadow.bvks.block.BlockSmoothObsidian;
import sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.tileentity.TileEntityDebugBlock;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModBlocks
{
    public static final Block DevilOre = new BlockDevilOre();
    public static final Block DevilCobblestone = new BlockDevilCobblestone();
    public static final Block SmoothObsidian = new BlockSmoothObsidian();
    public static final Block DebugBlock = new BlockDebugBlock();

    public static void init()
    {
        registerBlock(DevilOre, Names.Blocks.DevilOre);
        registerBlock(DevilCobblestone, Names.Blocks.DevilCobblestone);
        registerBlock(SmoothObsidian, Names.Blocks.SmoothObsidian);
        registerBlock(DebugBlock, Names.Blocks.DebugBlock);

        registerTile(TileEntityDebugBlock.class, Names.Blocks.DebugBlock);
    }

    private static void registerBlock(Block block, String name){
        GameRegistry.registerBlock(block, Ref.RESOURCE_PREFIX + "block_" + name);
    }

    private static void registerTile(Class<? extends TileEntity> clazz, String name){
        GameRegistry.registerTileEntity(clazz, Ref.RESOURCE_PREFIX + "tile_" + name);
    }

    public static void add(){
        CreativeTabBVKS.add(new Block[]
                {

                        DevilOre, SmoothObsidian, DevilCobblestone,

                }
        );
        CreativeTabBVKS.add(DebugBlock);
    }
}
