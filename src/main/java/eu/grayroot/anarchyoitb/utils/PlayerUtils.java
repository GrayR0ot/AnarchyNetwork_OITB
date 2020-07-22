package eu.grayroot.anarchyoitb.utils;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbArena;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerUtils {

	public PlayerUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void loadLobby(Player player) {
		player.setMaxHealth((double) 20);
		player.setHealth((double) 20);
		player.teleport(OITB.getInstance().getSpawn());
		player.getEquipment().setArmorContents(null);
		new PlayerUtils().loadInventory(player);
		player.setDisplayName(player.getName());
	};
	
	public void loadSpectator(Player player) {
		player.setMaxHealth((double) 20);
		player.setHealth((double) 20);
		player.setGameMode(GameMode.ADVENTURE);
		player.setAllowFlight(true);
		player.setFlying(true);
		player.setFlySpeed(new Float(0.5));
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 100000, 10));
		player.getInventory().clear();
		player.getInventory().setItem(0, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§bJoueurs").setSkull("http://textures.minecraft.net/texture/12f357ab59e04e676724c63d704c3d1f2f9ae1ad4283e91d7da26efc6c4808")
				.setHidenItemFlags().toItemStack());
		player.getInventory().setItem(8, new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§cQuitter").setSkull("http://textures.minecraft.net/texture/eed78822576317b048eea92227cd85f7afcc44148dcb832733baccb8eb56fa1")
			.setHidenItemFlags().toItemStack());
		player.teleport(OITB.getInstance().getSpawn());
	}

	public void loadInventory(Player player) {
		player.getInventory().clear();

		ItemStack arenasButton = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§bRejoindre une arène").setSkull("http://textures.minecraft.net/texture/12f357ab59e04e676724c63d704c3d1f2f9ae1ad4283e91d7da26efc6c4808").setHidenItemFlags().toItemStack();
		//ItemStack spectateButton = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§dMode spectateur").setSkull("http://textures.minecraft.net/texture/70e137e22d6f8c81cbce50657cdd78d00af1c4f1dee64786d6261bcb65e9c26a").setHidenItemFlags().toItemStack();
		ItemStack shopButton = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§cShop").setSkull("http://textures.minecraft.net/texture/3adbcfb288215a8d153ddfddb36bd2ed7a37add35662f8633f711d2dfceb417c").setHidenItemFlags().toItemStack();
		ItemStack inventoryButton = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§aInventaire").setSkull("http://textures.minecraft.net/texture/9c96be7886eb7df75525a363e5f549626c21388f0fda988a6e8bf487a53").setHidenItemFlags().toItemStack();

		double ratio = 1;
		if((OITB.getInstance().getOitbPlayers().get(player).getKills() == 0 || OITB.getInstance().getOitbPlayers().get(player).getDeaths() == 0)) {
			ratio = 1;
		} else {
			ratio = ((double) OITB.getInstance().getOitbPlayers().get(player).getKills() / (double) OITB.getInstance().getOitbPlayers().get(player).getDeaths());
		}
		ItemStack meButton = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§e" + player.getName())
				.setLore("",
						"§b» §7Rang: §b" + OITB.getInstance().getOitbPlayers().get(player).getRank(),
						"§b» §7Coins: §b" + OITB.getInstance().getOitbPlayers().get(player).getCoins(),
						"§b» §7Eliminations: §b" + OITB.getInstance().getOitbPlayers().get(player).getKills(),
						"§b» §7Morts: §b" + OITB.getInstance().getOitbPlayers().get(player).getDeaths(),
						"§b» §7Ratio: §b" + String.format("%.2f", ratio),
						"§b» §7OneShots: §b" + OITB.getInstance().getOitbPlayers().get(player).getHits(),
						"§b» §7Tirs § l'arc: §b" + OITB.getInstance().getOitbPlayers().get(player).getBowShots(),
						"§b» §7Puissance (équipement): §b" + new PlayerUtils().getPlayerPower(OITB.getInstance().getOitbPlayers().get(player))
						)
				.setSkull("http://textures.minecraft.net/texture/14f05fd4215ea2a43244e832c723f65f05c2562abfe0bdf336f50293e683789d").setHidenItemFlags().toItemStack();

		player.getInventory().setItem(1, arenasButton);
		//player.getInventory().setItem(2, spectateButton);
		player.getInventory().setItem(3, meButton);
		player.getInventory().setItem(5, inventoryButton);
		player.getInventory().setItem(7, shopButton);
	}

	public void loadStuff(Player player, OitbArena oitbArena) {
		OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
		player.getInventory().clear();
		player.getEquipment().setHelmet(new ItemBuilder(oitbPlayer.getHelmet().getMaterial()).setName(oitbPlayer.getHelmet().getName().replaceAll("_", " ")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getHelmet().getProtectionLevel()).setUnbreakable().setHidenEnchantment().toItemStack());
		player.getEquipment().setChestplate(new ItemBuilder(oitbPlayer.getChestplate().getMaterial()).setName(oitbPlayer.getChestplate().getName().replaceAll("_", " ")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getChestplate().getProtectionLevel()).setUnbreakable().setHidenEnchantment().toItemStack());
		player.getEquipment().setLeggings(new ItemBuilder(oitbPlayer.getLeggings().getMaterial()).setName(oitbPlayer.getLeggings().getName().replaceAll("_", " ")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getLeggings().getProtectionLevel()).setUnbreakable().setHidenEnchantment().toItemStack());
		player.getEquipment().setBoots(new ItemBuilder(oitbPlayer.getBoots().getMaterial()).setName(oitbPlayer.getBoots().getName().replaceAll("_", " ")).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, oitbPlayer.getBoots().getProtectionLevel()).setUnbreakable().setHidenEnchantment().toItemStack());

		switch (oitbArena.getType()) {
		case DEFAULT:
			player.getInventory().addItem(new ItemBuilder(oitbPlayer.getAxe().getMaterial()).setName(oitbPlayer.getAxe().getName().replaceAll("_", " ")).addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getAxe().getSharpnessLevel()).setUnbreakable().setHidenEnchantment().toItemStack());
			player.getInventory().addItem(new ItemBuilder(Material.BOW,1).setName("§bArc magique").toItemStack());
			player.getInventory().addItem(new ItemStack(Material.ARROW));
			break;
		case ONLY_BOW:
			player.getInventory().addItem(new ItemBuilder(Material.BOW,1).setName("§bArc magique").toItemStack());
			player.getInventory().addItem(new ItemStack(Material.ARROW));
			break;
		case ONLY_AXE:
			player.getInventory().addItem(new ItemBuilder(oitbPlayer.getAxe().getMaterial()).setName(oitbPlayer.getAxe().getName().replaceAll("_", " ")).addEnchant(Enchantment.DAMAGE_ALL, oitbPlayer.getAxe().getSharpnessLevel()).setUnbreakable().setHidenEnchantment().toItemStack());
			break;

		default:
			break;
		}


	}

	public int getPlayerPower(OitbPlayer oitbPlayer) {
		int power = 0;
		power = power+oitbPlayer.getHelmet().getPower();
		power = power+oitbPlayer.getChestplate().getPower();
		power = power+oitbPlayer.getLeggings().getPower();
		power = power+oitbPlayer.getBoots().getPower();
		power = power+oitbPlayer.getAxe().getPower();
		return power;
	}

	public void fakePlayerDeath(Player player) {
		new PlayerUtils().loadLobby(player);
		player.playSound(player.getLocation(), Sound.ITEM_BREAK, 1, 1);

	}

}
