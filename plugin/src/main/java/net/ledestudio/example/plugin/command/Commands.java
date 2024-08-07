package net.ledestudio.example.plugin.command;

import net.ledestudio.example.plugin.shoes.ShoesInterface;
import net.ledestudio.example.plugin.shoes.ShoesManager;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

import static net.ledestudio.example.mod.key.InputEventListener.*;

public class Commands extends BukkitCommand {

    public Commands(String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String command, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;

        if (args.length == 0) return false;

        ShoesInterface shoesManager = new ShoesManager();

        switch (args[0]) {
            case "get" -> {
                if (shoesManager.hasShoes(player)) player.sendMessage("이미 가지고 있습니다");
                else shoesManager.setShoes(player);
            }
            case "jump" -> {
                player.sendMessage("슈퍼점프");
                if (canJumping) {
                    shoesManager.shoesAbility(player);
                    canJumping = false;
                    count = 0;
                }
            }
        }
        return false;
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) return Arrays.asList("get", "jump");

        return null;
    }
}
