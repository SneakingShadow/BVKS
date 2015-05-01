package sneakingshadow.bvks.item.base;


import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Tags;
import sneakingshadow.bvks.util.EnchantmentHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ItemBVKSHammer extends ItemBVKSPickaxe{

    public final byte widthX;
    public final byte widthY;
    public final byte widthZ;
    private static Item itemShovel;

    public ItemBVKSHammer(ToolMaterial toolMaterial, int x, int y, int z, Item shovel){
        super(toolMaterial);
        widthX = (byte) x;
        widthY = (byte) y;
        widthZ = (byte) z;
        itemShovel = shovel;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
    {
        if ((double)block.getBlockHardness(world, x, y, z) != 0.0D && this.isDamageable())
        {
            itemStack.damageItem(1, entityLivingBase);
        }
        if((this.func_150897_b(block) || itemShovel.func_150897_b(block))){
            Vec3 pos = entityLivingBase.getPosition(1F);
            boolean bool = false;
            ArrayList<ItemStack> storageItems = new ArrayList<ItemStack>();
            if(entityLivingBase instanceof EntityPlayer){
                EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
                InventoryPlayer inventory = entityPlayer.inventory;
                for(int i = 0; i < inventory.mainInventory.length; ++i) {
                    if(inventory.mainInventory[i] != null && inventory.mainInventory[i].getItem() instanceof ItemBVKSStorage){
                        storageItems.add(inventory.mainInventory[i]);
                    }
                }
                bool = !storageItems.isEmpty();
            }
            breakBlock(itemStack, world, entityLivingBase, block, x, y, z, pos, storageItems, bool);
            world.setBlockToAir(x, y, z);
            for(int rx = x-( (widthX/2)-((widthX/2)%1) ); rx< x-((widthX/2)-((widthX/2)%1)) + widthX ;rx++){
                for(int ry = y-1; ry< y-1+widthY ;ry++) {
                    for(int rz = z-( (widthZ/2)-((widthZ/2)%1) ); rz< z-((widthZ/2)-((widthZ/2)%1)) + widthZ ;rz++){
                        Block blocky = world.getBlock(rx, ry, rz);
                        if (blocky.getMaterial() != Material.air && (this.func_150897_b(blocky) || blocky.getHarvestLevel(blocky.getDamageValue(world, rx, ry, rz)) == 0) && !Block.isEqualTo(blocky, Blocks.bedrock)) {
                            if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) // do not drop items while restoring blockstates, prevents item dupe
                            {
                                breakBlock(itemStack, world, entityLivingBase, blocky, rx, ry, rz, pos, storageItems, bool);
                            }
                            world.setBlockToAir(rx, ry, rz);
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void breakBlock(ItemStack itemStack, World world, EntityLivingBase entityLivingBase, Block blocky, int rx, int ry, int rz, Vec3 pos, ArrayList<ItemStack> storageItems, boolean bool){
        ArrayList<ItemStack> items = blocky.getDrops(world, rx, ry, rz, world.getBlockMetadata(rx, ry, rz), EnchantmentHelper.getLevel(Enchantment.fortune, itemStack));
        Boolean bool2;
        for (ItemStack item1 : items)
        {
            bool2 = true;
            if(bool){
                for(ItemStack item2 : storageItems){
                    ItemBVKSStorage.setupTags(item2);
                    NBTTagCompound storageTag = item2.stackTagCompound.getCompoundTag(Ref.MOD_ID).getCompoundTag(Tags.Storage.info);

                    if ((storageTag.getBoolean(Tags.Storage.stackTagNull) ? item1.stackTagCompound == null : item1.stackTagCompound != null)) {
                        boolean flag = true;
                        if (item1.stackTagCompound != null) {
                            storageTag.getCompoundTag(Tags.Storage.stackTag).setByte("Count", item1.stackTagCompound.getByte("Count"));
                            if (!storageTag.getCompoundTag(Tags.Storage.stackTag).equals(item1.stackTagCompound))
                                flag = false;
                        }
                        if (flag && Item.getItemById(storageTag.getInteger(Tags.Storage.id)).equals(item1.getItem())) {
                            storageTag.setLong(Tags.Storage.storedAmount, storageTag.getLong(Tags.Storage.storedAmount) + item1.stackSize);
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

    @Override
    public boolean func_150897_b(Block block){ return super.func_150897_b(block) || itemShovel.func_150897_b(block); }
}