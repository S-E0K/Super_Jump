package net.ledestudio.example.mod.key;

import net.neoforged.neoforge.common.util.Lazy;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class InputMapping {
    public static final Lazy<KeyMapping> SuperJump = Lazy.of(() -> new KeyMapping(
            "Super Jump",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_SPACE,
            "key.categories.misc"
    ));
}
