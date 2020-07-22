package eu.grayroot.anarchyoitb.listener;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.armorevent.ArmorEquipEvent;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import eu.grayroot.anarchyoitb.sql.OitbData;
import eu.grayroot.anarchyoitb.sql.PlayerData;
import eu.grayroot.anarchyoitb.utils.PlayerUtils;
import eu.grayroot.anarchyoitb.utils.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void playerJoin(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		Player player = e.getPlayer();
		player.teleport(OITB.getInstance().getSpawn());
		if(!new PlayerData(OITB.getInstance().getConnection()).isRegistered(player)) {
			new PlayerData(OITB.getInstance().getConnection()).registerPlayer(player);
		}
		OITB.getInstance().getOitbPlayers().put(player, new OitbData(OITB.getInstance().getConnection()).loadPlayer(player));
		new PlayerUtils().loadLobby(player);
		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		OITB.getInstance().getPlayerArena().put(player, null);
		ScoreboardSign scoreboard = new ScoreboardSign(player, "§b§lOITB");
		scoreboard.create();
		scoreboard.setLine(0, "§0 ");
		scoreboard.setLine(1, "§b§lJoueur");
		scoreboard.setLine(2, " §f➥ §7Coins: §f" + oitbPlayer.getCoins());
		scoreboard.setLine(3, " §f➥ §7Rang: §f" + oitbPlayer.getRank());
		scoreboard.setLine(4, "§a ");
		scoreboard.setLine(5, "§b§lPVP");
		scoreboard.setLine(6, " §f➥ §7Eliminations: §f" + oitbPlayer.getKills());
		scoreboard.setLine(7, " §f➥ §7Morts: §f" + oitbPlayer.getDeaths());
		scoreboard.setLine(8, " §f➥ §7OneShots: §f" + oitbPlayer.getHits());
		OITB.getInstance().getScoreboards().put(player, scoreboard);
	}

	@EventHandler
	public void playerQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		e.setQuitMessage(null);
		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		new OitbData(OITB.getInstance().getConnection()).savePlayer(player);
		new OitbData(OITB.getInstance().getConnection()).purgePlayerInventory(player);
		new OitbData(OITB.getInstance().getConnection()).savePlayerEquipment(player, oitbPlayer.getHelmet(), 1);
		new OitbData(OITB.getInstance().getConnection()).savePlayerEquipment(player, oitbPlayer.getChestplate(), 2);
		new OitbData(OITB.getInstance().getConnection()).savePlayerEquipment(player, oitbPlayer.getLeggings(), 3);
		new OitbData(OITB.getInstance().getConnection()).savePlayerEquipment(player, oitbPlayer.getBoots(), 4);
		new OitbData(OITB.getInstance().getConnection()).savePlayerEquipment(player, oitbPlayer.getAxe(), 5);
		new OitbData(OITB.getInstance().getConnection()).savePlayerInventory(player);
		OITB.getInstance().getOitbPlayers().remove(player);
		if(OITB.getInstance().getPlayerArena().containsKey(player) && OITB.getInstance().getPlayerArena().get(player) != null) {
			OITB.getInstance().getPlayerArena().get(player).setPlayers(OITB.getInstance().getPlayerArena().get(player).getPlayers()-1);
		}
		OITB.getInstance().getScoreboards().remove(player);
	}

	@EventHandler
	public void playerChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		e.setFormat("§8[§6" + OITB.getInstance().getOitbPlayers().get(player).getRank() + "§8] §e" + player.getName() + " §8» §7" + e.getMessage());
	}

	@EventHandler
	public void playerDrop(PlayerDropItemEvent e) {
		Player player = e.getPlayer();
		if(!player.isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void playerPickup(PlayerPickupItemEvent e) {
		Player player = e.getPlayer();
		if(!player.isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void playerFood(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
		e.setCancelled(true);
	}

	@EventHandler
	public void playerMove1(InventoryMoveItemEvent e) {
		if(e.getInitiator().getViewers().get(0) instanceof Player) {
			Player player = (Player) e.getInitiator().getViewers().get(0);
			if(!player.isOp()) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void armorEquipEvent(ArmorEquipEvent e) {
		Player player = e.getPlayer();
		if(!player.isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void playerPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		if(!player.isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void playerBreak(BlockBreakEvent e) {
		Player player = e.getPlayer();
		if(!player.isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void playerDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if(player.getLocation().getWorld() == Bukkit.getWorld("world")) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void playerRespawn(PlayerRespawnEvent e) {
		Player player = (Player) e.getPlayer();
		new PlayerUtils().loadLobby(player);
	}

}
