package sneakingshadow.bvks.item.armor.obsidian;

import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemObsidianHelmet extends ItemBVKSArmor
{
    public ItemObsidianHelmet()
    {
        super(Names.ArmorTextures.Obsidian, Armor.Material.Obsidian, Armor.Type.HELMET);
        this.setUnlocalizedName(Names.Items.ObsidianHelmet);
    }
}