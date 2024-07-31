package net.ledestudio.example.plugin.shoes;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.Objects;

public class ShoesManager implements ShoesInterface{

    ShoesItem shoes = new ShoesItem(Material.IRON_BOOTS, "신발");

    @Override
    public void shoesAbility(Player player) {

        player.setVelocity(new Vector(0, 3, 0));

    }

    @Override
    public boolean hasShoes(Player player) {
        return isShoes(player) || player.getInventory().contains(shoes.getShoes());
    }

    @Override
    public boolean isShoes(Player player) {
        return Objects.equals(player.getInventory().getBoots(), shoes.getShoes());
    }

    @Override
    public void setShoes(Player player) {
        player.getInventory().addItem(shoes.getShoes());
    }
}
