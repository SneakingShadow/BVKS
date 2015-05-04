package sneakingshadow.bvks.item.armor.devil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Armor;
import sneakingshadow.bvks.reference.Names;

public class ItemDevilChestplate extends ItemBVKSArmor
{
    public ItemDevilChestplate()
    {
        super(Names.ArmorTextures.Devil, Armor.Material.Devil, Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Names.Items.DevilChestplate);
        this.setInvisible();
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.capabilities.allowFlying = true;
    }
}