package eu.grayroot.anarchyoitb.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ArenaListGUI {

	public ArenaListGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player) {
		Inventory menu = Bukkit.createInventory(null, 27, "§8[§eListe des arènes§8]");


		for (int i = 0; i < OITB.getInstance().getOitbArenas().size(); i++) {
			if(OITB.getInstance().getOitbArenas().get(i).getStatus() == 1) {
				menu.addItem(new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§b" + OITB.getInstance().getOitbArenas().get(i).getName().replaceAll("_", " ")).setSkull("http://textures.minecraft.net/texture/1b67edb6ab2129a3b439dde98869e05af81c86d94815e37d31359bcd3ddf458d")
						.setLore("", "§b» §7Type: §b" + OITB.getInstance().getOitbArenas().get(i).getType().getName(), "§b» §7Puissance maximale: §b" + String.valueOf(OITB.getInstance().getOitbArenas().get(i).getMaxPower()).replace("-1", "✘"), "§b» §7Joueurs: §b" + OITB.getInstance().getOitbArenas().get(i).getPlayers() + "§7/§c" + OITB.getInstance().getOitbArenas().get(i).getMaxPlayers(), "§b» §7Status: §a✔", "§b» §7Clique pour §brejoindre §7!")
						.setHidenItemFlags().toItemStack());
			} else {
				menu.addItem(new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§b" + OITB.getInstance().getOitbArenas().get(i).getName().replaceAll("_", " ")).setSkull("http://textures.minecraft.net/texture/49841ce86bfc39591e88579203ec4c8ef2c86a23aea0924591b931ea85efa")
						.setLore("", "§b» §7Type: §b" + OITB.getInstance().getOitbArenas().get(i).getType().getName(), "§b» §7Puissance maximale: §b" + String.valueOf(OITB.getInstance().getOitbArenas().get(i).getMaxPower()).replace("-1", "✘"), "§b» §7Joueurs: §b" + OITB.getInstance().getOitbArenas().get(i).getPlayers() + "§7/§c" + OITB.getInstance().getOitbArenas().get(i).getMaxPlayers(), "§b» §7Status: §c✘")
						.setHidenItemFlags().toItemStack());
			}
		}

		@SuppressWarnings("deprecation")
		ItemStack Background = new ItemStack (Material.STAINED_GLASS_PANE, 1, DyeColor.WHITE.getDyeData());
		for(int i = 0; i < 27; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}
		player.openInventory(menu);
	}

}
