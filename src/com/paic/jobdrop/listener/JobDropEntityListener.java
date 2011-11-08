package com.paic.jobdrop.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.inventory.ItemStack;

import ru.tehkode.permissions.PermissionManager;

import com.nijiko.permissions.PermissionHandler;

public class JobDropEntityListener extends EntityListener {

	private static PermissionHandler perm;
	private PermissionManager permEx;

	public JobDropEntityListener(PermissionHandler perm) {
		this.perm = perm;
	}

	public JobDropEntityListener(PermissionManager permEx) {
		this.permEx = permEx;
	}

	public void onEntityDeath(EntityDeathEvent event) {

		Entity target = event.getEntity();

		if (target instanceof LivingEntity) {
			LivingEntity attaquer = (LivingEntity) target;
			EntityDamageEvent ede = attaquer.getLastDamageCause();
			if (ede instanceof EntityDamageByEntityEvent) {

				EntityDamageByEntityEvent edbee = (EntityDamageByEntityEvent) ede;
				Entity attaquant = edbee.getDamager();

				if (attaquant instanceof Player) {

					Player attacker = (Player) attaquant;

					if (perm != null) {
						if (perm.has(attacker, "jobdrop.hunter")) {

							World world = attaquant.getWorld();
							Location loc = target.getLocation();
							int on7 = 0 + (int) (Math.random() * ((7 - 0) + 1));

							if (target instanceof Creeper && on7 == 0) {

								Creeper creep = (Creeper) target;
								world.dropItem(loc, new ItemStack(
										Material.SULPHUR, 1));

							} else if (target instanceof Zombie && on7 == 0) {

								Zombie zomb = (Zombie) target;
								world.dropItem(loc, new ItemStack(
										Material.ROTTEN_FLESH, 1));

							} else if (target instanceof Spider
									|| target instanceof CaveSpider && on7 == 0) {

								Spider spid = (Spider) target;
								world.dropItem(loc, new ItemStack(
										Material.STRING, 1));

							} else if (target instanceof PigZombie && on7 == 0) {

								PigZombie pigzomb = (PigZombie) target;
								world.dropItem(loc, new ItemStack(
										Material.PORK, 1));

							} else if (target instanceof Skeleton && on7 == 0) {

								Skeleton skel = (Skeleton) target;
								world.dropItem(loc, new ItemStack(
										Material.ARROW, 1));

							} else if (target instanceof Enderman && on7 == 0) {

								Enderman ender = (Enderman) target;
								world.dropItem(loc, new ItemStack(
										Material.ENDER_PEARL, 1));

							}

						}
					} else {
						
						if (permEx.has(attacker, "jobdrop.hunter")) {

							World world = attaquant.getWorld();
							Location loc = target.getLocation();
							int on7 = 0 + (int) (Math.random() * ((7 - 0) + 1));

							if (target instanceof Creeper && on7 == 0) {

								Creeper creep = (Creeper) target;
								world.dropItem(loc, new ItemStack(
										Material.SULPHUR, 1));

							} else if (target instanceof Zombie && on7 == 0) {

								Zombie zomb = (Zombie) target;
								world.dropItem(loc, new ItemStack(
										Material.ROTTEN_FLESH, 1));

							} else if (target instanceof Spider
									|| target instanceof CaveSpider && on7 == 0) {

								Spider spid = (Spider) target;
								world.dropItem(loc, new ItemStack(
										Material.STRING, 1));

							} else if (target instanceof PigZombie && on7 == 0) {

								PigZombie pigzomb = (PigZombie) target;
								world.dropItem(loc, new ItemStack(
										Material.PORK, 1));

							} else if (target instanceof Skeleton && on7 == 0) {

								Skeleton skel = (Skeleton) target;
								world.dropItem(loc, new ItemStack(
										Material.ARROW, 1));

							} else if (target instanceof Enderman && on7 == 0) {

								Enderman ender = (Enderman) target;
								world.dropItem(loc, new ItemStack(
										Material.ENDER_PEARL, 1));

							}

						}
					}
				}
			}
		}
	}

}
