package eu.grayroot.anarchyoitb.utils;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ExpUtils {

	public ExpUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addPlayerExp(Player player, double expAmount) {
		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		double playerExp = oitbPlayer.getXp();
		int playerRank = oitbPlayer.getRank();
		double requiredExp = 200;
		double requiredExpMultiplier = 1 + (playerRank/10);
		double newRequiredExp = requiredExp * requiredExpMultiplier;
		if(playerExp + expAmount>= newRequiredExp) {
			oitbPlayer.setXp(0);
			oitbPlayer.setRank(playerRank+1);
			int displayRank = playerRank+1;
			Bukkit.broadcastMessage("§8[§b!§8] §b» §7Le joueur §b" + player.getName() + " §7vient de passer rang §b" + displayRank + " §7!");
		} else {
			oitbPlayer.setXp(playerExp+expAmount);
		}
		if(OITB.getInstance().getScoreboards().containsKey(player)) {
			OITB.getInstance().getScoreboards().get(player).setLine(3, " §f➥ §7Rang: §f" + oitbPlayer.getRank());
		}
	}

}
