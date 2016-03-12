package sneakingshadow.bvks.item;

import sneakingshadow.bvks.item.base.ItemBVKSSword;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Tool;

public class ItemToolDevilSword extends ItemBVKSSword
{
    public ItemToolDevilSword()
    {
        super(Name.Item.DEVIL_SWORD, Tool.ItemToolMaterial.DEVIL_SWORD);
    }

    @Override
    public boolean isDamageable() { return false; }
}