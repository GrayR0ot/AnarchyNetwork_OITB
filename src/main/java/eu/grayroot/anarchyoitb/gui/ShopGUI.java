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

public class ShopGUI {

	public ShopGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player) {
		Inventory menu = Bukkit.createInventory(null, 36, "§8[§eShop§8]");

		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		for (OitbItem oitbItem : OITB.getInstance().getOitbItems()) {
			if(oitbPlayer.getHelmet() == oitbItem
					|| oitbPlayer.getChestplate() == oitbItem
					|| oitbPlayer.getLeggings() == oitbItem
					|| oitbPlayer.getBoots() == oitbItem
					|| oitbPlayer.getAxe() == oitbItem
					|| oitbPlayer.getInventory().contains(oitbItem)) {
				menu.addItem(new ItemBuilder(oitbItem.getMaterial()).setName(oitbItem.getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + oitbItem.getRarity(),
								"§b» §7Prix: §b" + oitbItem.getPrice(),
								"", "§b» §cObjet déjà possédé !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbItem.getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, oitbItem.getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.addItem(new ItemBuilder(oitbItem.getMaterial()).setName(oitbItem.getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + oitbItem.getRarity(),
								"§b» §7Prix: §b" + oitbItem.getPrice(),
								"", "§b» §aClique pour acheter !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbItem.getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, oitbItem.getSharpnessLevel())
						.setHidenItemFlags().toItemStack());

			}
		}

		@SuppressWarnings("deprecation")
		ItemStack Background = new ItemStack (Material.STAINED_GLASS_PANE, 1, DyeColor.WHITE.getDyeData());
		for(int i = 0; i < 36; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}
		player.openInventory(menu);

	}
}
