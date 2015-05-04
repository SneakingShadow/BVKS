package sneakingshadow.bvks.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import sneakingshadow.bvks.block.*;
import sneakingshadow.bvks.creativetab.CreativeTabBVKS;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModBlocks
{
    public static final BlockBVKS DevilOre = new BlockDevilOre();
    public static final BlockBVKS DevilCobblestone = new BlockDevilCobblestone();
    public static final BlockBVKS SmoothObsidian = new BlockSmoothObsidian();
    public static final BlockBVKS DebugBlock = new BlockDebugBlock();

    public static void init()
    {
        GameRegistry.registerBlock(DevilOre, Names.Blocks.DevilOre);
        GameRegistry.registerBlock(DevilCobblestone, Names.Blocks.DevilCobblestone);
        GameRegistry.registerBlock(SmoothObsidian, Names.Blocks.SmoothObsidian);
        GameRegistry.registerBlock(DebugBlock, Names.Blocks.DebugBlock);
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
