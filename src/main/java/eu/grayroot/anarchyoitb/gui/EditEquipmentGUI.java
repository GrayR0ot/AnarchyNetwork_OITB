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

public class EditEquipmentGUI {

	public EditEquipmentGUI() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void openGui(Player player, int slot) {
		Inventory menu = null;

		@SuppressWarnings("deprecation")
		ItemStack Background = new ItemStack (Material.STAINED_GLASS_PANE, 1, DyeColor.WHITE.getDyeData());

		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		switch (slot) {
		case 1:
			menu = Bukkit.createInventory(null, 36, "§8[§eEdition Casque§8]");
			menu.setItem(10, new ItemBuilder(oitbPlayer.getHelmet().getMaterial()).setName(oitbPlayer.getHelmet().getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getHelmet().getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getHelmet().getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getHelmet().getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			menu.setItem(13, new ItemBuilder(OitbItem.findById(1).getMaterial()).setName(OitbItem.findById(1).getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(1).getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(1).getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(1).getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			if(oitbPlayer.getInventory().contains(OitbItem.findById(5))) {
				menu.setItem(14, new ItemBuilder(OitbItem.findById(5).getMaterial()).setName(OitbItem.findById(5).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(5).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(5).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(5).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(9))) {
				menu.setItem(15, new ItemBuilder(OitbItem.findById(9).getMaterial()).setName(OitbItem.findById(9).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(9).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(9).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(9).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(13))) {
				menu.setItem(16, new ItemBuilder(OitbItem.findById(13).getMaterial()).setName(OitbItem.findById(13).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(13).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(13).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(13).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			break;
		case 2:
			menu = Bukkit.createInventory(null, 36, "§8[§eEdition Plastron§8]");
			menu.setItem(10, new ItemBuilder(oitbPlayer.getChestplate().getMaterial()).setName(oitbPlayer.getChestplate().getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getChestplate().getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getChestplate().getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getChestplate().getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			menu.setItem(13, new ItemBuilder(OitbItem.findById(2).getMaterial()).setName(OitbItem.findById(2).getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(2).getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(2).getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(2).getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			if(oitbPlayer.getInventory().contains(OitbItem.findById(6))) {
				menu.setItem(14, new ItemBuilder(OitbItem.findById(6).getMaterial()).setName(OitbItem.findById(6).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(6).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(6).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(6).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(10))) {
				menu.setItem(15, new ItemBuilder(OitbItem.findById(10).getMaterial()).setName(OitbItem.findById(10).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(10).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(10).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(10).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(14))) {
				menu.setItem(16, new ItemBuilder(OitbItem.findById(14).getMaterial()).setName(OitbItem.findById(14).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(14).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(14).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(14).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			break;
		case 3:
			menu = Bukkit.createInventory(null, 36, "§8[§eEdition Pantalon§8]");
			menu.setItem(10, new ItemBuilder(oitbPlayer.getLeggings().getMaterial()).setName(oitbPlayer.getLeggings().getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getLeggings().getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getLeggings().getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getLeggings().getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			menu.setItem(13, new ItemBuilder(OitbItem.findById(3).getMaterial()).setName(OitbItem.findById(3).getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(3).getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(3).getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(3).getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			if(oitbPlayer.getInventory().contains(OitbItem.findById(7))) {
				menu.setItem(14, new ItemBuilder(OitbItem.findById(7).getMaterial()).setName(OitbItem.findById(7).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(7).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(7).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(7).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(11))) {
				menu.setItem(15, new ItemBuilder(OitbItem.findById(11).getMaterial()).setName(OitbItem.findById(11).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(11).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(11).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(11).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(15))) {
				menu.setItem(16, new ItemBuilder(OitbItem.findById(15).getMaterial()).setName(OitbItem.findById(15).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(15).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(15).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(15).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			break;
		case 4:
			menu = Bukkit.createInventory(null, 36, "§8[§eEdition Bottes§8]");
			menu.setItem(10, new ItemBuilder(oitbPlayer.getBoots().getMaterial()).setName(oitbPlayer.getBoots().getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getBoots().getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getBoots().getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getBoots().getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			menu.setItem(13, new ItemBuilder(OitbItem.findById(4).getMaterial()).setName(OitbItem.findById(4).getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(4).getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(4).getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(4).getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			if(oitbPlayer.getInventory().contains(OitbItem.findById(8))) {
				menu.setItem(14, new ItemBuilder(OitbItem.findById(8).getMaterial()).setName(OitbItem.findById(8).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(8).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(8).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(8).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(12))) {
				menu.setItem(15, new ItemBuilder(OitbItem.findById(12).getMaterial()).setName(OitbItem.findById(12).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(12).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(12).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(12).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(16))) {
				menu.setItem(16, new ItemBuilder(OitbItem.findById(16).getMaterial()).setName(OitbItem.findById(16).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(16).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(16).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(16).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			break;
		case 5:
			menu = Bukkit.createInventory(null, 36, "§8[§eEdition Hache§8]");
			menu.setItem(10, new ItemBuilder(oitbPlayer.getAxe().getMaterial()).setName(oitbPlayer.getAxe().getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + oitbPlayer.getAxe().getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getAxe().getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getAxe().getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			menu.setItem(13, new ItemBuilder(OitbItem.findById(17).getMaterial()).setName(OitbItem.findById(17).getName().replaceAll("_", " "))
					.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(17).getRarity(),
							"", "§b» §aClique utiliser !")
					.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(17).getProtectionLevel())
					.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(17).getSharpnessLevel())
					.setHidenItemFlags().toItemStack());
			if(oitbPlayer.getInventory().contains(OitbItem.findById(18))) {
				menu.setItem(14, new ItemBuilder(OitbItem.findById(18).getMaterial()).setName(OitbItem.findById(18).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(18).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(18).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(18).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(19))) {
				menu.setItem(15, new ItemBuilder(OitbItem.findById(19).getMaterial()).setName(OitbItem.findById(19).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(19).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(19).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(19).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(20))) {
				menu.setItem(16, new ItemBuilder(OitbItem.findById(20).getMaterial()).setName(OitbItem.findById(20).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(20).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(20).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(20).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(21))) {
				menu.setItem(22, new ItemBuilder(OitbItem.findById(21).getMaterial()).setName(OitbItem.findById(21).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(21).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(21).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(21).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(22, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(22))) {
				menu.setItem(23, new ItemBuilder(OitbItem.findById(22).getMaterial()).setName(OitbItem.findById(22).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(22).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(22).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(22).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(23, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(23))) {
				menu.setItem(24, new ItemBuilder(OitbItem.findById(23).getMaterial()).setName(OitbItem.findById(23).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(23).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(23).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(23).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(24, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			if(oitbPlayer.getInventory().contains(OitbItem.findById(24))) {
				menu.setItem(25, new ItemBuilder(OitbItem.findById(24).getMaterial()).setName(OitbItem.findById(24).getName().replaceAll("_", " "))
						.setLore("", "§b» §7Rareté: §b" + OitbItem.findById(24).getRarity(),
								"", "§b» §aClique utiliser !")
						.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, OitbItem.findById(24).getProtectionLevel())
						.addEnchant(Enchantment.DAMAGE_ALL, OitbItem.findById(24).getSharpnessLevel())
						.setHidenItemFlags().toItemStack());
			} else {
				menu.setItem(25, new ItemBuilder(Material.STAINED_GLASS_PANE,1,(short)14).setName("§cItem non disponible")
						.setHidenItemFlags().toItemStack());
			}
			break;

		default:
			break;
		}

		for(int i = 0; i < 10; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}
		for(int i = 11; i < 13; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}

		for(int i = 13; i < 26; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}
		menu.setItem(27, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§cRetour").setSkull("http://textures.minecraft.net/texture/eed78822576317b048eea92227cd85f7afcc44148dcb832733baccb8eb56fa1")
				.setHidenItemFlags().toItemStack());

		for(int i = 17; i < 22; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}
		for(int i = 26; i < 36; i++) {
			if(menu.getItem(i) == null || menu.getItem(i).getType() == Material.AIR) {
				menu.setItem(i, Background);
			}
		}
		player.openInventory(menu);
	}

}
