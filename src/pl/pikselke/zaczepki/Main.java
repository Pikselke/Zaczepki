package pl.pikselke.zaczepki;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import pl.pikselke.zaczepki.cmds.PokeCmd;

public class Main extends JavaPlugin{
	
	public void onEnable(){
		getCommand("poke").setExecutor(new PokeCmd());
		Bukkit.getLogger().info("Plugin: Zaczepki zostal pomyslnie zaladowany");
	}
	
	public void onDisable(){
		Bukkit.getLogger().info("Plugin: Zaczepki zostal pomyslnie wylaczony");
	}
	
	public static String fixColor(String msg){
		return ChatColor.translateAlternateColorCodes('&', msg);
	}

}
