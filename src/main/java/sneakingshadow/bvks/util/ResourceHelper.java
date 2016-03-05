package sneakingshadow.bvks.util;

import net.minecraft.util.ResourceLocation;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Textures;

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

    public static ResourceLocation modelLocation(String path)
    {
        return getLocation(Textures.MODEL_TEXTURE_LOCATION + path);
    }
}