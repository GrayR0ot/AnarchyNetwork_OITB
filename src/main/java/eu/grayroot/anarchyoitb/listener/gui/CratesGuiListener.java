package eu.grayroot.anarchyoitb.listener.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.gui.InventoryGUI;
import eu.grayroot.anarchyoitb.gui.ShopGUI;
import eu.grayroot.anarchyoitb.object.OitbItem;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import eu.grayroot.anarchyoitb.utils.CrateInventory;
import eu.grayroot.anarchyoitb.utils.ItemBuilder;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CratesGuiListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		final Player player = (Player)e.getWhoClicked();
		Inventory inv = e.getInventory();
		ItemStack current = e.getCurrentItem();

		switch(inv.getName()) {
		case "§8[§eCrates§8]":
			e.setCancelled(true);
			OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
			if(e.getClickedInventory()==null)return;
			if(current.hasItemMeta() && current.getItemMeta().hasDisplayName()) {
				switch (current.getItemMeta().getDisplayName()) {
				case "§bCrate commune":
					if(oitbPlayer.getInventory().contains(OitbItem.findById(25))) {
						ItemStack[] items = new ItemStack[6];
						items[0] = new ItemBuilder(OitbItem.findById(5).getMaterial()).setName(OitbItem.findById(5).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[1] = new ItemBuilder(OitbItem.findById(6).getMaterial()).setName(OitbItem.findById(6).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[2] = new ItemBuilder(OitbItem.findById(7).getMaterial()).setName(OitbItem.findById(7).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[3] = new ItemBuilder(OitbItem.findById(8).getMaterial()).setName(OitbItem.findById(8).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[4] = new ItemBuilder(OitbItem.findById(19).getMaterial()).setName(OitbItem.findById(19).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[5] = new ItemBuilder(OitbItem.findById(20).getMaterial()).setName(OitbItem.findById(20).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();

						CrateInventory crate = new CrateInventory(9, items, "§8[§eCrate commune§8]", OITB.getInstance());
						oitbPlayer.getInventory().remove(OitbItem.findById(25));
						crate.spin(5, player);
					} else {
						new ShopGUI().openGui(player);
					}
					break;
				case "§bCrate rare":
					if(oitbPlayer.getInventory().contains(OitbItem.findById(26))) {
						ItemStack[] items = new ItemStack[6];
						items[0] = new ItemBuilder(OitbItem.findById(9).getMaterial()).setName(OitbItem.findById(5).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[1] = new ItemBuilder(OitbItem.findById(10).getMaterial()).setName(OitbItem.findById(6).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[2] = new ItemBuilder(OitbItem.findById(11).getMaterial()).setName(OitbItem.findById(7).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[3] = new ItemBuilder(OitbItem.findById(12).getMaterial()).setName(OitbItem.findById(8).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[4] = new ItemBuilder(OitbItem.findById(21).getMaterial()).setName(OitbItem.findById(19).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[5] = new ItemBuilder(OitbItem.findById(22).getMaterial()).setName(OitbItem.findById(20).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();

						CrateInventory crate = new CrateInventory(9, items, "§8[§eCrate rare§8]", OITB.getInstance());
						oitbPlayer.getInventory().remove(OitbItem.findById(26));
						crate.spin(5, player);
					} else {
						new ShopGUI().openGui(player);
					}
					break;
				case "§bCrate légendaire":
					if(oitbPlayer.getInventory().contains(OitbItem.findById(27))) {
						ItemStack[] items = new ItemStack[6];
						items[0] = new ItemBuilder(OitbItem.findById(13).getMaterial()).setName(OitbItem.findById(13).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[1] = new ItemBuilder(OitbItem.findById(14).getMaterial()).setName(OitbItem.findById(14).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[2] = new ItemBuilder(OitbItem.findById(15).getMaterial()).setName(OitbItem.findById(15).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[3] = new ItemBuilder(OitbItem.findById(16).getMaterial()).setName(OitbItem.findById(16).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[4] = new ItemBuilder(OitbItem.findById(23).getMaterial()).setName(OitbItem.findById(23).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();
						items[5] = new ItemBuilder(OitbItem.findById(24).getMaterial()).setName(OitbItem.findById(24).getName().replace("_", " ")).addEnchant(Enchantment.DURABILITY, 1).setHidenItemFlags().toItemStack();

						CrateInventory crate = new CrateInventory(9, items, "§8[§eCrate légendaire§8]", OITB.getInstance());
						oitbPlayer.getInventory().remove(OitbItem.findById(27));
						crate.spin(5, player);
					} else {
						new ShopGUI().openGui(player);
					}
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