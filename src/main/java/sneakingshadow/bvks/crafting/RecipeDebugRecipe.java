package sneakingshadow.bvks.crafting;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import sneakingshadow.bvks.init.ModItems;
import sneakingshadow.bvks.util.LogHelper;

public class RecipeDebugRecipe implements IRecipe{

    @Override
    public boolean matches(InventoryCrafting inventoryCrafting, World world) {
        LogHelper.info("matches");
        boolean flag = true;
        for (int i = 1; i < inventoryCrafting.getSizeInventory(); i++) {
            ItemStack itemStack = inventoryCrafting.getStackInSlot(i);
            flag = flag && itemStack != null && itemStack.getItem() == Items.apple;
        }
        return flag;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        LogHelper.info("getCraftingResult");
        return new ItemStack(ModItems.DevilGem);
    }

    @Override
    public int getRecipeSize() {
        return 0;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}
