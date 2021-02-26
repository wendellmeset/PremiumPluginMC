package me.wendellmeset.$premiumplugin;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {
  private static Main instance;
  
  private static Object localVariableScope = new Object();
  
  public void onEnable() {
    instance = this;
    getDataFolder().mkdir();
    getServer().getPluginManager().registerEvents(this, (Plugin)this);
    Object localVariableScope = new Object();
    saveDefaultConfig();
  }
  
  public void onDisable() {}
  
  public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
    if (command.getName().equalsIgnoreCase("speed"))
      try {
        Object localVariableScope = new Object();
        if (((Boolean)getInstance().getConfig().get("logged-in")).booleanValue()) {
          ((LivingEntity)commandSender).addPotionEffect(new PotionEffect(
                PotionEffectType.SPEED, 
                2147483647, 
                4, true, false, true), true);
        } else {
          commandSender.sendMessage(color("&cPlease log in using /premium"));
        } 
      } catch (Exception e) {
        e.printStackTrace();
      }  
    if (command.getName().equalsIgnoreCase("premium"))
      try {
        Object localVariableScope = new Object();
        getInstance().getConfig().set("logged-in", new Boolean(true));
      } catch (Exception e) {
        e.printStackTrace();
      }  
    return true;
  }
  
  public static void procedure(String procedure, List<?> procedureArgs) throws Exception {}
  
  public static Object function(String function, List<?> functionArgs) throws Exception {
    return null;
  }
  
  public static List<Object> createList(Object obj) {
    List<Object> list = new ArrayList();
    if (obj.getClass().isArray()) {
      int length = Array.getLength(obj);
      for (int i = 0; i < length; i++)
        list.add(Array.get(obj, i)); 
    } else if (obj instanceof Collection) {
      list.addAll((Collection)obj);
    } else {
      list.add(obj);
    } 
    return list;
  }
  
  public static String color(String string) {
    return (string != null) ? ChatColor.translateAlternateColorCodes('&', string) : null;
  }
  
  public static void createResourceFile(String path) {
    Path file = getInstance().getDataFolder().toPath().resolve(path);
    if (Files.notExists(file, new java.nio.file.LinkOption[0]))
      try {
        Exception exception2, exception1 = null;
      } catch (IOException e) {
        e.printStackTrace();
      }  
  }
  
  public static Main getInstance() {
    return instance;
  }
}
