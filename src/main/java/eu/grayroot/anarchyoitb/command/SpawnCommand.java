package eu.grayroot.anarchyoitb.command;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.utils.PlayerUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			new PlayerUtils().loadLobby(player);
			if(OITB.getInstance().getPlayerArena().containsKey(player)) {
				if(OITB.getInstance().getPlayerArena().get(player) != null) {
					System.out.println(OITB.getInstance().getPlayerArena().get(player).getName());
					OITB.getInstance().getPlayerArena().get(player).setPlayers(OITB.getInstance().getPlayerArena().get(player).getPlayers()-1);
					OITB.getInstance().getPlayerArena().replace(player, null);
				}

			}
		}
		return false;
	}

}
