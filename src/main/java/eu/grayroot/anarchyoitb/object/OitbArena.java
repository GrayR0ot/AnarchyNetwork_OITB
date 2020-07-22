package eu.grayroot.anarchyoitb.object;

import java.util.List;

public class OitbArena {
	
	String name;
	ArenaType type;
	int status;
	List<OitbSpawnPoint> spawns;
	int players;
	int maxPlayers;
	int maxPower;
	public OitbArena(String name, ArenaType type, int status, List<OitbSpawnPoint> spawns, int players, int maxPlayers, int maxPower) {
		super();
		this.name = name;
		this.type = type;
		this.status = status;
		this.spawns = spawns;
		this.players = players;
		this.maxPlayers = maxPlayers;
		this.maxPower = maxPower;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArenaType getType() {
		return type;
	}
	public void setType(ArenaType type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<OitbSpawnPoint> getSpawns() {
		return spawns;
	}
	public void setSpawns(List<OitbSpawnPoint> spawns) {
		this.spawns = spawns;
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public int getMaxPower() {
		return maxPower;
	}
	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

}
