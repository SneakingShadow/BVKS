package sneakingshadow.bvks.item.base;

import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

/**
 * Created by SneakingShadow on 07.12.2015.
*/
public class ItemBVKSTool extends ItemBVKS{

    private float efficiencyOnProperMaterial;
    private float damageVsEntity;
    private int enchantability;

    public ItemBVKSTool(String unlocalizedName, int maxUses, float efficiencyOnProperMaterial, float damageVsEntity, int enchantability) {
        super(unlocalizedName);
        this.setMaxDamage(maxUses);
        this.enchantability = enchantability;
        this.damageVsEntity = damageVsEntity;
        this.efficiencyOnProperMaterial = efficiencyOnProperMaterial;
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabAllSearch);
    }
    public ItemBVKSTool (String unlocalizedName, ToolMaterial toolMaterial, float damageBoost) {
        this(unlocalizedName, toolMaterial.getMaxUses(), toolMaterial.getEfficiencyOnProperMaterial(), toolMaterial.getDamageVsEntity() + damageBoost, toolMaterial.getEnchantability());
    }
    public ItemBVKSTool (String unlocalizedName) {
        this(unlocalizedName,1,0,0,0);
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
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability()
    {
        return enchantability;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }
    public float getEfficiencyOnProperMaterial(ItemStack itemStack) {
        return getEfficiencyOnProperMaterial();
    }

    /**
     * Damage versus entities.
     */
    public float getDamageVsEntity()
    {
        return this.damageVsEntity;
    }
    public float getDamageVsEntity(ItemStack itemStack)
    {
        return this.getDamageVsEntity();
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityLivingBase entityPlayer)
    {
        itemStack.damageItem(this.getHarvestLevel(itemStack, "sword") != -1 ? 1 : 2, entityPlayer);
        return true;
    }

    @Override
    public float getDigSpeed(ItemStack itemStack, Block block, int metadata)
    {
        if (ForgeHooks.isToolEffective(itemStack, block, metadata) || this.getHarvestLevel(itemStack, "sword") != -1 && block == Blocks.web)
        {
            return this.getEfficiencyOnProperMaterial(itemStack);
        }
        return super.getDigSpeed(itemStack, block, metadata);
    }

    /**
     * Gets a map of item attribute modifiers, used by ItemSword to increase hit damage.
     */
    @Override
    public Multimap getAttributeModifiers(ItemStack itemStack)
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.getDamageVsEntity(itemStack), 0));
        return multimap;
    }

}
