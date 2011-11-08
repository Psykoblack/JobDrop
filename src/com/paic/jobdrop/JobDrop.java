package com.paic.jobdrop;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import com.paic.jobdrop.listener.JobDropBlockListener;
import com.paic.jobdrop.listener.JobDropEntityListener;
import com.paic.jobdrop.listener.JobDropPlayerListener;

public class JobDrop extends JavaPlugin {

	private Logger log = Logger.getLogger("Minecraft");
	private JobDropBlockListener jdbl;
	private JobDropEntityListener jdel;
	private JobDropPlayerListener jdpl;
	private String version = "0.2";
	private static PermissionHandler perm;
	private PermissionManager permEx;

	public void onEnable() {

		log.info("[JobDrop] Plugin enabled");

		setupPermissions();

		if (perm != null) {
			jdbl = new JobDropBlockListener(perm);
			jdel = new JobDropEntityListener(perm);
			jdpl = new JobDropPlayerListener(perm);
		} else {
			jdbl = new JobDropBlockListener(permEx);
			jdel = new JobDropEntityListener(permEx);
			jdpl = new JobDropPlayerListener(permEx);
		}

		PluginManager pm = this.getServer().getPluginManager();

		pm.registerEvent(Event.Type.BLOCK_BREAK, jdbl, Priority.Normal, this);
		pm.registerEvent(Event.Type.ENTITY_DEATH, jdel, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_FISH, jdpl, Priority.Normal, this);
	}

	public void onDisable() {

		log.info("[JobDrop] Plugin disabled");
	}

	private boolean setupPermissions() {
		Plugin permissions = this.getServer().getPluginManager()
				.getPlugin("Permissions");

		Plugin permissionsEx = this.getServer().getPluginManager()
				.getPlugin("PermissionsEx");

		if (perm == null || permEx == null) {

			if (permissions != null) {
				this.perm = ((Permissions) permissions).getHandler();
				return true;

			} else if (permissionsEx != null) {
				permEx = PermissionsEx.getPermissionManager();
				return true;
			} else {
				log.info("[JobDrop] Permission system not detected");
				return false;
			}
		}
		return false;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Player player = null;

		if (sender instanceof Player) {

			player = (Player) sender;

		}

		if (perm != null) {

			if (cmd.getName().equalsIgnoreCase("jobdrop")
					&& perm.has(player, "jobdrop.version")) {
				player.sendMessage(ChatColor.AQUA + "JobDrop by Paic v"
						+ version);
				return true;
			}

		} else {

			if (cmd.getName().equalsIgnoreCase("jobdrop")
					&& permEx.has(player, "jobdrop.version")) {
				player.sendMessage(ChatColor.AQUA + "JobDrop by Paic v"
						+ version);
				return true;
			}
		}

		return false;
	}

}
