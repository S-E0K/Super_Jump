package net.ledestudio.example.mod.key;


import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

import static com.mojang.text2speech.Narrator.LOGGER;
import static net.ledestudio.example.mod.ExampleMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class InputEventListener {

    static boolean canJumping = false;
    static Integer count = 0;

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onClientTick(ClientTickEvent.Post event) {

        while (InputMapping.SuperJump.get().consumeClick()) {
            if (count < 90) count++; // 1초에 30정도 올라감
            LOGGER.info(count.toString());
            if (count >= 90) canJumping = true;
        }
//        if (count < 90) count = 0;
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onClientTickJump(ClientTickEvent.Post event) {
        if (!canJumping) return;

        if (InputMapping.Jumping.get().consumeClick() && count >= 90) {
            LOGGER.info("슈퍼점프 함");
            count = 0;
        }

    }

}
