package com.sneakingshadow.bvks.client.renderer.entity;

import com.sneakingshadow.bvks.entity.EntityAwesomeCow;
import com.sneakingshadow.bvks.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import com.sneakingshadow.bvks.client.model.ModelAwesomeCow;

@SideOnly(Side.CLIENT)
public class EntityRenderAwesomeCow extends RenderLiving
{
    public static final int size= EntityAwesomeCow.size;

    private ResourceLocation cowTextures;

    public EntityRenderAwesomeCow()
    {
        super(new ModelAwesomeCow(), 0.5F);
        this.cowTextures = new ResourceLocation(Reference.RESOURCE_PREFIX+"textures/entity/awesome_cow.png");
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.cowTextures;
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float f)
    {
        preRenderCallback((EntityAwesomeCow) entity, f);
    }

    protected void preRenderCallback(EntityAwesomeCow entity, float f)
    {
        GL11.glScalef(size, size, size);
    }
}