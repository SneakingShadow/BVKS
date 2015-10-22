package sneakingshadow.bvks.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Names;

import java.util.List;

public class ItemDevilGem extends ItemBVKS
{
    public ItemDevilGem()
    {
        super();
        this.setUnlocalizedName(Names.Items.DEVIL_GEM);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Bru");
    }

}
