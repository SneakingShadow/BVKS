package sneakingshadow.bvks.util;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.ItemBottomlessVoid;

import java.util.ArrayList;

public class BlockBreakingHelper {

    public static void breakBlock(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase){

        ArrayList<ItemStack> storageItems = new ArrayList<ItemStack>();
        if(entityLivingBase instanceof EntityPlayer){
            for(ItemStack itemStack1 : ((EntityPlayer) entityLivingBase).inventory.mainInventory) {
                if (itemStack1 != null && itemStack1.getItemDamage() != 0 && itemStack1.getItem() instanceof ItemBottomlessVoid) {
                    storageItems.add(itemStack1);
                }
            }
        }

        Vec3 pos = entityLivingBase.getPosition(1F);

        if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops")){
            ArrayList<ItemStack> itemStacks = block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), EnchantmentHelper.getLevel(Enchantment.fortune, itemStack));
            Boolean bool = false;
            for (ItemStack itemStack1 : itemStacks)
            {
                if (!storageItems.isEmpty()){
                    for(ItemStack itemStack2 : storageItems){
                        NBTTagCompound voidCompound = itemStack2.getTagCompound();
                        if ( ItemStack.loadItemStackFromNBT(voidCompound.getCompoundTag("Item")).isItemEqual(itemStack1) ) {
                            voidCompound.setLong("Count", voidCompound.getLong("Count" + itemStack1.stackSize));
                            bool = true;
                        }
                    }
                }

                if (!bool && entityLivingBase instanceof EntityPlayer && ((EntityPlayer) entityLivingBase).inventory.addItemStackToInventory(itemStack1)) {
                    bool = true;
                }

                if (!bool) {
                    EntityItem entityItem = new EntityItem(world, pos.xCoord, pos.yCoord + 0.2F, pos.zCoord, itemStack1);
                    entityItem.delayBeforeCanPickup = 0;
                    entityItem.motionX = 0D;
                    entityItem.motionY = 0D;
                    entityItem.motionZ = 0D;
                    world.spawnEntityInWorld(entityItem);
                }
            }
        }
        world.setBlockToAir(x, y, z);
    }
}