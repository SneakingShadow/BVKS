package sneakingshadow.bvks.item.armor.obsidian;

import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemObsidianLeggings extends ItemBVKSArmor
{
    public ItemObsidianLeggings()
    {
        super(Names.ArmorTextures.Obsidian, Armor.Material.Obsidian, Armor.Type.LEGGINGS);
        this.setUnlocalizedName(Names.Items.ObsidianLeggings);
    }
}