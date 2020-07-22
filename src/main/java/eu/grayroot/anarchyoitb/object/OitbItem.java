package eu.grayroot.anarchyoitb.object;

import eu.grayroot.anarchyoitb.OITB;
import org.bukkit.Material;


public class OitbItem {
	
	int id;
	Material material;
	int amount;
	int power;
	String name;
	int rarity;
	int price;
	int protectionLevel;
	int sharpnessLevel;
	public OitbItem(int id, Material material, int amount, int power, String name, int rarity, int price, int protectionLevel,
			int sharpnessLevel) {
		super();
		this.id = id;
		this.material = material;
		this.amount = amount;
		this.power = power;
		this.name = name;
		this.rarity = rarity;
		this.price = price;
		this.protectionLevel = protectionLevel;
		this.sharpnessLevel = sharpnessLevel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRarity() {
		return rarity;
	}
	public void setRarity(int rarity) {
		this.rarity = rarity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProtectionLevel() {
		return protectionLevel;
	}
	public void setProtectionLevel(int protectionLevel) {
		this.protectionLevel = protectionLevel;
	}
	public int getSharpnessLevel() {
		return sharpnessLevel;
	}
	public void setSharpnessLevel(int sharpnessLevel) {
		this.sharpnessLevel = sharpnessLevel;
	}
	
	public static OitbItem findById(int id) {
		for(OitbItem oitbItem : OITB.getInstance().getOitbItems()) {
			if(oitbItem.getId() == id) {
				return oitbItem;
			}
		}
		return null;
	}
	
	public static OitbItem findByName(String name) {
		for(OitbItem oitbItem : OITB.getInstance().getOitbItems()) {
			if(oitbItem.getName().equalsIgnoreCase(name.replaceAll(" ", "_"))) {
				return oitbItem;
			}
		}
		return null;
	}
	
}
