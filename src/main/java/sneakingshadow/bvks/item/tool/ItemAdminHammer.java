package sneakingshadow.bvks.item.tool;

import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.item.base.ItemBVKSStorage;
import sneakingshadow.bvks.reference.ItemToolMaterial;
import sneakingshadow.bvks.reference.Names;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Tags;
import sneakingshadow.bvks.util.EnchantmentHelper;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemAdminHammer extends ItemBVKSHammer{
    public ItemAdminHammer(){
        super(ItemToolMaterial.AdminHammer, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, ModItems.DevilShovel);
        this.setUnlocalizedName(Names.Items.AdminHammer);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
    {
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
        for(int rx = x-( (widthX/2)-((widthX/2)%1) ); rx< x-((widthX/2)-((widthX/2)%1)) + widthX ;rx++){
            for(int ry = y-1; ry< y-1+widthY ;ry++) {
                for(int rz = z-( (widthZ/2)-((widthZ/2)%1) ); rz< z-((widthZ/2)-((widthZ/2)%1)) + widthZ ;rz++){
                    Block blocky = world.getBlock(rx, ry, rz);
                    if (!Block.isEqualTo(blocky, Blocks.bedrock)) {
                        if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops") && itemStack.getItemDamage() == 1) // do not drop items while restoring blockstates, prevents item dupe
                        {
                            breakBlock(itemStack, world, entityLivingBase, blocky, rx, ry, rz, pos, storageItems, bool);
                        }
                        world.setBlockToAir(rx, ry, rz);
                    }
                }
            }
        }

        return false;
    }

    public static void breakBlock(ItemStack itemStack, World world, EntityLivingBase entityLivingBase, Block blocky, int rx, int ry, int rz, Vec3 pos, ArrayList<ItemStack> storageItems, boolean bool){
        ArrayList<ItemStack> items = blocky.getDrops(world, rx, ry, rz, world.getBlockMetadata(rx, ry, rz), EnchantmentHelper.getLevel(Enchantment.fortune, itemStack));
        for (ItemStack item1 : items)
        {
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
                        }
                    }
                }
            }
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(!world.isRemote && !world.restoringBlockSnapshots){
            itemStack.setItemDamage(itemStack.getItemDamage() == 1 ? 0 : 1);
            if(itemStack.getItemDamage() == 1) {
                entityPlayer.addChatComponentMessage(new ChatComponentText("Mined blocks will be placed in storage voids"));
            }else entityPlayer.addChatComponentMessage(new ChatComponentText("Mined blocks will be voided"));
            entityPlayer.addChatComponentMessage(new ChatComponentText("Can crash the server.. not my fault!"));
        }
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Aren't you going a little too far?..");
        list.add(itemStack.getItemDamage() == 1 ? "Mined blocks will be placed in storage voids" : "Mined blocks will not drop items");
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack)
    {
        return false;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        if(itemStack.getItemDamage() == 1)
            return super.getUnlocalizedName(itemStack) + "_active";
        return super.getUnlocalizedName(itemStack) + "_inactive";
    }

    @Override
    public boolean func_150897_b(Block block){ return true; }

    @Override
    public boolean isDamageable() { return false; }
}
