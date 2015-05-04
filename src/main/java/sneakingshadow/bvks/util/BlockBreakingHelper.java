package sneakingshadow.bvks.util;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import sneakingshadow.bvks.item.ItemBottomlessVoid;

import java.util.ArrayList;

public class BlockBreakingHelper {

    /**
     *
     * @param itemStack
     * @param world
     * @param block
     * @param x
     * @param y
     * @param z
     * @param pos
     * @param storageItems   Empty list and it will not be used
     */
    public static void breakBlock(ItemStack itemStack, World world, Block block, int x, int y, int z, Vec3 pos, ArrayList<ItemStack> storageItems){
        if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops")){
            ArrayList<ItemStack> items = block.getDrops(world, x, y, z, world.getBlockMetadata(x, y, z), EnchantmentHelper.getLevel(Enchantment.fortune, itemStack));
            Boolean bool2;
            for (ItemStack item1 : items)
            {
                bool2 = true;
                if(!storageItems.isEmpty()){
                    for(ItemStack item2 : storageItems){
                        if (ItemBottomlessVoid.getStackTagNull(item2) ? item1.stackTagCompound == null : item1.stackTagCompound != null) {
                            boolean flag = true;
                            if (item1.stackTagCompound != null) {
                                ItemBottomlessVoid.getStackTag(item2).setByte("Count", item1.stackTagCompound.getByte("Count"));
                                if (!ItemBottomlessVoid.getStackTag(item2).equals(item1.stackTagCompound))
                                    flag = false;
                            }
                            if (flag && ItemBottomlessVoid.getItem(item2).equals(item1.getItem())) {
                                ItemBottomlessVoid.add(item2, item1.stackSize);
                                bool2 = false;
                            }
                        }
                    }
                }
                if(bool2) {
                    EntityItem entityItem = new EntityItem(world, pos.xCoord, pos.yCoord + 0.2F, pos.zCoord, item1);
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

    public static ArrayList<ItemStack> getBottomlessVoidList(EntityLivingBase entityLivingBase){
        ArrayList<ItemStack> storageItems = new ArrayList<ItemStack>();
        if(entityLivingBase instanceof EntityPlayer){
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            InventoryPlayer inventory = entityPlayer.inventory;
            for(int i = 0; i < inventory.mainInventory.length; ++i) {
                if (inventory.mainInventory[i] != null && inventory.mainInventory[i].getItemDamage() != 0 && inventory.mainInventory[i].getItem() instanceof ItemBottomlessVoid) {
                    storageItems.add(inventory.mainInventory[i]);
                }
            }
        }
        return storageItems;
    }
}
