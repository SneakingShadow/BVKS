package com.sneakingshadow.bvks.util;

import com.sneakingshadow.bvks.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class ResourceHelper
{
    public static ResourceLocation getLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getLocation(String path)
    {
        return getLocation(Reference.MOD_ID, path);
    }

    public static ResourceLocation getModelTexture(String path)
    {
        return getLocation(Reference.MODEL_TEXTURE_LOCATION + path);
    }

    public static ResourceLocation getModel(String path)
    {
        return getLocation(Reference.MODEL_LOCATION + path);
    }
}