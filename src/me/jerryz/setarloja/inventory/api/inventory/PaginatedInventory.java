package me.jerryz.setarloja.inventory.api.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PaginatedInventory extends Inventory {

    private ArrayList<Inventory> inventoryPages;
    private int currentPage;
    private int pages;
    private static final int MAX_SLOT = 36;
    private static final int NEXT_BUTTON_SLOT = 43;
    private static final int BEFORE_BUTTON_SLOT = 38;

    public PaginatedInventory(String name, int size) {
        super(name, size);
        inventoryPages = new ArrayList<>();
    }

    @Override
    public org.bukkit.inventory.Inventory setup() {
        pages = (int) Math.ceil((float) getItemsLenght() / MAX_SLOT);

        ClickableItem nextPage = new ClickableItem(new ItemBuilder(Material.ARROW).name(ChatColor.GREEN + "Próxima pagina").build(), true, (p, item, clickType) -> {
            p.closeInventory();
            if (currentPage != pages - 1) currentPage++;
            inventoryPages.get(currentPage).open(p);
        });

        ClickableItem beforePage = new ClickableItem(new ItemBuilder(Material.ARROW).name(ChatColor.GREEN + "Página anterior").build(), true, (p, item, clickType) -> {
            p.closeInventory();
            if (currentPage != 0) currentPage--;
            inventoryPages.get(currentPage).open(p);
        });

        for (int i = 0; i < pages; i++) {
            Inventory inventory = new Inventory(getName(), 45);

            if (i != pages - 1) inventory.addItem(NEXT_BUTTON_SLOT, nextPage);
            if (i != 0) inventory.addItem(BEFORE_BUTTON_SLOT, beforePage);

            for (int x = 0; x < MAX_SLOT; x++) {
                inventory.addItem(x, getContents()[(i * MAX_SLOT) + x]);
            }

            inventoryPages.add(inventory);
        }
        currentPage = 0;
        return inventoryPages.get(currentPage).setup();
    }

    @Override
    public void open(Player p) {
        p.openInventory(setup());
    }
}
