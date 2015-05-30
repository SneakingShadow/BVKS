package sneakingshadow.bvks.item.armor.devil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilBoots extends ItemBVKSArmor
{
    public ItemDevilBoots()
    {
        super(Names.ArmorTextures.DEVIL, Armor.Material.DEVIL, Armor.Type.BOOTS);
        this.setUnlocalizedName(Names.Items.DEVIL_BOOTS);
        this.setInvisible();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.addPotionEffect(new PotionEffect(Potion.jump.getId(),0,3,true));
    }
}
