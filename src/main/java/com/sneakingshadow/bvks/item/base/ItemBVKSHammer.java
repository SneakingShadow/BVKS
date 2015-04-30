package com.sneakingshadow.bvks.item.base;

import com.sneakingshadow.bvks.item.ItemDebugItem;
import com.sneakingshadow.bvks.util.EnchantmentHelper;
import com.sneakingshadow.bvks.util.LogHelper;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
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
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.List;

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
        if((this.func_150897_b(block) || itemShovel.func_150897_b(block))){
            Vec3 pos = entityLivingBase.getPosition(1F);
            for(int rx = x-( (widthX/2)-((widthX/2)%1) ); rx< x-((widthX/2)-((widthX/2)%1)) + widthX ;rx++){
                for(int ry = y-1; ry< y-1+widthY ;ry++) {
                    for(int rz = z-( (widthZ/2)-((widthZ/2)%1) ); rz< z-((widthZ/2)-((widthZ/2)%1)) + widthZ ;rz++){
                        Block blocky = world.getBlock(rx, ry, rz);
                        if (blocky.getMaterial() != Material.air && (this.func_150897_b(blocky) || itemShovel.func_150897_b(blocky) || blocky.getHarvestLevel(blocky.getDamageValue(world, rx, ry, rz)) == 0) && !Block.isEqualTo(blocky, Blocks.bedrock)) {
                            if (!world.isRemote && !world.restoringBlockSnapshots && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) // do not drop items while restoring blockstates, prevents item dupe
                            {
                                ArrayList<ItemStack> items = blocky.getDrops(world, rx, ry, rz, world.getBlockMetadata(rx, ry, rz), EnchantmentHelper.getLevel(Enchantment.fortune, itemStack));

                                if(entityLivingBase instanceof EntityPlayer){
                                    EntityPlayer entityPlayer = (EntityPlayer)entityLivingBase;
                                    InventoryPlayer inventory = entityPlayer.inventory;
                                    ArrayList<ItemStack> storageItems = new ArrayList<ItemStack>();
                                    for(int i = 0; i < inventory.mainInventory.length; ++i) {
                                        if(inventory.mainInventory[i] != null && inventory.mainInventory[i].getItem() instanceof ItemBVKSStorage){
                                            storageItems.add(inventory.mainInventory[i]);
                                        }
                                    }
                                    boolean bool = true;
                                }

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

        return true;
    }
}
