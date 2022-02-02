package me.jerryz.setarloja.commands;

import me.jerryz.setarloja.shop.Shop;
import me.jerryz.setarloja.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setloja")) {
            if (commandSender instanceof Player) {
                Player p = (Player) commandSender;
                if (Shop.hasShop(p.getUniqueId())) {
                    MessageUtils.send(p, ChatColor.RED + "Você ja tem uma loja criada.");
                } else {
                    Shop shop = new Shop(p.getUniqueId());
                    MessageUtils.send(p, ChatColor.GREEN + "Loja criada: " + shop.getName() + ":" + shop.getOwnerUUID());
                }
            }
        }
        return false;
    }
}
