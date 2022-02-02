package me.jerryz.setarloja.inventory;

import me.jerryz.zcore.api.inventory.ClickableItem;
import me.jerryz.zcore.api.inventory.ItemBuilder;
import me.jerryz.zcore.api.inventory.PaginatedInventory;
import me.jerryz.setarloja.shop.Shop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public final class ShoplistInventory extends PaginatedInventory {

    public ShoplistInventory() {
        super("Lista de lojas:", Math.max(Shop.getShops().size(), 45));
        int slot = 0;
        for (Shop shop : Shop.getShops()) {
            ItemStack playerShop = new ItemBuilder(Material.PLAYER_HEAD).name(shop.getName()).build();
            SkullMeta skullMeta = (SkullMeta) playerShop.getItemMeta();
            assert skullMeta != null;
            skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(shop.getOwnerUUID()));
            playerShop.setItemMeta(skullMeta);

            addItem(slot, new ClickableItem(playerShop, true, (p, item, clickType) -> {
                p.closeInventory();
                //TODO OPEN PLAYER'S SHOP
            }));
            slot++;
        }
    }
}
