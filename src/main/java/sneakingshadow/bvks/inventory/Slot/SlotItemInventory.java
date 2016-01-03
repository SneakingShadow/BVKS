package sneakingshadow.bvks.inventory.Slot;

import sneakingshadow.bvks.inventory.IItemInventory;

public class SlotItemInventory extends SlotBVKS {

    private final IItemInventory itemInventory;

    public SlotItemInventory(IItemInventory inventory, int slotIndex, int xDisplayPosition, int yDisplayPosition) {
        super(null, slotIndex, xDisplayPosition, yDisplayPosition);
        this.itemInventory = inventory;
    }

    /**
     * Helper fnct to get the stack in the slot.
     */ /*----------
    public ItemStack getStack()
    {
        return this.inventory.getStackInSlot(this.slotIndex);
    }

    /**
     * Returns if this slot contains a stack.
     */ /*----------
    public boolean getHasStack()
    {
        return this.getStack() != null;
    }

    /**
     * Helper method to put a stack in the slot.
     */ /*----------
    public void putStack(ItemStack p_75215_1_)
    {
        this.inventory.setInventorySlotContents(this.slotIndex, p_75215_1_);
        this.onSlotChanged();
    }

    /**
     * Called when the stack in a Slot changes
     */ /*----------
    public void onSlotChanged()
    {
        this.inventory.markDirty();
    }

    /**
     * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
     * of armor slots)
     */ /*----------
    public int getSlotStackLimit()
    {
        return this.inventory.getInventoryStackLimit();
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */ /*----------
    public ItemStack decrStackSize(int p_75209_1_)
    {
        return this.inventory.decrStackSize(this.slotIndex, p_75209_1_);
    }

    /**
     * returns true if this slot is in par2 of par1
     */ /*----------
    public boolean isSlotInInventory(IInventory p_75217_1_, int p_75217_2_)
    {
        return p_75217_1_ == this.inventory && p_75217_2_ == this.slotIndex;
    }

    /**
     * Return whether this slot's stack can be taken from this slot.
     */ /*----------
    public boolean canTakeStack(EntityPlayer p_82869_1_)
    {
        return true;
    }

    /**
     * Returns the icon index on items.png that is used as background image of the slot.
     */ /*----------
    @SideOnly(Side.CLIENT)
    public IIcon getBackgroundIconIndex()
    {
        return backgroundIcon;
    }

    @SideOnly(Side.CLIENT)
    public boolean func_111238_b()
    {
        return true;
    }

    /*========================================= FORGE START =====================================*/
    /**
     * Gets the path of the texture file to use for the background image of this slot when drawing the GUI.
     * @return String: The texture file that will be used in GuiContainer.drawSlotInventory for the slot background.
     */ /*----------
    @SideOnly(Side.CLIENT)
    public ResourceLocation getBackgroundIconTexture()
    {
        return (texture == null ? TextureMap.locationItemsTexture : texture);
    }

    /**
     * Sets which icon index to use as the background image of the slot when it's empty.
     * @param icon The icon to use, null for none
     */ /*----------
    public void setBackgroundIcon(IIcon icon)
    {
        backgroundIcon = icon;
    }

    /**
     * Sets the texture file to use for the background image of the slot when it's empty.
     * @param textureFilename String: Path of texture file to use, or null to use "/gui/items.png"
     */ /*----------
    @SideOnly(Side.CLIENT)
    public void setBackgroundIconTexture(ResourceLocation texture)
    {
        this.texture = texture;
    }

    /**
     * Retrieves the index in the inventory for this slot, this value should typically not
     * be used, but can be useful for some occasions.
     *
     * @return Index in associated inventory for this slot.
     */ /*----------
    public int getSlotIndex()
    {
        /** The index of the slot in the inventory. */  /*----------
        return slotIndex;
    }
    /*========================================= FORGE END =====================================*/
}
