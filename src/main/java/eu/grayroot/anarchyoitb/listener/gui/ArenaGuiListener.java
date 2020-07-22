package eu.grayroot.anarchyoitb.listener.gui;

import java.util.Map.Entry;
import java.util.Random;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbArena;
import eu.grayroot.anarchyoitb.object.OitbSpawnPoint;
import eu.grayroot.anarchyoitb.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ArenaGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		final Player player = (Player)e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();

		switch(inv.getName()) {
		case "§8[§eListe des arènes§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				for(OitbArena oitbArena : OITB.getInstance().getOitbArenas()) {
					if(current.getItemMeta().getDisplayName().replaceAll(" ", "_").replaceAll("§b", "").equalsIgnoreCase(oitbArena.getName())) {
						if(oitbArena.getStatus() == 1) {
							if(new PlayerUtils().getPlayerPower(OITB.getInstance().getOitbPlayers().get(player)) <= oitbArena.getMaxPower() || oitbArena.getMaxPower() == -1) {
								if(oitbArena.getPlayers() < oitbArena.getMaxPlayers()) {
									oitbArena.setPlayers(oitbArena.getPlayers()+1);
									OITB.getInstance().getPlayerArena().replace(player, oitbArena);
									player.sendMessage("§8[§b!§8] §b» §7Téléportation dans l'arène §b" + oitbArena.getName().replaceAll("_", " ") + " §7!");
									OitbSpawnPoint oitbSpawnPoint = oitbArena.getSpawns().get(new Random().nextInt(oitbArena.getSpawns().size()));
									Location location = new Location(Bukkit.getWorld(oitbSpawnPoint.getWorld()), oitbSpawnPoint.getPosX(), oitbSpawnPoint.getPosY(), oitbSpawnPoint.getPosZ(), oitbSpawnPoint.getYaw(), oitbSpawnPoint.getPitch());
									player.teleport(location);
									player.setFlying(false);
									player.setAllowFlight(false);
									player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
									new PlayerUtils().loadStuff(player, oitbArena);
									player.setMaxHealth((double) 20);
									player.setHealth((double) 20);
									for(Entry<Player, OitbArena> entry : OITB.getInstance().getPlayerArena().entrySet()) {
										if(entry.getValue() == oitbArena) {
											entry.getKey().hidePlayer(player);
											entry.getKey().sendMessage("§8[§b!§8] §b» §7Le joueur §b" + player.getName() + " §7a rejoint l'arène !");
										}

									}
									Bukkit.getScheduler().scheduleSyncDelayedTask(OITB.getInstance(), new Runnable() {

										@Override
										public void run() {
											for(Player players : Bukkit.getOnlinePlayers()) {
												players.showPlayer(player);
											}

										}
									}, 3*20);
									player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 1));
								} else {
									player.sendMessage("§8[§c!§8] §c» §7L'arène §c" + oitbArena.getName().replaceAll("_", " ") + " §7est complète !");
								}
							} else {
								player.sendMessage("§8[§c!§8] §c» §7Tu as une puissance de §c" + new PlayerUtils().getPlayerPower(OITB.getInstance().getOitbPlayers().get(player)) + " §7pour un maximum autorisé de §c" + oitbArena.getMaxPower() + "§7!");
							}
						} else {
							player.sendMessage("§8[§c!§8] §c» §7L'arène §c" + oitbArena.getName().replaceAll("_", " ") + " §7est indisponible !");
						}
					}
				}
			}
		default:
			break;

		}
	}
}