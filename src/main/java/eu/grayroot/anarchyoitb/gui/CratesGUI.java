package eu.grayroot.anarchyoitb.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbItem;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import eu.grayroot.anarchyoitb.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CratesGUI {

	public CratesGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player) {
		Inventory menu = Bukkit.createInventory(null, 27, "§8[§eCrates§8]");
		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);

		if(oitbPlayer.getInventory().contains(OitbItem.findById(25))) {
			menu.setItem(11, new ItemBuilder(Material.GOLD_BLOCK).setName("§bCrate commune").addEnchant(Enchantment.DURABILITY, 1)
					.setLore("", "§b» §aClique pour ouvrir !")
					.setHidenItemFlags().toItemStack());
		} else {
			menu.setItem(11, new ItemBuilder(Material.GOLD_BLOCK).setName("§bCrate commune").addEnchant(Enchantment.DURABILITY, 1)
					.setLore("", "§b» §cClique pour acheter !")
					.setHidenItemFlags().toItemStack());
		}

		if(oitbPlayer.getInventory().contains(OitbItem.findById(26))) {
			menu.setItem(13, new ItemBuilder(Material.DIAMOND_BLOCK).setName("§bCrate rare").addEnchant(Enchantment.DURABILITY, 1)
					.setLore("", "§b» §aClique pour ouvrir !")
					.setHidenItemFlags().toItemStack());
		} else {
			menu.setItem(13, new ItemBuilder(Material.DIAMOND_BLOCK).setName("§bCrate rare").addEnchant(Enchantment.DURABILITY, 1)
					.setLore("", "§b» §cClique pour acheter !")
					.setHidenItemFlags().toItemStack());
		}

		if(oitbPlayer.getInventory().contains(OitbItem.findById(27))) {
			menu.setItem(15, new ItemBuilder(Material.EMERALD_BLOCK).setName("§bCrate légendaire").addEnchant(Enchantment.DURABILITY, 1)
					.setLore("", "§b» §aClique pour ouvrir !")
					.setHidenItemFlags().toItemStack());
		} else {
			menu.setItem(15, new ItemBuilder(Material.EMERALD_BLOCK).setName("§bCrate légendaire").addEnchant(Enchantment.DURABILITY, 1)
					.setLore("", "§b» §cClique pour acheter !")
					.setHidenItemFlags().toItemStack());
		}
		
		menu.setItem(18, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§cRetour").setSkull("http://textures.minecraft.net/texture/eed78822576317b048eea92227cd85f7afcc44148dcb832733baccb8eb56fa1")
				.setHidenItemFlags().toItemStack());

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
