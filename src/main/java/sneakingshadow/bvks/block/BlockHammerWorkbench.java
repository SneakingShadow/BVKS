package sneakingshadow.bvks.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import sneakingshadow.bvks.BVKS;
import sneakingshadow.bvks.init.ModGuis;
import sneakingshadow.bvks.reference.Name;

/**
 * Created by SneakingShadow on 13.03.2016.
 */
public class BlockHammerWorkbench extends BlockBVKS {

    public BlockHammerWorkbench(String unlocalizedName) {
        super(unlocalizedName, Material.wood);
        this.setSubBlocks(3);
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

    public static IIcon[] blockIcons = new IIcon[Name.Block.HAMMER_WORKBENCH_TIERS.length];
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for (int i=0;i<Name.Block.HAMMER_WORKBENCH_TIERS.length;i++)
            this.blockIcons[i] = iconRegister.registerIcon(this.getUnlocalizedName() + "_" + Name.Block.HAMMER_WORKBENCH_TIERS[i]);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata)
    {
        return this.blockIcons[metadata>=Name.Block.HAMMER_WORKBENCH_TIERS.length ? 0:metadata];
    }
}
