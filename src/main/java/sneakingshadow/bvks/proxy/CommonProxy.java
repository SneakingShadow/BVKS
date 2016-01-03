package sneakingshadow.bvks.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sneakingshadow.bvks.client.gui.GuiDemonFurnace;
import sneakingshadow.bvks.inventory.ContainerDemonFurnace;
import sneakingshadow.bvks.reference.Gui;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

public abstract class CommonProxy implements IProxy
{
    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param entityPlayer The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        if (ID == Gui.ID.DEMON_FURNACE)
            return new ContainerDemonFurnace(entityPlayer.inventory, (TileEntityDemonFurnace)world.getTileEntity(x,y,z));
        return null;
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param entityPlayer The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer entityPlayer, World world, int x, int y, int z) {
        if (ID == Gui.ID.DEMON_FURNACE)
            return new GuiDemonFurnace(entityPlayer.inventory, (TileEntityDemonFurnace)world.getTileEntity(x,y,z));
        return null;
    }
}
