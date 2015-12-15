package sneakingshadow.bvks.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ServerProxy extends CommonProxy
{

    @Override
    public void registerKeyBindings() {
        //NO-OP
    }

    @Override
    public void registerCustomRender() {
        //NO-OP
    }

    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
