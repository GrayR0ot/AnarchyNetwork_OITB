package eu.grayroot.anarchyoitb.gui;

import eu.grayroot.anarchyoitb.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryGUI {

	public InventoryGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player) {
		Inventory menu = Bukkit.createInventory(null, 27, "§8[§eInventaire§8]");
		
		menu.setItem(11, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§bEquipement").setSkull("http://textures.minecraft.net/texture/12f357ab59e04e676724c63d704c3d1f2f9ae1ad4283e91d7da26efc6c4808")
				.setHidenItemFlags().toItemStack());
		
		menu.setItem(13, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§bCoffre Personnel").setSkull("http://textures.minecraft.net/texture/5a736eb1a7ce5a5f5d5b168931fa31396386c160568b41964ba86cdb9ed6be")
				.setHidenItemFlags().toItemStack());
		
		menu.setItem(15, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§bCrates").setSkull("http://textures.minecraft.net/texture/382662a199ca29479ffea9de82ca6305ef5c2b5d478ac7626a420465bc69c5b")
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
