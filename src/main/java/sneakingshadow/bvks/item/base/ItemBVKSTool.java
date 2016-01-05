package sneakingshadow.bvks.item.base;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

/**
 * Created by SneakingShadow on 07.12.2015.
*/
public class ItemBVKSTool extends ItemBVKS{

    private int maxUses;
    private float efficiencyOnProperMaterial;
    private float damageVsEntity;
    private int enchantability;

    public ItemBVKSTool(int maxUses, float efficiencyOnProperMaterial, float damageVsEntity, int enchantability) {
        this.setMaxDamage(maxUses);

    }

    public ItemBVKSTool setPickaxe(int level) {
        this.setHarvestLevel("pickaxe", level);
        return this;
    }
    public ItemBVKSTool setAxe(int level) {
        this.setHarvestLevel("axe", level);
        return this;
    }
    public ItemBVKSTool setShovel(int level) {
        this.setHarvestLevel("shovel", level);
        return this;
    }
    public ItemBVKSTool setSword() {
        this.setHarvestLevel("sword", 0);
        return this;
    }


    /**
     * ItemStack sensitive version of getItemEnchantability
     *
     * @param stack The ItemStack
     * @return the item echantability value
     */
    public int getItemEnchantability(ItemStack stack)
    {
        /**
         * Return the enchantability factor of the item, most of the time is based on material.
         */
        return getItemEnchantability();
    }

    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
            return efficiencyOnProperMaterial;
        }
        return super.getDigSpeed(stack, block, meta);
    }

}
