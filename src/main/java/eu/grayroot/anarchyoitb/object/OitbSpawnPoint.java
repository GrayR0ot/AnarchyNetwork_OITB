package eu.grayroot.anarchyoitb.object;

public class OitbSpawnPoint {
	
	int arena;
	String world;
	double posX;
	double posY;
	double posZ;
	float yaw;
	float pitch;
	public OitbSpawnPoint(int arena, String world, double posX, double posY, double posZ, float yaw, float pitch) {
		super();
		this.arena = arena;
		this.world = world;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	public int getArena() {
		return arena;
	}
	public void setArena(int arena) {
		this.arena = arena;
	}
	public String getWorld() {
		return world;
	}
	public void setWorld(String world) {
		this.world = world;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public double getPosZ() {
		return posZ;
	}
	public void setPosZ(double posZ) {
		this.posZ = posZ;
	}
	public float getYaw() {
		return yaw;
	}
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}
	public float getPitch() {
		return pitch;
	}
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

}
