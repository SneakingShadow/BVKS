package sneakingshadow.bvks.item;

import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.item.base.ItemBVKSTool;
import sneakingshadow.bvks.reference.Tool;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by SneakingShadow on 11.03.2016.
 */
public class ItemHammer extends ItemBVKSTool {

    public ItemHammer(String unlocalizedName) {
        super(unlocalizedName);
    }

    /**
     * The 'ids' of the tool classes that the hammer CAN contain. The containment of tool classes is in the metadata.
     */
    String[] toolClasses = {"sword", "pickaxe", "axe", "shovel"};

    private boolean hasClass(ItemStack itemStack, int toolClassID) {
        return ( itemStack.getItemDamage() & (int)Math.pow(2,12-toolClasses.length+toolClassID) ) != 0;
    }

    /**
     * Queries the harvest level of this item stack for the specifred tool class,
     * Returns -1 if this tool is not of the specified type
     *
     * @param itemStack This item stack instance
     * @param toolClass Tool Class
     * @return Harvest level, or -1 if not the specified tool type.
     */
    @Override
    public int getHarvestLevel(ItemStack itemStack, String toolClass)
    {
        for (int i=0; i<toolClasses.length; i++)
            if ( toolClasses[i].equals(toolClass) && this.hasClass(itemStack, i) && itemStack.getTagCompound() != null)
                return itemStack.getTagCompound().getShort(toolClass);
        return -1;
    }

    public Set<String> getToolClasses(ItemStack itemStack)
    {
        HashMap<String, Integer> ret = new HashMap<String, Integer>();
        for (int i = 0 ; i < toolClasses.length ; i++ )
            if ( this.hasClass(itemStack, i) )
                ret.put(toolClasses[i], 0);

        return ret.keySet();
    }



    ToolMaterial[] toolMaterials = {
            ToolMaterial.WOOD, ToolMaterial.STONE, ToolMaterial.IRON,
            ToolMaterial.GOLD, ToolMaterial.EMERALD,
            Tool.ItemToolMaterial.OBSIDIAN, Tool.ItemToolMaterial.DEVIL_HAMMER
    };

    private ToolMaterial getMaterial(ItemStack itemStack) {
        int metadata = itemStack.getItemDamage() & (int)Math.pow(2, 12-this.toolClasses.length)-1;
        return metadata >= this.toolMaterials.length ? this.toolMaterials[metadata] : ToolMaterial.WOOD;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability(ItemStack itemStack)
    {
        return this.getMaterial(itemStack).getEnchantability();
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial(ItemStack itemStack) {
        return this.getMaterial(itemStack).getEfficiencyOnProperMaterial();
    }

    /**
     * Damage versus entities.
     */
    public float getDamageVsEntity(ItemStack itemStack)
    {
        return this.getMaterial(itemStack).getDamageVsEntity();
    }


}
