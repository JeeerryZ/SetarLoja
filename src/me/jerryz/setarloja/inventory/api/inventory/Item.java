package me.jerryz.setarloja.inventory.api.inventory;

import me.jerryz.setarloja.SetarLoja;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Item implements Listener {

    private Material material;
    private int amount;
    private ItemStack itemStack;
    private boolean preventClick;
    private static final Plugin PLUGIN_INSTANCE = SetarLoja.getPlugin();

    public Item(Material material, int amount, boolean preventClick) {
        this.material = material;
        this.amount = amount;
        this.preventClick = preventClick;
        itemStack = new ItemStack(material, amount);
        PLUGIN_INSTANCE.getServer().getPluginManager().registerEvents(this, PLUGIN_INSTANCE);
    }

    public Item(Material material, boolean preventClick) {
        this.material = material;
        amount = 1;
        this.preventClick = preventClick;
        itemStack = new ItemStack(material, amount);
        PLUGIN_INSTANCE.getServer().getPluginManager().registerEvents(this, PLUGIN_INSTANCE);
    }

    public Item(ItemStack itemStack, boolean preventClick) {
        material = itemStack.getType();
        amount = itemStack.getAmount();
        this.itemStack = itemStack;
        this.preventClick = preventClick;
        PLUGIN_INSTANCE.getServer().getPluginManager().registerEvents(this, PLUGIN_INSTANCE);
    }

    @EventHandler
    public void onItemClick(InventoryClickEvent e) {
        if (isSimilar(e.getCurrentItem())) {
            if (preventClick) e.setCancelled(true);
        }
    }

    boolean isSimilar(ItemStack itemStack) {

        boolean similar = false;

        if (this.itemStack == null || itemStack == null) {
            return false;
        }

        boolean sameAmount = (this.itemStack.getAmount() == itemStack.getAmount());
        boolean sameHasItemMeta = (this.itemStack.hasItemMeta() == itemStack.hasItemMeta());
        boolean sameEnchantments = (this.itemStack.getEnchantments().equals(itemStack.getEnchantments()));
        boolean sameName = false;

        if (sameHasItemMeta) {
            sameName = this.itemStack.getItemMeta().getDisplayName().equals(itemStack.getItemMeta().getDisplayName());
        }

        if (sameAmount && sameHasItemMeta && sameEnchantments && sameName) {
            similar = true;
        }

        return similar;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    boolean isPreventClick() {
        return preventClick;
    }

    public void setPreventClick(boolean preventClick) {
        this.preventClick = preventClick;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void reduceAmount(int amount) {
        setAmount(getAmount() - amount);
    }
}
