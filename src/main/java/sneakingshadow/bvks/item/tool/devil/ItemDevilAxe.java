package sneakingshadow.bvks.item.tool.devil;

import sneakingshadow.bvks.item.base.ItemBVKSAxe;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilAxe extends ItemBVKSAxe
{
    public ItemDevilAxe()
    {
        super(ItemToolMaterial.DEVIL_AXE);
        this.setUnlocalizedName(Names.Items.DEVIL_AXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}