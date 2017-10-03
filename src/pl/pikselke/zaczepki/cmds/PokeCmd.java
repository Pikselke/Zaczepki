package pl.pikselke.zaczepki.cmds;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import pl.pikselke.zaczepki.Main;
import pl.pikselke.zaczepki.title.Title;

public class PokeCmd implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("poke")){
			Player p = (Player) sender;
			if(p.hasPermission("pikselke.poke")){
				if(args.length == 0){
					p.sendMessage(Main.fixColor("&6Poprawne uzycie: &c/poke <player> <powod>"));
					return true;
				}
				Player p2 = Bukkit.getPlayer(args[0]);
				if(p2 == null){
					p.sendMessage(Main.fixColor("&4Blad: &cNie znaleziono podanego gracza"));
					return true;
				}
			    String reason = "Brak!";
			    reason = StringUtils.join(args, " ", 1, args.length);
			    Title.sendTitle(p2, Main.fixColor("&7Zostales zaczepiony przez: &3" + p.getName() + "&7 Powod: &3" + reason));
				p2.sendMessage(Main.fixColor("&7Zostales zaczepiony przez: &3" + p.getName() + "&7 Powod: &3" + reason));
				p.sendMessage(Main.fixColor("&7Pomyslnie wyslano zaczepke do gracza &3" + p2.getName() + " &7z powodem &3" + reason));
			}else{
				p.sendMessage(Main.fixColor("&cNie posiadasz permissji &3(pikselke.poke)"));
			}
		}
		return false;
	}
}
