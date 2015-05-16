package sneakingshadow.bvks.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import sneakingshadow.bvks.block.BlockBVKS;
import sneakingshadow.bvks.reference.Ref;

import java.util.Random;

public class EntityAwesomeCow extends EntityCreature{

    public EntityAwesomeCow(World world)
    {
        super(world);
        this.setSize(0.9F, 1.3F);
    }

    /**
     * Returns true if the newer Entity AI code should be run
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
     * Returns the sound this mob makes while it's alive.
     */
    @Override
    public String getLivingSound()
    {
        return Ref.RESOURCE_PREFIX+"mob.awesomeCow";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    @Override
    public float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    @Override
    public float getBlockPathWeight(int x,int y,int z){
        if(this.worldObj.getBlock(x,y,z) instanceof BlockBVKS)
            return 100000F;
        return -1.0F;
    };

    /**
     * Return whether this entity is invulnerable to damage.
     */
    @Override
    public boolean isEntityInvulnerable()
    {
        return true;
    }
}
