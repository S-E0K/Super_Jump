package net.ledestudio.example.plugin.shoes;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ShoesManager implements ShoesInterface{

    ShoesItem shoes = new ShoesItem(Material.IRON_BOOTS, "신발");

    @Override
    public void shoesAbility(Player player) {

    }

    @Override
    public boolean isShoes(Player player) {
        return Objects.equals(player.getInventory().getBoots(), shoes.getShoes()) || player.getInventory().contains(shoes.getShoes());
    }

    @Override
    public void setShoes(Player player) {
        player.getInventory().addItem(shoes.getShoes());
    }
}
