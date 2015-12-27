package sneakingshadow.bvks.proxy;

import cpw.mods.fml.common.network.IGuiHandler;

public interface IProxy extends IGuiHandler {

    void registerKeyBindings();

    void registerCustomRender();
}
