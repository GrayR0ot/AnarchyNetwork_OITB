package eu.grayroot.anarchyoitb.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class  ServerListener implements Listener {

	@EventHandler
	public void monsterSpawn(EntitySpawnEvent e) {
		Entity entity = e.getEntity();
		if(entity.getType() != EntityType.PLAYER || entity.getType() != EntityType.ARROW) {
			e.setCancelled(true);
		}

	}
}