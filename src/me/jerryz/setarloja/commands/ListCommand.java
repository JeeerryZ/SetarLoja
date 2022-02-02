package me.jerryz.setarloja.commands;

import me.jerryz.setarloja.inventory.ShoplistInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("lojas")) {
            ShoplistInventory shoplistInventory = new ShoplistInventory();
            if (commandSender instanceof Player) {
                Player p = (Player) commandSender;
                shoplistInventory.open(p);
            }

        }
        return false;
    }
}
