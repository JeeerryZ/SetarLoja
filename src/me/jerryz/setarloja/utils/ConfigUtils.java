package me.jerryz.setarloja.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.logging.Level;

public class ConfigUtils {

    private static Plugin p;

    public static void setup(Plugin plugin){
        File configFile = new File(plugin.getDataFolder(), "config.yml");
        p = plugin;
        if(!configFile.exists()) {
            plugin.saveDefaultConfig();
            plugin.getLogger().log(Level.INFO, "Criando arquivo de configuração padrão.");
        }
    }

    public static FileConfiguration getConfig(){
        return p.getConfig();
    }


}


