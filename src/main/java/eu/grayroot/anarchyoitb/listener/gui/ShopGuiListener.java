package eu.grayroot.anarchyoitb.listener.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbItem;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		final Player player = (Player)e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();

		switch(inv.getName()) {
		case "§8[§eShop§8]":
			e.setCancelled(true);
			OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				OitbItem oitbItem = OitbItem.findByName(current.getItemMeta().getDisplayName());
				if(oitbItem != null) {
					if(oitbPlayer.getHelmet() == oitbItem
							|| oitbPlayer.getChestplate() == oitbItem
							|| oitbPlayer.getLeggings() == oitbItem
							|| oitbPlayer.getBoots() == oitbItem
							|| oitbPlayer.getAxe() == oitbItem
							|| oitbPlayer.getInventory().contains(oitbItem)) {
						player.sendMessage("§8[§c!§8] §c» §7Vous possédez déjà cet item !");
					} else {
						if(oitbPlayer.getCoins() >= oitbItem.getPrice()) {
							player.sendMessage("§8[§b!§8] §b» §7Achat effectué avec succès (§c-" + oitbItem.getPrice() + "coins§7) !");
							oitbPlayer.setCoins(oitbPlayer.getCoins() - oitbItem.getPrice());
							oitbPlayer.getInventory().add(oitbItem);
							if(OITB.getInstance().getScoreboards().containsKey(player)) {
								OITB.getInstance().getScoreboards().get(player).setLine(2, " §f➥ §7Coins: §f" + oitbPlayer.getCoins());
							}
						} else {
							player.sendMessage("§8[§c!§8] §c» §7Vous n'avez pas assez de coins pour acheter cet item !");
						}
					}
				}
			}
		default:
			break;

		}
	}
}