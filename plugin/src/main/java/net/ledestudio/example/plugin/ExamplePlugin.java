package net.ledestudio.example.plugin;

import net.ledestudio.example.common.server.Server;
import net.ledestudio.example.plugin.command.Commands;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {

    public static ExamplePlugin instance;
    public static Server server = new Server(1234);

    @Override
    public void onEnable() {

        instance = this;
        try {
            server.run();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Bukkit.getCommandMap().register("SuperJump", new Commands("shoes"));
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
