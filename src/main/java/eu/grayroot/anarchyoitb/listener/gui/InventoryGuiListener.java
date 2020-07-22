package eu.grayroot.anarchyoitb.listener.gui;

import eu.grayroot.anarchyoitb.gui.CratesGUI;
import eu.grayroot.anarchyoitb.gui.EquipmentGUI;
import eu.grayroot.anarchyoitb.gui.InventoryGUI;
import eu.grayroot.anarchyoitb.gui.PlayerChestGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		final Player player = (Player)e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();

		switch(inv.getName()) {
		case "§8[§eInventaire§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§bEquipement":
					new EquipmentGUI().openGui(player);
					break;
				case "§bCoffre Personnel":
					new PlayerChestGUI().openGui(player);
					break;
				case "§bCrates":
					new CratesGUI().openGui(player);
					break;
				case "§cRetour":
					new InventoryGUI().openGui(player);
					break;
				default:
					break;
				}
			}
		default:
			break;

		}
	}
}