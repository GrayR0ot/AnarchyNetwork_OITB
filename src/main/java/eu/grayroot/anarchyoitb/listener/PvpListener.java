package eu.grayroot.anarchyoitb.listener;

import java.util.Map.Entry;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.ArenaType;
import eu.grayroot.anarchyoitb.object.OitbArena;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import eu.grayroot.anarchyoitb.utils.ExpUtils;
import eu.grayroot.anarchyoitb.utils.PackageSender;
import eu.grayroot.anarchyoitb.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class PvpListener implements Listener {

	@EventHandler
	public void arrowHitEvent(EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if(player.getLocation().getWorld() != Bukkit.getWorld("world")) {
				if(e.getDamager() instanceof Arrow) {
					Arrow arrow = (Arrow) e.getDamager();
					Player attacker = (Player) arrow.getShooter();
					if (e.getEntity() instanceof Player) {
						if(attacker != player) {
							new PlayerUtils().fakePlayerDeath(player);
							if(OITB.getInstance().getPlayerArena().containsKey(player) && OITB.getInstance().getPlayerArena().get(player) != null) {
								OITB.getInstance().getPlayerArena().get(player).setPlayers(OITB.getInstance().getPlayerArena().get(player).getPlayers()-1);
								OITB.getInstance().getPlayerArena().replace(player, null);
							}
							OitbPlayer oitbVictim = OITB.getInstance().getOitbPlayers().get(player);
							oitbVictim.setDeaths(oitbVictim.getDeaths()+1);
							OitbPlayer oitbAttacker = OITB.getInstance().getOitbPlayers().get(attacker);
							oitbAttacker.setKills(oitbAttacker.getKills()+1);
							oitbAttacker.setHits(oitbAttacker.getHits()+1);
							oitbAttacker.setCoins(oitbAttacker.getCoins()+50);
							new ExpUtils().addPlayerExp(attacker, 40);
							PackageSender.sendActionbar(attacker, "§b+50 Coins §7- §b+40 XP");
							attacker.setHealth((double) 20);
							attacker.playSound(attacker.getLocation(), Sound.LEVEL_UP, 1, 1);
							for(Entry<Player, OitbArena> entry : OITB.getInstance().getPlayerArena().entrySet()) {
								if(OITB.getInstance().getPlayerArena().get(attacker) == entry.getValue()) {
									entry.getKey().sendMessage(("§8[§b!§8] §b» §c" + player.getName() + " §7s'est fait One Shot par §b" + attacker.getName() + " §7!"));
								}
							}
							attacker.getInventory().addItem(new ItemStack(Material.ARROW));

							if(OITB.getInstance().getScoreboards().containsKey(player)) {
								OITB.getInstance().getScoreboards().get(player).setLine(7, " §f➥ §7Morts: §f" + oitbVictim.getDeaths());
							}
							if(OITB.getInstance().getScoreboards().containsKey(attacker)) {
								OITB.getInstance().getScoreboards().get(attacker).setLine(2, " §f➥ §7Coins: §f" + oitbAttacker.getCoins());
								OITB.getInstance().getScoreboards().get(attacker).setLine(6, " §f➥ §7Eliminations: §f" + oitbAttacker.getKills());
								OITB.getInstance().getScoreboards().get(attacker).setLine(8, " §f➥ §7OneShots: §f" + oitbAttacker.getHits());
							}
						}
					}

				} else if(e.getDamager() instanceof Player) {
					OitbPlayer oitbVictim = OITB.getInstance().getOitbPlayers().get(player);
					Player attacker = (Player) e.getDamager();
					OitbPlayer oitbAttacker = OITB.getInstance().getOitbPlayers().get(attacker);

					double damage = 5;
					double protection = 1;
					double axeMultiplier = 0;
					if(attacker.getItemInHand() != null && attacker.getItemInHand().getType() != Material.AIR && attacker.getItemInHand().hasItemMeta() && attacker.getItemInHand().getItemMeta().hasDisplayName()) {
						if(attacker.getItemInHand().getType() == Material.DIAMOND_AXE
								|| attacker.getItemInHand().getType() == Material.GOLD_AXE
								|| attacker.getItemInHand().getType() == Material.IRON_AXE
								|| attacker.getItemInHand().getType() == Material.STONE_AXE
								|| attacker.getItemInHand().getType() == Material.WOOD_AXE) {
							if(attacker.getItemInHand() != null && attacker.getItemInHand().getType() != Material.AIR && attacker.getItemInHand().hasItemMeta() && attacker.getItemInHand().getItemMeta().hasDisplayName()) {
								axeMultiplier = Double.parseDouble(attacker.getItemInHand().getItemMeta().getDisplayName().replace("§bHache rang ", ""));
								axeMultiplier=axeMultiplier/3;
							}

							protection = protection+((double)oitbVictim.getHelmet().getProtectionLevel()/8);
							protection = protection+((double)oitbVictim.getChestplate().getProtectionLevel()/8);
							protection = protection+((double)oitbVictim.getLeggings().getProtectionLevel()/8);
							protection = protection+((double)oitbVictim.getBoots().getProtectionLevel()/8);
							damage = (damage *axeMultiplier)/protection;

							if(damage >= player.getHealth()) {
								new PlayerUtils().fakePlayerDeath(player);
								if(OITB.getInstance().getPlayerArena().containsKey(player) && OITB.getInstance().getPlayerArena().get(player) != null) {
									OITB.getInstance().getPlayerArena().get(player).setPlayers(OITB.getInstance().getPlayerArena().get(player).getPlayers()-1);
									OITB.getInstance().getPlayerArena().replace(player, null);
								}
								oitbVictim.setDeaths(oitbVictim.getDeaths()+1);
								oitbAttacker.setKills(oitbAttacker.getKills()+1);
								oitbAttacker.setCoins(oitbAttacker.getCoins()+30);
								new ExpUtils().addPlayerExp(attacker, 25);
								PackageSender.sendActionbar(attacker, "§b+30 Coins §7- §b+25 XP");
								attacker.setHealth((double) 20);
								attacker.playSound(attacker.getLocation(), Sound.LEVEL_UP, 1, 1);
								for(Entry<Player, OitbArena> entry : OITB.getInstance().getPlayerArena().entrySet()) {
									if(OITB.getInstance().getPlayerArena().get(attacker) == entry.getValue()) {
										entry.getKey().sendMessage("§8[§b!§8] §b» §c" + player.getName() + " §7s'est fait tuer par §b" + attacker.getName() + " §7!");
									}
								}
								if(OITB.getInstance().getPlayerArena().get(attacker).getType() != ArenaType.ONLY_AXE) {
									attacker.getInventory().addItem(new ItemStack(Material.ARROW));
								}
								if(OITB.getInstance().getScoreboards().containsKey(player)) {
									OITB.getInstance().getScoreboards().get(player).setLine(7, " §f➥ §7Morts: §f" + oitbVictim.getDeaths());
								}
								if(OITB.getInstance().getScoreboards().containsKey(attacker)) {
									OITB.getInstance().getScoreboards().get(attacker).setLine(2, " §f➥ §7Coins: §f" + oitbAttacker.getCoins());
									OITB.getInstance().getScoreboards().get(attacker).setLine(6, " §f➥ §7Eliminations: §f" + oitbAttacker.getKills());
								}
							} else {
								e.setDamage(0);
								player.setHealth(player.getHealth() - damage);
							}
						} else {
							e.setCancelled(true);
						}

					} else {
						e.setCancelled(true);
					}
				}
			} else {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void arrowShootEvent(EntityShootBowEvent e) {
		if(e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
			oitbPlayer.setBowShots(oitbPlayer.getBowShots()+1);
			Bukkit.getScheduler().scheduleSyncDelayedTask(OITB.getInstance(), new Runnable() {

				@Override
				public void run() {
					e.getProjectile().remove();
					if(OITB.getInstance().getPlayerArena().containsKey(player) && OITB.getInstance().getPlayerArena().get(player) != null && OITB.getInstance().getPlayerArena().get(player).getType() == ArenaType.ONLY_BOW) {
						player.getInventory().addItem(new ItemStack(Material.ARROW));
					}

				}
			}, 20 * 3);
		}
	}

	@EventHandler
	public void playerDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			if(e.getCause() == DamageCause.FALL || e.getCause() == DamageCause.SUFFOCATION) {
				e.setCancelled(true);
			}
		}
	}
}