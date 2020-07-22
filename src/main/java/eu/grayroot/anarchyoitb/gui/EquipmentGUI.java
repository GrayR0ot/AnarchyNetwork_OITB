package eu.grayroot.anarchyoitb.gui;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import eu.grayroot.anarchyoitb.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EquipmentGUI {

	public EquipmentGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player) {
		Inventory menu = Bukkit.createInventory(null, 36, "§8[§eEquipement§8]");

		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		menu.setItem(10, new ItemBuilder(oitbPlayer.getHelmet().getMaterial()).setName(oitbPlayer.getHelmet().getName().replaceAll("_", " "))
				.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getHelmet().getRarity(),
						"", "§b» §aClique changer !")
				.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getHelmet().getProtectionLevel())
				.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getHelmet().getSharpnessLevel())
				.setHidenItemFlags().toItemStack());
		
		menu.setItem(12, new ItemBuilder(oitbPlayer.getChestplate().getMaterial()).setName(oitbPlayer.getChestplate().getName().replaceAll("_", " "))
				.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getChestplate().getRarity(),
						"", "§b» §aClique changer !")
				.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getChestplate().getProtectionLevel())
				.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getHelmet().getSharpnessLevel())
				.setHidenItemFlags().toItemStack());
		
		menu.setItem(14, new ItemBuilder(oitbPlayer.getLeggings().getMaterial()).setName(oitbPlayer.getLeggings().getName().replaceAll("_", " "))
				.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getLeggings().getRarity(),
						"", "§b» §aClique changer !")
				.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getLeggings().getProtectionLevel())
				.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getLeggings().getSharpnessLevel())
				.setHidenItemFlags().toItemStack());
		
		menu.setItem(16, new ItemBuilder(oitbPlayer.getBoots().getMaterial()).setName(oitbPlayer.getBoots().getName().replaceAll("_", " "))
				.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getBoots().getRarity(),
						"", "§b» §aClique changer !")
				.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getBoots().getProtectionLevel())
				.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getBoots().getSharpnessLevel())
				.setHidenItemFlags().toItemStack());
		
		menu.setItem(22, new ItemBuilder(oitbPlayer.getAxe().getMaterial()).setName(oitbPlayer.getAxe().getName().replaceAll("_", " "))
				.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getAxe().getRarity(),
						"", "§b» §aClique changer !")
				.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getAxe().getProtectionLevel())
				.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getAxe().getSharpnessLevel())
				.setHidenItemFlags().toItemStack());
		
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
