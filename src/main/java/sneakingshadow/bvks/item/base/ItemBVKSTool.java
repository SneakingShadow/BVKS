package sneakingshadow.bvks.item.base;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;
import sneakingshadow.bvks.util.BlockBreakingHelper;

/**
 * Created by SneakingShadow on 07.12.2015.
*/
public class ItemBVKSTool extends ItemTool{

    public ItemBVKSTool(float baseDamage, ToolMaterial toolMaterial) {
        super(baseDamage, toolMaterial, null);
    }

    private boolean devilTool = false;

    public ItemBVKSTool setDevilTool() {
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
