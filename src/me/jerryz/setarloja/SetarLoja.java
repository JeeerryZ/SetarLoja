package me.jerryz.setarloja;

import me.jerryz.setarloja.commands.HelpCommand;
import me.jerryz.setarloja.commands.ListCommand;
import me.jerryz.setarloja.commands.SetCommand;
import me.jerryz.zcore.api.command.CommandBuilder;
import me.jerryz.zcore.api.NewCommand;
import me.jerryz.setarloja.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SetarLoja extends JavaPlugin {

    public static Plugin getPlugin(){
        return Bukkit.getServer().getPluginManager().getPlugin("SetarLoja");
    }

    public void registerCommand(String name, CommandExecutor command){
        getCommand(name).setExecutor(command);
    }

    public void onEnable(){

        CommandBuilder.setup(NewCommand.class);

        registerCommand("help", new HelpCommand());
        registerCommand("setloja", new SetCommand());
        registerCommand("lojas", new ListCommand());

        ConfigUtils.setup(this);
    }

}
