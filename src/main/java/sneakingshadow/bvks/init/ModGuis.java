package sneakingshadow.bvks.init;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import sneakingshadow.bvks.client.gui.GuiBottomlessVoid;
import sneakingshadow.bvks.client.gui.GuiDemonFurnace;
import sneakingshadow.bvks.gui.GuiBVKS;
import sneakingshadow.bvks.handler.GuiHandler;
import sneakingshadow.bvks.inventory.ContainerBottomlessVoid;
import sneakingshadow.bvks.inventory.ContainerDemonFurnace;
import sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;

public class ModGuis {

    public static GuiBVKS guiDemonFurnace = new GuiBVKS() {
        @Override
        public Object getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new ContainerDemonFurnace(entityPlayer.inventory, (TileEntityDemonFurnace)world.getTileEntity(x,y,z));
        }

        @Override
        public Object getGui(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new GuiDemonFurnace((ContainerDemonFurnace) this.getContainer(entityPlayer, world, x, y, z));
        }
    };
    public static GuiBVKS guiBottomlessVoid = new GuiBVKS() {
        @Override
        public Object getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new ContainerBottomlessVoid(entityPlayer, x);
        }

        @Override
        public Object getGui(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new GuiBottomlessVoid(entityPlayer, x);
        }
    };

    public static void init(){
        GuiHandler.registerGUI(guiDemonFurnace);
        GuiHandler.registerGUI(guiBottomlessVoid);
    }

}
