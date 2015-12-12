package sneakingshadow.bvks.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDebugBlock extends TileEntity{

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

    }

    @Override
    public void updateEntity() {

    }

    /**
     * Determines if this TileEntity requires update calls.
     * @return True if you want updateEntity() to be called, false if not
     */
    public boolean canUpdate()
    {
        return true;
    }

    /**
     * Called when the chunk this TileEntity is on is Unloaded.
     */
    public void onChunkUnload()
    {

    }
}
