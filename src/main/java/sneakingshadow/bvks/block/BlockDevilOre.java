package sneakingshadow.bvks.block;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.reference.Name;

import java.util.ArrayList;
import java.util.Random;

public class BlockDevilOre extends BlockBVKS
{
    Random random = new Random();

    public BlockDevilOre()
    {
        super();
        this.setBlockName(Name.Block.DEVIL_ORE);
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
     * @param world The current worldgen
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
}
