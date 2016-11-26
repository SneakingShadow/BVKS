package com.sneakingshadow.bvks.init;

import com.sneakingshadow.bvks.client.gui.GuiBottomlessVoid;
import com.sneakingshadow.bvks.client.gui.GuiDemonFurnace;
import com.sneakingshadow.bvks.client.gui.GuiHammerWorkbench;
import com.sneakingshadow.bvks.gui.GuiBVKS;
import com.sneakingshadow.bvks.handler.GuiHandler;
import com.sneakingshadow.bvks.inventory.ContainerBottomlessVoid;
import com.sneakingshadow.bvks.inventory.ContainerDemonFurnace;
import com.sneakingshadow.bvks.inventory.ContainerHammerWorkbench;
import com.sneakingshadow.bvks.tileentity.TileEntityDemonFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ModGuis {

    public static GuiBVKS guiDemonFurnace = new GuiBVKS()
    {
        @Override
        public Container getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new ContainerDemonFurnace(entityPlayer.inventory, (TileEntityDemonFurnace)world.getTileEntity(x,y,z));
        }

        @Override
        public GuiContainer getGui(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new GuiDemonFurnace((ContainerDemonFurnace) this.getContainer(entityPlayer, world, x, y, z));
        }
    };
    public static GuiBVKS guiBottomlessVoid = new GuiBVKS()
    {
        @Override
        public Container getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new ContainerBottomlessVoid(entityPlayer, x);
        }

        @Override
        public GuiContainer getGui(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new GuiBottomlessVoid(this.getContainer(entityPlayer, world, x, y, z), entityPlayer, x);
        }
    };
    public static GuiBVKS guiDemonAltar = new GuiBVKS()
    {
        @Override
        public Container getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return null;
        }

        @Override
        public GuiContainer getGui(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return null;
        }
    };
    public static GuiBVKS guiHammerWorkbench = new GuiBVKS()
    {
        @Override
        public Container getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new ContainerHammerWorkbench(entityPlayer, world.getBlockMetadata(x,y,z));
        }

        @Override
        public GuiContainer getGui(EntityPlayer entityPlayer, World world, int x, int y, int z) {
            return new GuiHammerWorkbench( this.getContainer(entityPlayer, world, x, y, z), world.getBlockMetadata(x,y,z) );
        }
    };

    public static void init(){
        GuiHandler.registerGUI(guiDemonFurnace);
        GuiHandler.registerGUI(guiBottomlessVoid);
        GuiHandler.registerGUI(guiDemonAltar);
        GuiHandler.registerGUI(guiHammerWorkbench);


    }

}
