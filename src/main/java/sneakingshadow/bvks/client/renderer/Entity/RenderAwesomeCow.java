package sneakingshadow.bvks.client.renderer.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import sneakingshadow.bvks.client.model.ModelAwesomeCow;
import sneakingshadow.bvks.entity.EntityAwesomeCow;
import sneakingshadow.bvks.reference.Ref;

@SideOnly(Side.CLIENT)
public class RenderAwesomeCow extends RenderLiving
{
    private ResourceLocation cowTextures;

    public RenderAwesomeCow()
    {
        super(new ModelAwesomeCow(), 0.5F);
        this.cowTextures = new ResourceLocation(Ref.RESOURCE_PREFIX+"textures/entity/awesome_cow.png");
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
        // some people do some G11 transformations or blends here, like you can do
        // GL11.glScalef(2F, 2F, 2F); to scale up the entity
        // which is used for Slime entities.  I suggest having the entity cast to
        // your custom type to make it easier to access fields from your
        // custom entity, eg. GL11.glScalef(entity.scaleFactor, entity.scaleFactor,
        // entity.scaleFactor);
    }
}