package net.earthspawn.mod.utils;

import com.mojang.blaze3d.platform.InputConstants;
import net.earthspawn.mod.Earthspawn;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public final class KeyInit {
    private KeyInit() {
    }
    public static final String CATEGORY_EARTHSPAWN_MOUNTS = "key.category.earthspawn";
    public static KeyMapping mountDescentKey;

    public static void init() {
        mountDescentKey = registerKey("mount_descent_key", CATEGORY_EARTHSPAWN_MOUNTS, InputConstants.KEY_S);
    }

    private static KeyMapping registerKey(String name, String category, int keycode) {
        final var key = new KeyMapping("key." + Earthspawn.MOD_ID + "." + name, keycode, category);
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
