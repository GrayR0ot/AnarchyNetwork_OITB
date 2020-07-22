package eu.grayroot.anarchyoitb.sql;

import eu.grayroot.anarchyoitb.OITB;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerData {

    private Connection connection;

    public PlayerData(Connection connection) {
        this.connection = OITB.getInstance().getConnection();
    }

    public void registerPlayer(Player player){
        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players` (pseudo, uuid) VALUES (?, ?)");
            rs.setString(1, player.getName());
            rs.setString(2, player.getUniqueId().toString());
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players_items` (item_id, player_id, slot) VALUES (?, ?, ?)");
            rs.setInt(1, 1);
            rs.setInt(2, getPlayerId(player));
            rs.setInt(3, 1);
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players_items` (item_id, player_id, slot) VALUES (?, ?, ?)");
            rs.setInt(1, 2);
            rs.setInt(2, getPlayerId(player));
            rs.setInt(3, 2);
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players_items` (item_id, player_id, slot) VALUES (?, ?, ?)");
            rs.setInt(1, 3);
            rs.setInt(2, getPlayerId(player));
            rs.setInt(3, 3);
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players_items` (item_id, player_id, slot) VALUES (?, ?, ?)");
            rs.setInt(1, 4);
            rs.setInt(2, getPlayerId(player));
            rs.setInt(3, 4);
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement rs = connection.prepareStatement("INSERT INTO `oitb_players_items` (item_id, player_id, slot) VALUES (?, ?, ?)");
            rs.setInt(1, 17);
            rs.setInt(2, getPlayerId(player));
            rs.setInt(3, 5);
            rs.executeUpdate();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isRegistered(Player player) {
        try {
            PreparedStatement q = connection.prepareStatement("SELECT `pseudo` FROM `oitb_players` WHERE `pseudo` = ?");
            q.setString(1, player.getName());
            ResultSet resultat = q.executeQuery();
            boolean isRegistered = resultat.next();
            q.close();
            return isRegistered;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    public int getPlayerId(Player player) {
        int playerID = 0;
        try {
            PreparedStatement q = connection.prepareStatement("SELECT * FROM `oitb_players` WHERE `pseudo` = ?");
            q.setString(1, player.getName());
            ResultSet rs = q.executeQuery();
            while(rs.next()) {
                playerID = rs.getInt("id");
            }
            q.close();
            return playerID;

        } catch (SQLException e) {
            e.printStackTrace();
            return playerID;
        }
    }

}
