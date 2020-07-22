package eu.grayroot.anarchyoitb.utils;
import java.util.concurrent.ThreadLocalRandom;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.OitbItem;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CrateInventory {

	private Inventory inv;
	private Plugin plugin;
	private ItemStack[] contents;

	private InventoryClickHandler helper;

	private int itemIndex = 0;

	public CrateInventory(int size, ItemStack[] contents, String name,
			Plugin main) {
		inv = Bukkit.createInventory(null, size, name);
		this.plugin = main;
		this.contents = contents;
		helper = new InventoryClickHandler(main, name);
		shuffle();
	}

	public void shuffle() {
		int startingIndex = ThreadLocalRandom.current().nextInt(
				this.contents.length);
		for (int index = 0; index < startingIndex; index++) {
			for (int itemstacks = 0; itemstacks < inv.getSize(); itemstacks++) {
				inv.setItem(itemstacks, contents[(itemstacks + itemIndex)
				                                 % contents.length]);
			}
			itemIndex++;
		}
	}

	public InventoryClickHandler getInventoryClickManager() {
		return helper;
	}

	public void setContents(ItemStack[] contents) {
		this.contents = contents;
	}

	public ItemStack[] getContents() {
		return this.contents;
	}

	public Inventory getInventory() {
		return inv;
	}

	public void spin(final double seconds, final Player player) {
		player.openInventory(this.inv);
		new BukkitRunnable() {
			double delay = 0;
			int ticks = 0;
			boolean done = false;

			public void run() {
				if (done)
					return;
				ticks++;
				delay += 1 / (20 * seconds);
				if (ticks > delay * 10) {
					ticks = 0;

					for (int itemstacks = 0; itemstacks < inv.getSize(); itemstacks++)
						inv.setItem(itemstacks,
								contents[(itemstacks + itemIndex)
								         % contents.length]);

					itemIndex++;
					player.playSound(player.getLocation(), Sound.NOTE_STICKS, 1, 1);

					if (delay >= 1) {
						done = true;
						player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
						new BukkitRunnable() {

							@Override
							public void run() {
								ItemStack finalLoot = contents[(4 + itemIndex - 1) % contents.length];
								OITB.getInstance().getOitbPlayers().get(player).getInventory().add(OitbItem.findByName(finalLoot.getItemMeta().getDisplayName()));
								player.sendMessage("§8[§b!§8] §b» §7Tu as gagné " + OitbItem.findByName(finalLoot.getItemMeta().getDisplayName()).getName().replace("_", " ") + " §7!");
								player.closeInventory();
								cancel();
							}
						}.runTaskLater(plugin, 50);
						cancel();
					}
				}
			}
		}.runTaskTimer(plugin, 0, 1);
	}
}

class InventoryClickHandler implements Listener {
	private String name = null;

	public InventoryClickHandler(Plugin plugin, String inventoryName) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
		this.name = inventoryName;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getInventory().getTitle().equals(name)) {
			e.setCancelled(true);
		}
	}

	public void changeName(String name) {
		this.name = name;
	}
}