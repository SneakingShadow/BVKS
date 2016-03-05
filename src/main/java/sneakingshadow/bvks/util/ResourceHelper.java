package sneakingshadow.bvks.util;

import net.minecraft.util.ResourceLocation;
import sneakingshadow.bvks.reference.Ref;

public class ResourceHelper
{
    public static ResourceLocation getLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getLocation(String path)
    {
        return getLocation(Ref.MOD_ID, path);
    }

    public static ResourceLocation getModelTexture(String path)
    {
        return getLocation(Ref.MODEL_TEXTURE_LOCATION + path);
    }

    public static ResourceLocation getModel(String path)
    {
        return getLocation(Ref.MODEL_LOCATION + path);
    }
}