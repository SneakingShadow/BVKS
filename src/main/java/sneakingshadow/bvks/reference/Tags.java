package sneakingshadow.bvks.reference;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Tags {

    public static final class Storage
    {
        public static final String storedAmount = "stored";
        public static final String id = "id";
        public static final String name = "name";
        public static final String meta = "meta";
        public static final String stackTag = "stack";
        public static final String stackTagNull = "stackNull";
        public static final String maxStackSize = "maxStackSize";
    }





    public static void setTags(ItemStack itemStack){
        if (itemStack.stackTagCompound == null)
            itemStack.setTagCompound(new NBTTagCompound());
        setTags(itemStack.stackTagCompound);
    }

    public static void setTags(NBTTagCompound stackTagCompound){
        if (!stackTagCompound.hasKey(Ref.MOD_ID, 10))
            stackTagCompound.setTag(Ref.MOD_ID, new NBTTagCompound());
    }

    public static void clearTags(ItemStack itemStack){ //Only clears bvks tags
        itemStack.setTagCompound(null);
    }

    public static void clearBVKSTags(ItemStack itemStack){ //Only clears bvks tags
        itemStack.stackTagCompound.setTag(Ref.MOD_ID, new NBTTagCompound());
    }
}
