package me.jerryz.setarloja.inventory.api.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickableItem extends Item {

    private ClickAction clickAction;

    public ClickableItem(Material material, int amount, boolean preventClick, ClickAction clickAction) {
        super(material, amount, preventClick);
        this.clickAction = clickAction;
    }

    public ClickableItem(ItemStack itemStack, boolean preventClick, ClickAction clickAction) {
        super(itemStack, preventClick);
        this.clickAction = clickAction;
    }

    public ClickableItem(Material material, boolean preventClick, ClickAction clickAction) {
        super(material, preventClick);
        this.clickAction = clickAction;
    }

    @Override
    @EventHandler
    public void onItemClick(InventoryClickEvent e){
        ItemStack current = e.getCurrentItem();
        if(isSimilar(current)){
            if(e.getWhoClicked() instanceof Player){
                Player p = (Player) e.getWhoClicked();
                clickAction.onClick(p, this, e.getClick());
                if(isPreventClick()) e.setCancelled(true);
            }
        }
    }

}
