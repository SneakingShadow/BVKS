package sneakingshadow.bvks.item.base;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.util.BlockBreakingHelper;

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

    public ItemBVKS setBaseName(String string){
        this.setUnlocalizedName(string);
        this.setTextureName(Ref.MOD_ID+":"+string);
        return this;
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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
    {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
        {
            itemStack.damageItem(1, entityLivingBase);
            BlockBreakingHelper.breakBlock(itemStack, world, block, x, y, z, entityLivingBase);
        }

        return false;
    }
}

