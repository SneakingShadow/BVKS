package sneakingshadow.bvks.crafting;

import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.item.base.ItemBVKSStorage;
import sneakingshadow.bvks.reference.Ref;
import sneakingshadow.bvks.reference.Tags;
import sneakingshadow.bvks.util.LogHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class StorageItemRecipes implements IRecipe{
    /** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;
    private NBTTagCompound storageTag = new NBTTagCompound();

    public StorageItemRecipes(ItemStack itemStack)
    {
        this.recipeOutput = itemStack;
        this.recipeOutput.setTagCompound(new NBTTagCompound());

        cleanTag();
    }

    private void cleanTag(){
        storageTag.setInteger(Tags.Storage.id, -1);
        storageTag.setInteger(Tags.Storage.meta, 0);
        storageTag.setLong(Tags.Storage.storedAmount, 0);
        storageTag.setString(Tags.Storage.name, "");
        storageTag.setTag(Tags.Storage.stackTag, new NBTTagCompound());
        storageTag.setBoolean(Tags.Storage.stackTagNull, true);
        storageTag.setInteger(Tags.Storage.removingAmount, 0);
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(InventoryCrafting inventoryCrafting, World p_77569_2_)
    {
        int num = 0;
        int num2 = 0;
        boolean flag = false;
        boolean flag2 = true;
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j)
            {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(j, i);

                if (itemStack != null) {
                    if (itemStack.getItem() instanceof ItemBVKSStorage){
                        num2++;
                        flag = true;
                    }else{
                        num++;
                        flag2 = false;
                    }
                }

                if(num >= 2 || num2 >= 2)
                    return false;
            }
        }
        return !(num == 0 || num2 == 0) || (flag && flag2);
    }

    /**
     * Returns an Item that is the result of this recipe
     */
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting)
    {
        cleanTag();

        ItemStack itemStack = getStorageItemStack(inventoryCrafting).copy();
        Tags.setTags(itemStack);
        ItemStack output;
        ItemStack itemStack2 = getItemStack(inventoryCrafting);

        NBTTagCompound bvksTag = itemStack.stackTagCompound.getCompoundTag(Ref.MOD_ID);

        if(itemStack2 != null)
            bvksTag.setTag(Tags.Storage.info, (NBTTagCompound)storageTag.copy());

        NBTTagCompound tag = bvksTag.getCompoundTag(Tags.Storage.info);
        if(itemStack2 != null) {
            itemStack.setItemDamage(1);
            tag.setInteger(Tags.Storage.id, Item.getIdFromItem(itemStack2.getItem()));
            tag.setInteger(Tags.Storage.meta, itemStack2.getItemDamage());
            tag.setString(Tags.Storage.name, itemStack2.getDisplayName());
            tag.setLong(Tags.Storage.storedAmount, 1);
            if (itemStack2.stackTagCompound != null) {
                NBTTagCompound stackTag = (NBTTagCompound) itemStack2.stackTagCompound.copy();
                stackTag.setByte("Count", (byte) 0);
                tag.setTag(Tags.Storage.stackTag, stackTag);
                tag.setBoolean(Tags.Storage.stackTagNull, false);
            }
            int[] placement = getItemStackLocation(inventoryCrafting);

            output = itemStack.copy();
        }else{
            output = new ItemStack(ModItems.BottomlessVoid);
        }
        LogHelper.info("returning output");
        return output;
    }

    /**
     * Returns the size of the recipe area
     */
    public int getRecipeSize() { return 2; }

    private static ItemStack getItemStack(InventoryCrafting inventoryCrafting){
        int[] placement = getItemStackLocation(inventoryCrafting);
        if(placement != null)
            return inventoryCrafting.getStackInRowAndColumn(placement[0], placement[1]);
        return null;
    };

    private static int[] getItemStackLocation(InventoryCrafting inventoryCrafting){
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(i,j);
                if(itemStack != null && !(itemStack.getItem() instanceof ItemBVKSStorage)){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static ItemStack getStorageItemStack(InventoryCrafting inventoryCrafting){
        int[] placement = getStorageItemStackLocation(inventoryCrafting);
        if(placement != null)
            return inventoryCrafting.getStackInRowAndColumn(placement[0], placement[1]);
        return null;
    };

    private static int[] getStorageItemStackLocation(InventoryCrafting inventoryCrafting){
        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 3; ++j) {
                ItemStack itemStack = inventoryCrafting.getStackInRowAndColumn(i,j);
                if(itemStack != null && itemStack.getItem() instanceof ItemBVKSStorage){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

