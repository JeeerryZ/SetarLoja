package me.jerryz.setarloja.inventory.api.inventory;

import me.jerryz.setarloja.SetarLoja;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class Inventory {

    private String name;
    private int size;
    private Item[] contents;
    private static final Plugin PLUGIN_INSTANCE = SetarLoja.getPlugin();

    public Inventory(String name, int size) {
        this.name = name;
        this.size = size;
        contents = new Item[size];
    }

    public org.bukkit.inventory.Inventory setup() {
        org.bukkit.inventory.Inventory inventory = Bukkit.createInventory(null, size, name);
        for (int i = 0; i < contents.length; i++) {
            inventory.setItem(i, (contents[i] != null) ? contents[i].getItemStack() : new ItemStack(Material.AIR));
        }
        return inventory;
    }

    public void open(Player p) {
        p.openInventory(setup());
    }

    public int getItemsLenght() {
        int amount = 0;
        for (int i = 0; i < getContents().length; i++) {
            if(getContents()[i] != null) amount++;
        }
        return amount;
    }

    public void addItem(int slot, Item item) {
        this.contents[slot] = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        size = size;
    }

    public Item[] getContents() {
        return contents;
    }

    public void setContents(Item[] contents) {
        this.contents = contents;
    }

}
