package sneakingshadow.bvks.item.tool.obsidian;

import sneakingshadow.bvks.item.base.ItemBVKSShovel;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemObsidianShovel extends ItemBVKSShovel
{
    public ItemObsidianShovel()
    {
        super(ItemToolMaterial.OBSIDIAN);
        this.setUnlocalizedName(Names.Items.OBSIDIAN_SHOVEL);
    }
}