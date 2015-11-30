package sneakingshadow.bvks.item.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.util.BlockBreakingHelper;

public class ItemBVKSHammer extends ItemBVKSPickaxe
{

    public final byte widthX;
    public final byte widthY;
    public final byte widthZ;
    private static Item itemShovel;

    public ItemBVKSHammer(ToolMaterial toolMaterial, int x, int y, int z, Item shovel){
        super(toolMaterial);
        widthX = (byte) x;
        widthY = (byte) y;
        widthZ = (byte) z;
        itemShovel = shovel;
    }

    public ItemBVKSHammer(ToolMaterial toolMaterial, int size, Item shovel){
        super(toolMaterial);
        widthX = (byte) size;
        widthY = (byte) size;
        widthZ = (byte) size;
        itemShovel = shovel;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int xPos, int yPos, int zPos, EntityLivingBase entityLivingBase) //TODO Silk touch on hammers
    {
        if ((double)block.getBlockHardness(world, xPos, yPos, zPos) != 0.0D && this.isDamageable())
        {
            itemStack.damageItem(1, entityLivingBase);
        }
        if(this.func_150897_b(block)){
            if (entityLivingBase instanceof EntityPlayer){
                int side = Minecraft.getMinecraft().objectMouseOver.sideHit;
                if (side == 2) {
                    zPos += widthZ/2;
                }else if (side == 3)
                {
                    zPos -= ((float)widthZ)%2f == 0.5f ? widthZ/2+1 : widthZ/2;
                }else if (side == 4)
                {
                    xPos += widthX/2;
                }else if (side == 5)
                {
                    xPos -= ((float)widthX)%2f == 0.5f ? widthX/2+1 : widthX/2;
                }
            }
            BlockBreakingHelper.breakBlock(itemStack, world, block, xPos, yPos, zPos, entityLivingBase);
            for(int rx = xPos-widthX/2; rx< xPos-widthX/2+widthX; rx++){
                for(int ry = yPos-1; ry< yPos-1+widthY ;ry++) {
                    for(int rz = zPos-widthZ/2; rz< zPos-widthZ/2+widthZ;rz++){
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

    @Override
    public boolean func_150897_b(Block block){ return super.func_150897_b(block) || itemShovel.func_150897_b(block); }
}