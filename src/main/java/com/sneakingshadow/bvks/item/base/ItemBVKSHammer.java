package com.sneakingshadow.bvks.item.base;

import com.sneakingshadow.bvks.util.EnchantmentHelper;
import com.sneakingshadow.bvks.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.ArrayList;

import static oracle.jrockit.jfr.events.Bits.byteValue;

public class ItemBVKSHammer extends ItemBVKSPickaxe{

    public final byte widthX;
    public final byte widthY;
    public final byte widthZ;

    public ItemBVKSHammer(ToolMaterial toolMaterial, int x, int y, int z){
        super(toolMaterial);
        widthX = (byte) x;
        widthY = (byte) y;
        widthZ = (byte) z;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityPlayer)
    {
        LogHelper.info("Hammers!!!");
        LogHelper.info(itemStack.getEnchantmentTagList());
        if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) {
            itemStack.damageItem(1, entityPlayer);
            if(this.func_150897_b(block)){
                Vec3 pos = entityPlayer.getPosition(1F);
                for(int rx = x-( (widthX/2)-((widthX/2)%1) ); rx< x-((widthX/2)-((widthX/2)%1)) + widthX ;rx++){
                    for(int ry = y-1; ry< y-1+widthY ;ry++) {
                        for(int rz = z-( (widthZ/2)-((widthZ/2)%1) ); rz< z-((widthZ/2)-((widthZ/2)%1)) + widthZ ;rz++){
                            Block blocky = world.getBlock(rx, ry, rz);
                            if ((double) blocky.getBlockHardness(world, rx, ry, rz) != 0.0D) {
                                if (blocky.getMaterial() != Material.air && this.func_150897_b(blocky)){
                                    if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) // do not drop items while restoring blockstates, prevents item dupe
                                    {
                                        ArrayList<ItemStack> items = blocky.getDrops(world, rx, ry, rz, world.getBlockMetadata(rx, ry, rz), EnchantmentHelper.getLevel(Enchantment.fortune, itemStack));

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
}
