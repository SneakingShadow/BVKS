package sneakingshadow.bvks.entity;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import sneakingshadow.bvks.block.BlockBVKS;
import sneakingshadow.bvks.reference.Ref;

public class EntityAwesomeCow extends EntityCreature{

    private int red = 0;
    private int blue = 0;
    private int green = 0;
    private int delay = 0;

    public static final String RED_TAG = "red";
    public static final String BLUE_TAG = "blue";
    public static final String GREEN_TAG = "green";

    public static final int size=4;

    public EntityAwesomeCow(World world)
    {
        super(world);
        this.setSize(0.9F*size, 1.3F*size);
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
        return 0.6F;
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
    }

    /**
     * Return whether this entity is invulnerable to damage.
     */
    @Override
    public boolean isEntityInvulnerable()
    {
        return true;
    }

    public void writeEntityToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeEntityToNBT(nbtTagCompound);
        nbtTagCompound.setInteger("red", this.red);
        nbtTagCompound.setInteger("blue", this.blue);
        nbtTagCompound.setInteger("green", this.green);
    }

    public void readEntityFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readEntityFromNBT(nbtTagCompound);
        this.red = nbtTagCompound.getInteger("red");
        this.blue = nbtTagCompound.getInteger("blue");
        this.green = nbtTagCompound.getInteger("green");
    }
}
