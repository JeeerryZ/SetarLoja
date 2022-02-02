package me.jerryz.setarloja.utils;

import org.bukkit.command.CommandSender;

public class MessageUtils {

    private static String PREFFIX = "[SetarLoja]";

    public static String getPreffix(){
        return PREFFIX;
    }

    public static void send(CommandSender sender, String msg){
        sender.sendMessage(getPreffix() + " " + msg);
    }



}
