package sneakingshadow.bvks.item.tool.hammer;

import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemDevilHammer extends ItemBVKSHammer
{
    public ItemDevilHammer()
    {
        super(ItemToolMaterial.DevilHammer, 9, 9, 9, ModItems.DevilShovel);
        this.setUnlocalizedName(Names.Items.DevilHammer);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("The devil has a taste for worlds");
    }

    @Override
    public boolean isDamageable() { return false; }
}