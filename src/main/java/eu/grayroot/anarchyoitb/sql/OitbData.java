package eu.grayroot.anarchyoitb.sql;

import eu.grayroot.anarchyoitb.OITB;
import eu.grayroot.anarchyoitb.object.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OitbData {

    private Connection connection;

    public OitbData(Connection connection) {
        this.connection = OITB.getInstance().getConnection();
    }

    public void loadItems() {
        try {
            PreparedStatement q = connection.prepareStatement("SELECT * FROM `oitb_items`");
            ResultSet rs = q.executeQuery();
            while(rs.next()) {
                @SuppressWarnings("deprecation")
                OitbItem current = new OitbItem(rs.getInt("id"), Material.getMaterial(rs.getInt("material_id")), rs.getInt("amount"), rs.getInt("power"), rs.getString("name"), rs.getInt("rarity"), rs.getInt("price"), rs.getInt("protection_level"), rs.getInt("sharpness_level"));
                OITB.getInstance().getOitbItems().add(current);
                System.out.println("[AnarchyOITB] New item found: " + rs.getString("name"));
            }

            q.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadArenas() {
        try {
            PreparedStatement q = connection.prepareStatement("SELECT * FROM `oitb_arenas`");
            ResultSet rs = q.executeQuery();
            while(rs.next()) {
                OitbArena current = new OitbArena(rs.getString("name"), ArenaType.valueOf(rs.getString("type")), rs.getInt("status"), getArenaSpawns(rs.getInt("id")), 0, rs.getInt("max_players"), rs.getInt("max_power"));
                OITB.getInstance().getOitbArenas().add(current);
                System.out.println("[AnarchyOITB] New arena found: " + rs.getString("name"));
            }

            q.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<OitbSpawnPoint> getArenaSpawns(int arenaId) {
        List<OitbSpawnPoint> spawnPoints = new ArrayList<OitbSpawnPoint>();
        try {
            PreparedStatement q = connection.prepareStatement("SELECT * FROM `oitb_spawnpoints` WHERE `linked_arena` = ?");
            q.setInt(1, arenaId);
            ResultSet rs = q.executeQuery();
            while(rs.next()){
                spawnPoints.add(new OitbSpawnPoint(rs.getInt("linked_arena"), rs.getString("world"), rs.getDouble("posX"), rs.getDouble("posY"), rs.getDouble("posZ"), rs.getFloat("yaw"), rs.getFloat("pitch")));
            }

            q.close();

            return spawnPoints;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return spawnPoints;
    }

    public OitbPlayer loadPlayer(Player player) {
        try {
            PreparedStatement q = connection.prepareStatement("SELECT * FROM `oitb_players` WHERE `pseudo` = ?");
            q.setString(1, player.getName());
            ResultSet rs = q.executeQuery();
            while(rs.next()) {
                OitbPlayer current = new OitbPlayer(rs.getInt("id"), player, rs.getInt("coins"), rs.getInt("kills"), rs.getInt("deaths"), rs.getInt("hits"), rs.getInt("bow-shots"), rs.getDouble("xp"), rs.getInt("rank"), getPlayerEquipment(player, 1), getPlayerEquipment(player, 2), getPlayerEquipment(player, 3), getPlayerEquipment(player, 4), getPlayerEquipment(player, 5), getPlayerInventory(player));
                return current;
            }
            q.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public OitbPlayer savePlayer(Player player) {
        OitbPlayer oitbPlayer = OITB.getInstance().getOitbPlayers().get(player);
        try {
            PreparedStatement rs = connection.prepareStatement("UPDATE `oitb_players` SET `coins`=?,`kills`=?,`deaths`=?,`hits`=?,`bow-shots`=?,`xp`=?,`rank`=? WHERE `pseudo` = ?");
            rs.setInt(1, oitbPlayer.getCoins());
            rs.setInt(2, oitbPlayer.getKills());
            rs.setInt(3, oitbPlayer.getDeaths());
            rs.setInt(4, oitbPlayer.getHits());
            rs.setInt(5, oitbPlayer.getBowShots());
            rs.setDouble(6, oitbPlayer.getXp());
            rs.setInt(7, oitbPlayer.getRank());
            rs.setString(8, player.getName());
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public List<OitbItem> getPlayerInventory(Player player) {
        List<OitbItem> playerInventory = new ArrayList<>();
        try {
            PreparedStatement q = connection.prepareStatement("SELECT * FROM `oitb_players_items` WHERE (`player_id` = ?) AND (`slot` = 0)");
            q.setInt(1, new PlayerData(OITB.getInstance().getConnection()).getPlayerId(player));
            ResultSet rs = q.executeQuery();
            while(rs.next()) {
                playerInventory.add(OitbItem.findById(rs.getInt("item_id")));
            }
            q.close();
            return playerInventory;

        } catch (SQLException e) {
            e.printStackTrace();
            return playerInventory;
        }
    }

    public void purgePlayerInventory(Player player) {
        try {
            PreparedStatement rs = connection.prepareStatement("DELETE FROM `oitb_players_items` WHERE `player_id` = ?");
            rs.setInt(1, new PlayerData(OITB.getInstance().getConnection()).getPlayerId(player));
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savePlayerInventory(Player player) {
        try {
            for(OitbItem oitbItem: OITB.getInstance().getOitbPlayers().get(player).getInventory()) {
                PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players_items` (`item_id`, `player_id`) VALUES (?,?)");
                rs.setInt(1, oitbItem.getId());
                rs.setInt(2, new PlayerData(OITB.getInstance().getConnection()).getPlayerId(player));
                rs.executeUpdate();
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public OitbItem getPlayerEquipment(Player player, int slot) {
        OitbItem item = null;
        try {
            PreparedStatement q = connection.prepareStatement("SELECT * FROM `oitb_players_items` WHERE (`player_id` = ?) AND (`slot` = ?)");
            q.setInt(1, new PlayerData(OITB.getInstance().getConnection()).getPlayerId(player));
            q.setInt(2, slot);
            ResultSet rs = q.executeQuery();
            while(rs.next()) {
                item = OitbItem.findById(rs.getInt("item_id"));
            }
            q.close();
            return item;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void savePlayerEquipment(Player player, OitbItem oitbItem, int slot) {
        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players_items` (`item_id`, `player_id`, `slot`) VALUES (?,?,?)");
            rs.setInt(1, oitbItem.getId());
            rs.setInt(2, new PlayerData(OITB.getInstance().getConnection()).getPlayerId(player));
            rs.setInt(3, slot);
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
