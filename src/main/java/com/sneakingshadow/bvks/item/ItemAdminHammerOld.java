package com.sneakingshadow.bvks.item;

import com.sneakingshadow.bvks.item.item.ItemBVKSHammerOld;
import com.sneakingshadow.bvks.reference.Name;
import com.sneakingshadow.bvks.reference.Tool;
import com.sneakingshadow.core.util.EnchantmentHelper;
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

import java.util.ArrayList;
import java.util.List;

public class ItemAdminHammerOld extends ItemBVKSHammerOld {

    public ItemAdminHammerOld(){
        super(Name.Item.ADMIN_HAMMER, Tool.ItemToolMaterial.ADMIN_HAMMER, Byte.MAX_VALUE);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add("Aren't you going a little too far?..");
        list.add(itemStack.getItemDamage() == 1 ?
                "Mined blocks will be placed in bottomless voids" :
                "Mined blocks will not drop items" );
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int xPos, int yPos, int zPos, EntityLivingBase entityLivingBase)
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
        for(int rx = xPos -(this.size/2); rx< xPos -(this.size/2) + this.size ;rx++){
            for(int ry = yPos -1; ry< yPos -1+this.size ;ry++) {
                for(int rz = zPos -(this.size/2); rz< zPos -(this.size/2) + this.size ;rz++){
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
                    NBTTagCompound voidCompound = itemStack2.getTagCompound();
                    if ( ItemStack.loadItemStackFromNBT(voidCompound.getCompoundTag("Item")).isItemEqual(itemStack1) )
                        voidCompound.setLong("Count", voidCompound.getLong("Count" + itemStack1.stackSize));
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
