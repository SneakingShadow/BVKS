package com.sneakingshadow.bvks.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public abstract class GuiBVKS {

    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    abstract public Container getContainer(EntityPlayer entityPlayer, World world, int x, int y, int z);

    abstract public GuiContainer getGui(EntityPlayer entityPlayer, World world, int x, int y, int z);

}
