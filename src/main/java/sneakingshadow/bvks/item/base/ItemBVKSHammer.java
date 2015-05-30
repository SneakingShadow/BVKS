package sneakingshadow.bvks.item.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sneakingshadow.bvks.util.BlockBreakingHelper;

import java.util.ArrayList;

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

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase) //TODO Silk touch on hammers
    {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D && this.isDamageable())
        {
            itemStack.damageItem(1, entityLivingBase);
        }
        if(this.func_150897_b(block)){
            Vec3 pos = entityLivingBase.getPosition(1F);
            ArrayList<ItemStack> storageItems = BlockBreakingHelper.getBottomlessVoidList(entityLivingBase);

            BlockBreakingHelper.breakBlock(itemStack, world, block, x, y, z, pos, storageItems);
            for(int rx = x-widthX/2; rx< x-widthX/2+widthX; rx++){
                for(int ry = y-1; ry< y-1+widthY ;ry++) {
                    for(int rz = z-widthZ/2; rz< z-widthZ/2+widthZ;rz++){
                        Block blocky = world.getBlock(rx, ry, rz);
                        if (blocky.getMaterial() != Material.air && (this.func_150897_b(blocky) || blocky.getHarvestLevel(blocky.getDamageValue(world, rx, ry, rz)) == 0) && blocky.getBlockHardness(world,rx,ry,rz) != -1.0F) {
                            BlockBreakingHelper.breakBlock(itemStack, world, blocky, rx, ry, rz, pos, storageItems);
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