package sneakingshadow.bvks.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sneakingshadow.bvks.gui.GuiBVKS;

import java.util.ArrayList;

public class GuiHandler implements IGuiHandler {

    private static ArrayList<GuiBVKS> guiList = new ArrayList<GuiBVKS>();

    public static void registerGUI(GuiBVKS gui) {
        gui.setID(guiList.size());
        guiList.add(gui);
    }

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
        if (ID < guiList.size())
            return guiList.get(ID).getContainer(entityPlayer, world, x, y, z);
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
        if (ID < guiList.size())
            return guiList.get(ID).getGui(entityPlayer, world, x, y, z);
        return null;
    }

}