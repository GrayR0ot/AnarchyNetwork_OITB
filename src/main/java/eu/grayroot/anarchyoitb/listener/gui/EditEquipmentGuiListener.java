package eu.grayroot.anarchyoitb.listener.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.gui.EditEquipmentGUI;
import eu.grayroot.anarchyoitb.gui.EquipmentGUI;
import eu.grayroot.anarchyoitb.object.OitbItem;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EditEquipmentGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		final Player player = (Player)e.getWhoClicked();
		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();

		switch(inv.getName()) {
		case "§8[§eEdition Casque§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§cRetour":
					new EquipmentGUI().openGui(player);
					break;
				default:
					OitbItem oitbItem = OitbItem.findByName(current.getItemMeta().getDisplayName());
					if(oitbItem != null) {
						oitbPlayer.setHelmet(oitbItem);
						oitbPlayer.getInventory().add(OitbItem.findByName(inv.getItem(10).getItemMeta().getDisplayName()));
						oitbPlayer.getInventory().remove(oitbItem);
						player.closeInventory();
						new EditEquipmentGUI().openGui(player, 1);
					}
					break;
				}
			}
			break;
		case "§8[§eEdition Plastron§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§cRetour":
					new EquipmentGUI().openGui(player);
					break;
				default:
					OitbItem oitbItem = OitbItem.findByName(current.getItemMeta().getDisplayName());
					if(oitbItem != null) {
						oitbPlayer.setChestplate(oitbItem);
						oitbPlayer.getInventory().add(OitbItem.findByName(inv.getItem(10).getItemMeta().getDisplayName()));
						oitbPlayer.getInventory().remove(oitbItem);
						player.closeInventory();
						new EditEquipmentGUI().openGui(player, 2);
					}
					break;
				}
			}
			break;
		case "§8[§eEdition Pantalon§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§cRetour":
					new EquipmentGUI().openGui(player);
					break;
				default:
					OitbItem oitbItem = OitbItem.findByName(current.getItemMeta().getDisplayName());
					if(oitbItem != null) {
						oitbPlayer.setLeggings(oitbItem);
						oitbPlayer.getInventory().add(OitbItem.findByName(inv.getItem(10).getItemMeta().getDisplayName()));
						oitbPlayer.getInventory().remove(oitbItem);
						player.closeInventory();
						new EditEquipmentGUI().openGui(player, 3);
					}
					break;
				}
			}
			break;
		case "§8[§eEdition Bottes§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§cRetour":
					new EquipmentGUI().openGui(player);
					break;
				default:
					OitbItem oitbItem = OitbItem.findByName(current.getItemMeta().getDisplayName());
					if(oitbItem != null) {
						oitbPlayer.setBoots(oitbItem);
						oitbPlayer.getInventory().add(OitbItem.findByName(inv.getItem(10).getItemMeta().getDisplayName()));
						oitbPlayer.getInventory().remove(oitbItem);
						player.closeInventory();
						new EditEquipmentGUI().openGui(player, 4);
					}
					break;
				}
			}
			break;
		case "§8[§eEdition Hache§8]":
			e.setCancelled(true);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§cRetour":
					new EquipmentGUI().openGui(player);
					break;
				default:
					OitbItem oitbItem = OitbItem.findByName(current.getItemMeta().getDisplayName());
					if(oitbItem != null) {
						oitbPlayer.setAxe(oitbItem);
						oitbPlayer.getInventory().add(OitbItem.findByName(inv.getItem(10).getItemMeta().getDisplayName()));
						oitbPlayer.getInventory().remove(oitbItem);
						player.closeInventory();
						new EditEquipmentGUI().openGui(player, 5);
					}
					break;
				}
			}
			break;
		default:
			break;

		}
	}
}