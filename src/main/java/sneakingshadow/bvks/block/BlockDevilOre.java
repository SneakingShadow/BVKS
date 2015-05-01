package sneakingshadow.bvks.block;

import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.reference.Names;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class BlockDevilOre extends BlockBVKS
{
    Random random = new Random();

    public BlockDevilOre()
    {
        super();
        this.setBlockName(Names.Blocks.DevilOre);
        this.setHardness(75F);
        this.setResistance(10000F);
        this.setHarvestLevel("pickaxe", 4);
    }

    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }

    @Override
    public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity)
    {
        return false;
    }

    /**
     * This returns a complete list of items dropped from this block.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @param metadata Current metadata
     * @param fortune Breakers fortune level
     * @return A ArrayList containing all items this block drops
     */
    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        if(fortune > 0) ret.add(new ItemStack(ModItems.DevilGem, random.nextInt(fortune)+1));
        else ret.add(new ItemStack(ModItems.DevilGem, 1));
        return ret;
    }

    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    @Override
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    @Override
    public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        return random.nextInt(16);
    }
}
