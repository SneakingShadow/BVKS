package com.sneakingshadow.bvks.client.model;

import com.sneakingshadow.bvks.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelDemonAltar {

    private IModelCustom modelDemonAltar;

    public ModelDemonAltar()
    {
        modelDemonAltar = AdvancedModelLoader.loadModel(Models.DEMON_ALTAR);
    }

    public void render()
    {
        modelDemonAltar.renderAll();
    }

}