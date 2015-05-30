package sneakingshadow.bvks.item.armor.obsidian;

import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemObsidianLeggings extends ItemBVKSArmor
{
    public ItemObsidianLeggings()
    {
        super(Names.ArmorTextures.OBSIDIAN, Armor.Material.OBSIDIAN, Armor.Type.LEGGINGS);
        this.setUnlocalizedName(Names.Items.OBSIDIAN_LEGGINGS);
    }
}