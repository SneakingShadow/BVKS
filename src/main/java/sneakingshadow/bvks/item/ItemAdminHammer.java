package sneakingshadow.bvks.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.item.base.ItemBVKSHammer;
import sneakingshadow.bvks.reference.Name;
import sneakingshadow.bvks.reference.Tool;
import sneakingshadow.bvks.util.EnchantmentHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemAdminHammer extends ItemBVKSHammer{

    public ItemAdminHammer(){
        super(Tool.ItemToolMaterial.ADMIN_HAMMER, Byte.MAX_VALUE, Byte.MAX_VALUE, Byte.MAX_VALUE, ModItems.DevilShovel);
        this.setUnlocalizedName(Name.Item.ADMIN_HAMMER);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int xPos, int yPos, int zPos, EntityLivingBase entityLivingBase) //TODO Silk touch on hammer
    {
        boolean bool = false;
        ArrayList<ItemStack> bottomlessVoids = new ArrayList<ItemStack>();
        if(entityLivingBase instanceof EntityPlayer){
            EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
            ItemStack[] itemStacks = entityPlayer.inventory.mainInventory;
            for(int i = 0; i < itemStacks.length; ++i) {
                if(itemStacks[i] != null && itemStacks[i].getItem() instanceof ItemBottomlessVoid && itemStacks[i].getItemDamage() != 0){
                    bottomlessVoids.add(itemStacks[i]);
                }
            }
            bool = !bottomlessVoids.isEmpty();
        }
        if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops") && itemStack.getItemDamage() == 1)
        {
            breakBlock(itemStack, world, block, xPos, yPos, zPos, bottomlessVoids, bool);
        }
        world.setBlockToAir(xPos, yPos, zPos);
        for(int rx = xPos -(widthX/2); rx< xPos -(widthX/2) + widthX ;rx++){
            for(int ry = yPos -1; ry< yPos -1+widthY ;ry++) {
                for(int rz = zPos -(widthZ/2); rz< zPos -(widthZ/2) + widthZ ;rz++){
                    Block blocky = world.getBlock(rx, ry, rz);
                    if (blocky.getMaterial() != Material.air && !Block.isEqualTo(blocky, Blocks.bedrock)) {
                        if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops") && itemStack.getItemDamage() == 1)
                        {
                            breakBlock(itemStack, world, blocky, rx, ry, rz, bottomlessVoids, bool);
                        }
                        world.setBlockToAir(rx, ry, rz);
                    }
                }
            }
        }

        return false;
    }

    public static void breakBlock(ItemStack itemStack, World world, Block blocky, int rx, int ry, int rz, ArrayList<ItemStack> bottomlessVoids, boolean bool){
        ArrayList<ItemStack> items = blocky.getDrops(world, rx, ry, rz, world.getBlockMetadata(rx, ry, rz), EnchantmentHelper.getLevel(Enchantment.fortune, itemStack));
        if(bool)
            for (ItemStack itemStack1 : items)
                for(ItemStack itemStack2 : bottomlessVoids) {
                    NBTTagCompound itemCompound = itemStack1.getTagCompound();
                    NBTTagCompound voidCompound = itemStack2.getTagCompound().getCompoundTag("Item");
                    if ( ItemBottomlessVoid.isItemsEqual(itemStack1, itemStack2) )
                        ItemBottomlessVoid.raiseItemCount(voidCompound, (long) itemCompound.getShort("Count"));
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
