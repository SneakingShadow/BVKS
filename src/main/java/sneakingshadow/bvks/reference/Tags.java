package sneakingshadow.bvks.reference;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Tags {
    public static final String bvks = Ref.MOD_ID;

    public static final class Storage
    {
        public static final String info = "storage";
        public static final String storedAmount = "stored";
        public static final String removingAmount = "remove";
        public static final String id = "type";
        public static final String name = "typeName";
        public static final String meta = "meta";
        public static final String stackTag = "stack";
        public static final String stackTagNull = "stackNull";
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
}
