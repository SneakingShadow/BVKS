package sneakingshadow.bvks.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sneakingshadow.bvks.BVKS;
import sneakingshadow.bvks.init.ModGuis;

/**
 * Created by SneakingShadow on 13.03.2016.
 */
public class BlockHammerWorkbench extends BlockBVKS {

    public BlockHammerWorkbench(String unlocalizedName) {
        super(unlocalizedName, Material.wood);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
            entityPlayer.openGui(BVKS.instance, ModGuis.guiHammerWorkbench.getID(), world, x,y,z);
        return false;
    }

}
