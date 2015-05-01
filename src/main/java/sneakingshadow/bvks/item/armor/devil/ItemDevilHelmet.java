package sneakingshadow.bvks.item.armor.devil;

import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDevilHelmet extends ItemBVKSArmor
{
    public ItemDevilHelmet()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.HELMET);
        this.setUnlocalizedName(Names.Items.DevilHelmet);
        this.setInvisible();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.setAir(300);
        player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 11, 12, true));
    }
}