package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSAxe;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilAxe extends ItemBVKSAxe
{
    public ItemToolDevilAxe()
    {
        super(Tool.ItemToolMaterial.DEVIL_AXE);
        this.setUnlocalizedName(Name.Item.DEVIL_AXE);
    }

    @Override
    public boolean isDamageable() { return false; }
}