package eu.grayroot.anarchyoitb;

import eu.grayroot.anarchyoitb.armorevent.ArmorListener;
import eu.grayroot.anarchyoitb.command.SpawnCommand;
import eu.grayroot.anarchyoitb.listener.PlayerListener;
import eu.grayroot.anarchyoitb.listener.PvpListener;
import eu.grayroot.anarchyoitb.listener.ServerListener;
import eu.grayroot.anarchyoitb.listener.gui.*;
import eu.grayroot.anarchyoitb.object.OitbArena;
import eu.grayroot.anarchyoitb.object.OitbItem;
import eu.grayroot.anarchyoitb.object.OitbPlayer;
import eu.grayroot.anarchyoitb.sql.OitbData;
import eu.grayroot.anarchyoitb.sql.SqlConnection;
import eu.grayroot.anarchyoitb.utils.PlayerUtils;
import eu.grayroot.anarchyoitb.utils.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OITB extends JavaPlugin {

    private static SqlConnection sql;
    private static Connection sqlConnection;
    private static OITB instance;
    private static Location spawn;
    private static HashMap<Player, OitbPlayer> players;
    private static List<OitbArena> arenas;
    private static HashMap<Player, OitbArena> playerArena;
    private static List<OitbItem> items;
    private static HashMap<Player, ScoreboardSign> scoreboards;

    @Override
    public void onEnable() {
        sql = new SqlConnection("jdbc:mysql://", "127.0.0.1", 3306, "dbName", "dbUser", "dbPassword");
        try {
            sql.connect();
            log("Successfully connected to SQL Database!");
        } catch (SQLException | ClassNotFoundException e) {
            log("Unable to connect to Database! Closing the server");
            getServer().shutdown();
            e.printStackTrace();
        }
        sqlConnection = sql.getConnection();
        setup();
    }

    @Override
    public void onDisable() {
        for(Player players : Bukkit.getOnlinePlayers()) {
            OitbPlayer oitbPlayer = getOitbPlayers().get(players);
            new OitbData(getConnection()).savePlayer(players);
            new OitbData(getConnection()).purgePlayerInventory(players);
            new OitbData(getConnection()).savePlayerEquipment(players, oitbPlayer.getHelmet(), 1);
            new OitbData(getConnection()).savePlayerEquipment(players, oitbPlayer.getChestplate(), 2);
            new OitbData(getConnection()).savePlayerEquipment(players, oitbPlayer.getLeggings(), 3);
            new OitbData(getConnection()).savePlayerEquipment(players, oitbPlayer.getBoots(), 4);
            new OitbData(getConnection()).savePlayerEquipment(players, oitbPlayer.getAxe(), 5);
            new OitbData(getConnection()).savePlayerInventory(players);
        }
        arenas.clear();
        players.clear();
        playerArena.clear();
        items.clear();
        scoreboards.clear();
        sql.disconnect();
    }

    private void setup() {
        instance = this;
        spawn = new Location(Bukkit.getWorld("world"), 14.5, 85, -9.5, 0, 0);
        arenas = new ArrayList<>();
        playerArena = new HashMap<>();
        items = new ArrayList<>();
        players = new HashMap<>();
        scoreboards = new HashMap<>();
        new OitbData(getConnection()).loadArenas();
        new OitbData(getConnection()).loadItems();
        registerEvents();
        registerCommands();
        for(Player players : Bukkit.getOnlinePlayers()) {
            OITB.getInstance().getOitbPlayers().put(players, new OitbData(getConnection()).loadPlayer(players));
            new PlayerUtils().loadLobby(players);
        }
        lockTime();
    }

    public static void lockTime() {
        Bukkit.getScheduler().runTaskTimer(instance, new Runnable(){
            @Override
            public void run() {
                for(World world : Bukkit.getWorlds()) {
                    world.setTime(11000L);
                    world.setThundering(false);
                }
            }

        }, 10, 10);
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new ServerListener(), this);
        pm.registerEvents(new SpawnItemsGuiListener(), this);
        pm.registerEvents(new ArenaGuiListener(), this);
        pm.registerEvents(new InventoryGuiListener(), this);
        pm.registerEvents(new EquipmentGuiListener(), this);
        pm.registerEvents(new EditEquipmentGuiListener(), this);
        pm.registerEvents(new PlayerChestGuiListener(), this);
        pm.registerEvents(new CratesGuiListener(), this);
        pm.registerEvents(new ShopGuiListener(), this);
        pm.registerEvents(new PlayerSpectateGuiListener(), this);
        pm.registerEvents(new PvpListener(), this);
        pm.registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
    }
    private void registerCommands() {
        getCommand("spawn").setExecutor(new SpawnCommand());
    }

    public static OITB getInstance() {
        return instance;
    }
    public void log(String log) {
        getLogger().info(log);
    }
    public Location getSpawn() {
        return spawn;
    }
    public SqlConnection getSql() {
        return sql;
    }
    public Connection getConnection() {
        return sqlConnection;
    }
    public List<OitbArena> getOitbArenas() {
        return arenas;
    }
    public HashMap<Player, OitbArena> getPlayerArena() {
        return playerArena;
    }
    public List<OitbItem> getOitbItems() {
        return items;
    }
    public HashMap<Player, OitbPlayer> getOitbPlayers() {
        return players;
    }
    public HashMap<Player, ScoreboardSign> getScoreboards() {
        return scoreboards;
    }
}
