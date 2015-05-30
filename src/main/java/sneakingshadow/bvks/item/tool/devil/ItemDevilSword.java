package sneakingshadow.bvks.item.tool.devil;

import sneakingshadow.bvks.item.base.ItemBVKSSword;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilSword extends ItemBVKSSword
{
    public ItemDevilSword()
    {
        super(ItemToolMaterial.DEVIL_SWORD);
        this.setUnlocalizedName(Names.Items.DEVIL_SWORD);
    }

    @Override
    public boolean isDamageable() { return false; }
}