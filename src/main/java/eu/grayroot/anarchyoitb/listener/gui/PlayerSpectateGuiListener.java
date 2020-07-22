package eu.grayroot.anarchyoitb.listener.gui;

import eu.grayroot.anarchyoitb.OITB;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerSpectateGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		final Player player = (Player)e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();

		switch(inv.getName()) {
		case "§8[§eSpectateur§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				if(OITB.getInstance().getPlayerArena().containsKey(Bukkit.getPlayer(current.getItemMeta().getDisplayName().replace("�b", "")))) {
					player.teleport(Bukkit.getPlayer(current.getItemMeta().getDisplayName().replace("�b", "")));
					player.setAllowFlight(true);
					player.setFlying(true);
					player.setFlySpeed(new Float(0.5));
				}
			}
		default:
			break;
		}

	}
}