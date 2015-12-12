package sneakingshadow.bvks.client.settings;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import sneakingshadow.bvks.reference.Name;

public class Keybindings
{
    public static KeyBinding charge = new KeyBinding(Name.Key.CHARGE, Keyboard.KEY_C, Name.Key.CATEGORY);
    public static KeyBinding release = new KeyBinding(Name.Key.RELEASE, Keyboard.KEY_R, Name.Key.CATEGORY);
}
