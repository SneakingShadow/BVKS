package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSShovel;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilShovel extends ItemBVKSShovel
{
    public ItemToolDevilShovel()
    {
        super(Tool.ItemToolMaterial.DEVIL_SHOVEL);
        this.setUnlocalizedName(Name.Item.DEVIL_SHOVEL);
    }

    @Override
    public boolean isDamageable() { return false; }
}