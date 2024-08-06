package net.ledestudio.example.mod.key;

import net.ledestudio.example.mod.client.Client;
import net.ledestudio.example.mod.data.User;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import static com.mojang.text2speech.Narrator.LOGGER;
import static net.ledestudio.example.mod.ExampleMod.MODID;


@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class InputEventListener {

    public static boolean canJumping = false;
    static int count = 0;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onClientTick(ClientTickEvent.Post event) {

        Minecraft mc = Minecraft.getInstance();


        while (InputMapping.JumpGage.get().consumeClick() && count < 100 && !canJumping) {
            if (!InputMapping.JumpGage.get().isDown()) return;
            count++; // 1초에 30 올라감
            LOGGER.info(String.valueOf(count));
            if (count % 20 == 0 && count < 100) showTitle(mc, "차징중", count + "%");
            if (count == 100) {
                LOGGER.info(String.valueOf(count));
                LOGGER.info("차징 완료");
                showTitle(mc, "차징완료", "100%");
                canJumping = true;
                break;
            }
        }

        if (!InputMapping.JumpGage.get().isDown() && count != 0) {
            if (canJumping && count == 100) {
                showTitle(mc, "슈퍼점프", " ");
                count = 0;
                canJumping = false;
            }
            else if (count != 100){
                LOGGER.info(String.valueOf(count));
                showTitle(mc, "초기화", " ");
                count = 0;
            }
        }
    }
    private static void showTitle(Minecraft mc, String title, String subTitle) {
        if (mc.player != null) {
            mc.gui.setTitle(Component.literal(title));
            mc.gui.setSubtitle(Component.literal(subTitle));
        }
    }
}



