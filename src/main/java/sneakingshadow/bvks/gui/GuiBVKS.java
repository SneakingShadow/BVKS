package sneakingshadow.bvks.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class GuiBVKS {

    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    abstract public Object getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z);

    abstract public Object getGui(EntityPlayer entityPlayer, World world, int x, int y, int z);

}
