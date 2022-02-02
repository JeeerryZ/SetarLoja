package me.jerryz.setarloja.commands;

import me.jerryz.setarloja.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("help")){
            MessageUtils.send(commandSender, "Ajuda.");
        }
        return false;
    }

}
