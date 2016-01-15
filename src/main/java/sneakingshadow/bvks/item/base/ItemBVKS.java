package sneakingshadow.bvks.item.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.util.BlockBreakingHelper;
import sneakingshadow.bvks.util.DescHelper;

import java.util.List;

public class ItemBVKS extends Item
{
    public ItemBVKS()
    {
        super();
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabs.tabAllSearch);
        this.setNoRepair();
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(this.getDescription());
    }

    public String getDescription(String string) {
        return DescHelper.getDescription( getUnwrappedUnlocalizedName(super.getUnlocalizedName()) + string );
    }
    public String getDescription() {
        return getDescription("");
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Ref.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Ref.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getIconString()
    {
        return this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
    {
        return !devilTool || devilBreakBlock(itemStack, world, block, x, y, z, entityLivingBase);
    }

    private boolean devilTool = false;

    public ItemBVKS setDevilTool() {
        devilTool = true;
        return this;
    }

    public boolean devilBreakBlock(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
        {
            itemStack.damageItem(1, entityLivingBase);
            BlockBreakingHelper.breakBlock(itemStack, world, block, x, y, z, entityLivingBase);
        }
        return false;
    }
}

