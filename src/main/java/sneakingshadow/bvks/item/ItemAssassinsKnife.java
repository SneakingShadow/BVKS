package sneakingshadow.bvks.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.base.ItemBVKS;
import sneakingshadow.bvks.reference.Name;

public class ItemAssassinsKnife extends ItemBVKS {
    public ItemAssassinsKnife() {
        super(Name.Item.ASSASSINS_KNIFE);
        this.setMaxStackSize(1);
        this.setFull3D();
    }

    /**
     * @param itemStack
     * @param world
     * @param entity
     * @param position      What position in the main inventory the item is in.
     * @param currentItem   Checks if it's the held item.
     * */
    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int position, boolean currentItem){
        if (entity instanceof EntityPlayer && entity.isSneaking()) {
            ((EntityPlayer)entity).addPotionEffect(new PotionEffect(Potion.invisibility.getId(), 2, 0, true));
        }
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        entity.setDead();
        return true;
    }

}
