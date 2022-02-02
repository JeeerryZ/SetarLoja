package me.jerryz.setarloja.inventory.api.inventory;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public interface ClickAction {

    void onClick(Player p, Item item, ClickType clickType);
}
