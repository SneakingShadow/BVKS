package sneakingshadow.bvks.util;

import net.minecraft.util.ResourceLocation;
import sneakingshadow.bvks.reference.Ref;

public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(Ref.MOD_ID, path);
    }
}