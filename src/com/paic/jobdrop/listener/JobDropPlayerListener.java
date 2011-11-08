package com.paic.jobdrop.listener;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

import ru.tehkode.permissions.PermissionManager;

import com.nijiko.permissions.PermissionHandler;

public class JobDropPlayerListener extends PlayerListener {

	private static PermissionHandler perm;
	private PermissionManager permEx;

	public JobDropPlayerListener(PermissionHandler perm) {
		this.perm = perm;
	}

	public JobDropPlayerListener(PermissionManager permEx) {
		this.permEx = permEx;
	}

	public void onPlayerFish(PlayerFishEvent event) {

		Player player = event.getPlayer();
		World world = event.getPlayer().getWorld();
		int on7 = 0 + (int) (Math.random() * ((7 - 0) + 1));

		if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)
				&& event.getCaught() instanceof Item) {

			if (perm != null) {

				if(perm.has(player, "jobdrop.fisherman")) {
				
					if(on7 == 0) {
						world.dropItem(event.getPlayer().getLocation(), new ItemStack(Material.RAW_FISH, 1));
					}
				}
				
			} else {

				if(permEx.has(player, "jobdrop.fisherman")) {
					
					if(on7 == 0) {
						world.dropItem(event.getPlayer().getLocation(), new ItemStack(Material.RAW_FISH, 1));
					}
				}
			}

		}
	}
}
