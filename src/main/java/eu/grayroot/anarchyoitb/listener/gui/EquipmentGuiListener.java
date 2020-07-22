package eu.grayroot.anarchyoitb.listener.gui;

import eu.grayroot.anarchyoitb.gui.EditEquipmentGUI;
import eu.grayroot.anarchyoitb.gui.InventoryGUI;
import eu.grayroot.anarchyoitb.object.OitbItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EquipmentGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		final Player player = (Player)e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();

		switch(inv.getName()) {
		case "§8[§eEquipement§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§cRetour":
					new InventoryGUI().openGui(player);
					break;
				default:
					OitbItem oitbItem = OitbItem.findByName(current.getItemMeta().getDisplayName());
					switch (e.getSlot()) {
					case 10:
						if(oitbItem != null) {
							new EditEquipmentGUI().openGui(player, 1);
						}
						break;
					case 12:
						if(oitbItem != null) {
							new EditEquipmentGUI().openGui(player, 2);
						}
						break;
					case 14:
						if(oitbItem != null) {
							new EditEquipmentGUI().openGui(player, 3);
						}
						break;
					case 16:
						if(oitbItem != null) {
							new EditEquipmentGUI().openGui(player, 4);
						}
						break;
					case 22:
						if(oitbItem != null) {
							new EditEquipmentGUI().openGui(player, 5);
						}
						break;
					default:
						break;
					}
					break;
				}
			}
		default:
			break;

		}
	}
}