package eu.grayroot.anarchyoitb.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbItem;
import eu.grayroot.anarchyoitb.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerChestGUI {

	public PlayerChestGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player) {
		Inventory menu = Bukkit.createInventory(null, 36, "§8[§eCoffre Personnel§8]");


		for (OitbItem oitbItem : OITB.getInstance().getOitbPlayers().get(player).getInventory()) {
			menu.addItem(new ItemBuilder(oitbItem.getMaterial()).setName(oitbItem.getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + oitbItem.getRarity())
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbItem.getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, oitbItem.getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
		}
		
		menu.setItem(27, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§cRetour").setSkull("http://textures.minecraft.net/texture/eed78822576317b048eea92227cd85f7afcc44148dcb832733baccb8eb56fa1")
				.setHidenItemFlags().toItemStack());

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
