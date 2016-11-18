package com.sneakingshadow.bvks.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityMiniSteve extends EntityLivingBase { //just for testing purposes

    private float size = 1.0F/16.0F;

    public EntityMiniSteve(World world) {
        super(world);
        this.setSize(0.6F*size, 1.8F*size);
    }

    @Override
    public ItemStack getHeldItem() {
        return null;
    }

    @Override
    public ItemStack getEquipmentInSlot(int p_71124_1_) {
        return null;
    }

    @Override
    public void setCurrentItemOrArmor(int p_70062_1_, ItemStack p_70062_2_) {

    }

    @Override
    public ItemStack[] getLastActiveItems() {
        return new ItemStack[0];
    }

    /**
     * Returns true if the newer entity AI code should be run
     */
    @Override
    public boolean isAIEnabled()
    {
        return false;
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    /**
     * Return whether this entity is invulnerable to damage.
     */
    @Override
    public boolean isEntityInvulnerable()
    {
        return false;
    }


}
