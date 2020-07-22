package eu.grayroot.anarchyoitb.object;

public enum ArenaType {
	
	DEFAULT("Simple"),
	ONLY_BOW("Arc Seulement"),
	ONLY_AXE("Hache Seulement");
	
	private String name;

	private ArenaType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
