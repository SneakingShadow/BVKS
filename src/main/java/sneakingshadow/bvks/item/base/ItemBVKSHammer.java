package sneakingshadow.bvks.item.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.util.BlockBreakingHelper;

public class ItemBVKSHammer extends ItemBVKSTool
{

    private final int size;

    public ItemBVKSHammer(ToolMaterial toolMaterial, int size) {
        this(toolMaterial.getMaxUses(), toolMaterial.getEfficiencyOnProperMaterial(), toolMaterial.getDamageVsEntity(), toolMaterial.getEnchantability(), toolMaterial.getHarvestLevel(), size);
    }

    public ItemBVKSHammer(int maxUses, float efficiencyOnProperMaterial, float damageVsEntity, int enchantability, int harvestLevel, int size) {
        super(maxUses, efficiencyOnProperMaterial, damageVsEntity, enchantability);
        this.size = size;
        this.setPickaxe(harvestLevel);
        this.setAxe(harvestLevel);
        this.setShovel(harvestLevel);
        this.setSword();
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int xPos, int yPos, int zPos, EntityLivingBase entityLivingBase)
    {
        if ((double)block.getBlockHardness(world, xPos, yPos, zPos) != 0.0D && this.isDamageable())
        {
            itemStack.damageItem(1, entityLivingBase);
        }
        if(this.func_150897_b(block)){
            if (entityLivingBase instanceof EntityPlayer){
                int side = Minecraft.getMinecraft().objectMouseOver.sideHit;
                if (side == 0) {
                    zPos += this.size/2;
                }else if (side == 1) {
                    zPos -= ((float)this.size)%2f == 0.5f ? this.size/2+1 : this.size/2;
                }else if (side == 2) {
                    zPos += this.size/2;
                }else if (side == 3)
                {
                    zPos -= ((float)this.size)%2f == 0.5f ? this.size/2+1 : this.size/2;
                }else if (side == 4)
                {
                    xPos += this.size/2;
                }else if (side == 5)
                {
                    xPos -= ((float)this.size)%2f == 0.5f ? this.size/2+1 : this.size/2;
                }
            }
            BlockBreakingHelper.breakBlock(itemStack, world, block, xPos, yPos, zPos, entityLivingBase);
            for(int rx = xPos-this.size/2; rx< xPos-this.size/2+this.size; rx++){
                for(int ry = yPos-1; ry< yPos-1+this.size ;ry++) {
                    for(int rz = zPos-this.size/2; rz< zPos-this.size/2+this.size;rz++){
                        Block blocky = world.getBlock(rx, ry, rz);
                        if (blocky.getMaterial() != Material.air && (this.func_150897_b(blocky) || blocky.getHarvestLevel(blocky.getDamageValue(world, rx, ry, rz)) == 0) && blocky.getBlockHardness(world,rx,ry,rz) != -1.0F) {
                            BlockBreakingHelper.breakBlock(itemStack, world, blocky, rx, ry, rz, entityLivingBase);
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean devilTool = false;

    public ItemBVKSHammer setDevilTool() {
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