package me.jerryz.setarloja.inventory.api.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class CommandBuilder extends Command {

    private Method method;

    protected CommandBuilder(String name, String description, Method method) {
        super(name, description, "", new ArrayList<>());
        this.method = method;
    }

    public static void setup(Class clazz) {
        for (Method method : clazz.getMethods()) {
            if (method.getAnnotation(CommandHandler.class) != null && method.getName().equalsIgnoreCase("execute")) {
                CommandHandler commandHandler = method.getAnnotation(CommandHandler.class);
                CommandBuilder commandBuilder = new CommandBuilder(commandHandler.name(), commandHandler.description(), method);
                registerCommand(commandBuilder);
            }
        }
    }

    private static void registerCommand(Command command) {
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
            commandMap.register(command.getName(), command);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        try {
            method.invoke(null, commandSender, s, strings);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return false;
    }
}

