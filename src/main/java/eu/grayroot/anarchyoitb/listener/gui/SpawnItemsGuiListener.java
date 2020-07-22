package eu.grayroot.anarchyoitb.listener.gui;

import eu.grayroot.anarchyoitb.gui.ArenaListGUI;
import eu.grayroot.anarchyoitb.gui.InventoryGUI;
import eu.grayroot.anarchyoitb.gui.PlayerSpectateGUI;
import eu.grayroot.anarchyoitb.gui.ShopGUI;
import eu.grayroot.anarchyoitb.utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class SpawnItemsGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(PlayerInteractEvent e) {
		final Player player = (Player)e.getPlayer();
		if(player.getLocation().getWorld() == Bukkit.getWorld("world")) {
			ItemStack current = e.getItem();
			e.setCancelled(true);
			if(current != null && current.getType() != null && current.getType() != Material.AIR && current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch(current.getItemMeta().getDisplayName()) {
				case "§bRejoindre une arène":
					new ArenaListGUI().openGui(player);
					break;
				case "§dMode spectateur":
					new PlayerUtils().loadSpectator(player);
					player.sendMessage("§8[§b!§8] §b» §7Tu es en mode spectateur !");
					break;
				case "§aInventaire":
					new InventoryGUI().openGui(player);
					break;
				case "§cShop":
					new ShopGUI().openGui(player);
					break;
				default:
					break;
				}
			}

		}
		ItemStack current = e.getItem();
		if(current != null && current.getType() != null && current.getType() != Material.AIR && current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
			switch(current.getItemMeta().getDisplayName()) {
			case "§bJoueurs":
				new PlayerSpectateGUI().openGui(player);
				break;
			case "§cQuitter":
				player.sendMessage("§8[§b!§8] §b» §7Tu n'es plus en mode spectateur !");
				player.setFlying(false);
				player.setAllowFlight(false);
				player.removePotionEffect(PotionEffectType.INVISIBILITY);
				player.chat("/spawn");
				break;
			default:
				break;
			}
		}
		
	}
}