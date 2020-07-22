package eu.grayroot.anarchyoitb.object;

import java.util.List;

import org.bukkit.entity.Player;

public class OitbPlayer {
	
	int id;
	Player player;
	int coins;
	int kills;
	int deaths;
	int hits;
	int bowShots;
	double xp;
	int rank;
	OitbItem helmet;
	OitbItem chestplate;
	OitbItem leggings;
	OitbItem boots;
	OitbItem axe;
	List<OitbItem> inventory;
	public OitbPlayer(int id, Player player, int coins, int kills, int deaths, int hits, int bowShots, double xp, int rank,
			OitbItem helmet, OitbItem chestplate, OitbItem leggings, OitbItem boots, OitbItem axe, List<OitbItem> inventory) {
		super();
		this.id = id;
		this.player = player;
		this.coins = coins;
		this.kills = kills;
		this.deaths = deaths;
		this.hits = hits;
		this.bowShots = bowShots;
		this.xp = xp;
		this.rank = rank;
		this.helmet = helmet;
		this.chestplate = chestplate;
		this.leggings = leggings;
		this.boots = boots;
		this.axe = axe;
		this.inventory = inventory;
	}
	public int getId() {
		return id;
	}
	public void setPlayer(int id) {
		this.id = id;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	public int getKills() {
		return kills;
	}
	public void setKills(int kills) {
		this.kills = kills;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getBowShots() {
		return bowShots;
	}
	public void setBowShots(int bowShots) {
		this.bowShots = bowShots;
	}
	public double getXp() {
		return xp;
	}
	public void setXp(double xp) {
		this.xp = xp;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public OitbItem getHelmet() {
		return helmet;
	}
	public void setHelmet(OitbItem helmet) {
		this.helmet = helmet;
	}
	public OitbItem getChestplate() {
		return chestplate;
	}
	public void setChestplate(OitbItem chestplate) {
		this.chestplate = chestplate;
	}
	public OitbItem getLeggings() {
		return leggings;
	}
	public void setLeggings(OitbItem leggings) {
		this.leggings = leggings;
	}
	public OitbItem getBoots() {
		return boots;
	}
	public void setBoots(OitbItem boots) {
		this.boots = boots;
	}
	public OitbItem getAxe() {
		return axe;
	}
	public void setAxe(OitbItem axe) {
		this.axe = axe;
	}
	public List<OitbItem> getInventory() {
		return inventory;
	}
	public void setInventory(List<OitbItem> inventory) {
		this.inventory = inventory;
	}
	
}
