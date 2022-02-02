package me.jerryz.setarloja.shop;

import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Shop {

    private String name;
    private UUID ownerUUID;

    private static final List<Shop> shops = new ArrayList<>();

    public Shop(UUID ownerUUID) {
        name = "Loja de " + Objects.requireNonNull(Bukkit.getPlayer(ownerUUID)).getName();
        this.ownerUUID = ownerUUID;
        shops.add(this);
    }

    public static boolean hasShop(UUID ownerUUID){
        for(Shop shop : shops){
            if(shop.getOwnerUUID() == ownerUUID) return true;
        }
        return false;
    }

    public static List<Shop> getShops(){
        return shops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getOwnerUUID() {
        return ownerUUID;
    }

    public void setOwnerUUID(UUID ownerUUID) {
        this.ownerUUID = ownerUUID;
    }
}
