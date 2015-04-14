package com.sneakingshadow.bvks.item.base;

import com.sneakingshadow.bvks.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static oracle.jrockit.jfr.events.Bits.byteValue;

public class ItemBVKSHammer extends ItemBVKSPickaxe{

    private final byte widthX;
    private final byte widthY;
    private final byte widthZ;

    public ItemBVKSHammer(ToolMaterial toolMaterial, int x, int y, int z){
        super(toolMaterial);
        widthX = byteValue(x);
        widthY = byteValue(y);
        widthZ = byteValue(z);
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase player)
    {
        if ((double) block.getBlockHardness(world, x, y, z) != 0.0D) {
            itemStack.damageItem(1, player);
            for(int rx = x-( (widthX/2)-((widthX/2)%1) ); rx< x-((widthX/2)-((widthX/2)%1)) + widthX ;rx++){
                for(int ry = y-1; ry< y-1+widthY ;ry++) {
                    for(int rz = z-( (widthZ/2)-((widthZ/2)%1) ); rz< z-((widthZ/2)-((widthZ/2)%1)) + widthZ ;rz++){
                        Block blocky = world.getBlock(rx, ry, rz);
                        if ((double) blocky.getBlockHardness(world, rx, ry, rz) != 0.0D) {
                            if (blocky.getMaterial() != Material.air) {

                                blocky.dropBlockAsItemWithChance(world, rx, ry, rz, world.getBlockMetadata(rx, ry, rz), 1F, 0);
                                world.setBlockToAir(rx, ry, rz);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
