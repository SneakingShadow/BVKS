package com.sneakingshadow.bvks.item.tool;

import com.sneakingshadow.bvks.item.base.ItemBVKSHammer;
import com.sneakingshadow.bvks.item.base.ItemBVKSPickaxe;
import com.sneakingshadow.bvks.reference.ItemToolMaterial;
import com.sneakingshadow.bvks.reference.Names;
import com.sneakingshadow.bvks.util.EnchantmentHelper;
import com.sneakingshadow.bvks.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemAdminHammer extends ItemBVKSPickaxe{
    private boolean dropItems = false;

    private final byte widthX = Byte.MAX_VALUE;
    private final byte widthY = Byte.MAX_VALUE;
    private final byte widthZ = Byte.MAX_VALUE;

    public ItemAdminHammer() {
        super(ItemToolMaterial.AdminHammer);
        this.setUnlocalizedName(Names.Items.AdminHammer);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityPlayer)
    {
        if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) {
            if(this.func_150897_b(block)){
                Vec3 pos = entityPlayer.getPosition(1F);
                for(int rx = x-( (widthX/2)-((widthX/2)%1) ); rx< x-((widthX/2)-((widthX/2)%1)) + widthX ;rx++){
                    for(int ry = y-1; ry< y-1+widthY ;ry++) {
                        for(int rz = z-( (widthZ/2)-((widthZ/2)%1) ); rz< z-((widthZ/2)-((widthZ/2)%1)) + widthZ ;rz++){
                            Block blocky = world.getBlock(rx, ry, rz);
                            if ((double) blocky.getBlockHardness(world, rx, ry, rz) != 0.0D) {
                                if (blocky.getMaterial() != Material.air && this.func_150897_b(blocky)){
                                    if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops") && dropItems) // do not drop items while restoring blockstates, prevents item dupe
                                    {
                                        ArrayList<ItemStack> items = blocky.getDrops(world, rx, ry, rz, world.getBlockMetadata(rx, ry, rz), 0);

                                        for (ItemStack item : items)
                                        {
                                            EntityItem entityItem = new EntityItem(world, pos.xCoord, pos.yCoord+0.2F, pos.zCoord, item);
                                            entityItem.delayBeforeCanPickup = 0;
                                            entityItem.motionX = 0D;
                                            entityItem.motionY = 0D;
                                            entityItem.motionZ = 0D;
                                            world.spawnEntityInWorld(entityItem);
                                        }
                                    }
                                    world.setBlockToAir(rx, ry, rz);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
        if(!world.isRemote && !world.restoringBlockSnapshots){
            this.dropItems = !this.dropItems;
            if(dropItems) {
                entityPlayer.addChatComponentMessage(new ChatComponentText("Hammer will drop items when mining blocks"));
                entityPlayer.addChatComponentMessage(new ChatComponentText("Aka. crash the server.. not my fault!"));
            }else entityPlayer.addChatComponentMessage(new ChatComponentText("Hammer will not drop items when mining blocks"));
        }
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Aren't you going a little too far?..");
        if(this.dropItems) list.add("Mined blocks will drop items"); else list.add("Mined blocks will not drop items");
    }
}
