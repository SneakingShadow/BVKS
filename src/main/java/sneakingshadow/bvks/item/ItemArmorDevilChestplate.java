package sneakingshadow.bvks.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKSArmor;
import sneakingshadow.bvks.reference.Name;

import java.util.List;

public class ItemArmorDevilChestplate extends ItemBVKSArmor
{
    public ItemArmorDevilChestplate()
    {
        super(Name.Armor.DEVIL, sneakingshadow.bvks.reference.Armor.Material.DEVIL, sneakingshadow.bvks.reference.Armor.Type.CHESTPLATE);
        this.setUnlocalizedName(Name.Item.DEVIL_CHESTPLATE);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        player.fallDistance = 0F;
        player.capabilities.allowFlying = true;
    }

    @SideOnly(Side.CLIENT)
    public static void addInformation(List list){
        list.add("The hearth of a devil");
    }
}