package sneakingshadow.bvks.item.tool.devil;

import sneakingshadow.bvks.item.base.ItemBVKSSword;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilSword extends ItemBVKSSword
{
    public ItemDevilSword()
    {
        super(ItemToolMaterial.DevilSword);
        this.setUnlocalizedName(Names.Items.DevilSword);
    }

    @Override
    public boolean isDamageable() { return false; }
}