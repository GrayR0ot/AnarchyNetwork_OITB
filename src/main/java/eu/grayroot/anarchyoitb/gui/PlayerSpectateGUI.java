package eu.grayroot.anarchyoitb.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerSpectateGUI {

	public PlayerSpectateGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player) {
		Inventory menu = Bukkit.createInventory(null, 54, "§8[§eSpectateur§8]");


		for (Player player2 : Bukkit.getOnlinePlayers()) {
			if(OITB.getInstance().getPlayerArena().containsKey(player2)) {
				menu.addItem(new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§b" + player2.getName()).setSkullOwner(player2.getName())
						.setLore("", "§b» §7Clique pour t'y téléporter").toItemStack());
			}
		}

		@SuppressWarnings("deprecation")
		ItemStack Background = new ItemStack (Material.STAINED_GLASS_PANE, 1, DyeColor.WHITE.getDyeData());
		for(int i = 0; i < 54; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}
		player.openInventory(menu);
	}

}
