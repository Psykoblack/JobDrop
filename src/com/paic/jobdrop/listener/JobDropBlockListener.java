package com.paic.jobdrop.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import ru.tehkode.permissions.PermissionManager;

import com.nijiko.permissions.PermissionHandler;

public class JobDropBlockListener extends BlockListener {

	private static PermissionHandler perm;
	private PermissionManager permEx;

	public JobDropBlockListener(PermissionHandler perm) {
		this.perm = perm;
	}

	public JobDropBlockListener(PermissionManager permEx) {
		this.permEx = permEx;
	}

	public void onBlockBreak(BlockBreakEvent event) {

		int on10 = 0 + (int) (Math.random() * ((10 - 0) + 1));
		int on7 = 0 + (int) (Math.random() * ((7 - 0) + 1));
		int on5 = 0 + (int) (Math.random() * ((5 - 0) + 1));
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();
		Material inhand = event.getPlayer().getItemInHand().getType();
		World world = event.getPlayer().getWorld();
		Location loc = event.getBlock().getLocation();

		if (perm != null) {

			// Bucherons

			if (perm.has(player, "jobdrop.lumberjack")) {

				if (block == Material.LOG) {

					if (inhand == Material.IRON_AXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.LOG, 1));
					} else if (inhand == Material.GOLD_AXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.LOG, 1));
					} else if (inhand == Material.DIAMOND_AXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.LOG, 1));
					}
				} else if (block == Material.WOOD) {

					if (inhand == Material.IRON_AXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.WOOD, 1));
					} else if (inhand == Material.GOLD_AXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.WOOD, 1));
					} else if (inhand == Material.DIAMOND_AXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.WOOD, 1));
					}
				} else if (block == Material.LEAVES) {

					if (inhand == Material.SHEARS && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.LEAVES, 1));
					}
				}

			}

			// Mineurs

			if (perm.has(player, "jobdrop.miner")) {

				if (block == Material.STONE || block == Material.COBBLESTONE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.COBBLESTONE,
								1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.COBBLESTONE,
								1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.COBBLESTONE,
								1));
					}
				} else if (block == Material.COAL_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.COAL, 1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.COAL, 1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.COAL, 1));
					}
				} else if (block == Material.IRON_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.IRON_INGOT,
								1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.IRON_INGOT,
								1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.IRON_INGOT,
								1));
					}
				} else if (block == Material.GOLD_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.GOLD_INGOT,
								1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.GOLD_INGOT,
								1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.GOLD_INGOT,
								1));
					}
				} else if (block == Material.DIAMOND_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.DIAMOND, 1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.DIAMOND, 1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.DIAMOND, 1));
					}
				} else if (block == Material.REDSTONE_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.REDSTONE, 5));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.REDSTONE, 5));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.REDSTONE, 5));
					}
				} else if (block == Material.LAPIS_ORE) {

					short damageLapis = 4;
					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.INK_SACK, 1,
								damageLapis));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.INK_SACK, 1,
								damageLapis));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.INK_SACK, 1,
								damageLapis));
					}
				} else if (block == Material.OBSIDIAN) {

					if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.OBSIDIAN, 1));
					}
				}

			}

			// Paysan

			if (perm.has(player, "jobdrop.farmer")) {

				if (block == Material.MELON_BLOCK) {

					if (inhand == Material.IRON_HOE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.MELON, 5));
					} else if (inhand == Material.GOLD_HOE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.MELON, 5));
					} else if (inhand == Material.DIAMOND_HOE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.MELON, 5));
					}
				} else if (block == Material.CROPS
						&& event.getBlock().getData() == 7) {

					if (inhand == Material.IRON_HOE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.WHEAT, 1));
					} else if (inhand == Material.GOLD_HOE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.WHEAT, 1));
					} else if (inhand == Material.DIAMOND_HOE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.WHEAT, 1));
					}
				}
			}
		} else {

			// Bucherons

			if (permEx.has(player, "jobdrop.lumberjack")) {

				if (block == Material.LOG) {

					if (inhand == Material.IRON_AXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.LOG, 1));
					} else if (inhand == Material.GOLD_AXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.LOG, 1));
					} else if (inhand == Material.DIAMOND_AXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.LOG, 1));
					}
				} else if (block == Material.WOOD) {

					if (inhand == Material.IRON_AXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.WOOD, 1));
					} else if (inhand == Material.GOLD_AXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.WOOD, 1));
					} else if (inhand == Material.DIAMOND_AXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.WOOD, 1));
					}
				} else if (block == Material.LEAVES) {

					if (inhand == Material.SHEARS && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.LEAVES, 1));
					}
				}

			}

			// Mineurs

			if (permEx.has(player, "jobdrop.miner")) {

				if (block == Material.STONE || block == Material.COBBLESTONE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.COBBLESTONE,
								1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.COBBLESTONE,
								1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.COBBLESTONE,
								1));
					}
				} else if (block == Material.COAL_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.COAL, 1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.COAL, 1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.COAL, 1));
					}
				} else if (block == Material.IRON_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.IRON_INGOT,
								1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.IRON_INGOT,
								1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.IRON_INGOT,
								1));
					}
				} else if (block == Material.GOLD_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.GOLD_INGOT,
								1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.GOLD_INGOT,
								1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.GOLD_INGOT,
								1));
					}
				} else if (block == Material.DIAMOND_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.DIAMOND, 1));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.DIAMOND, 1));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.DIAMOND, 1));
					}
				} else if (block == Material.REDSTONE_ORE) {

					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.REDSTONE, 5));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.REDSTONE, 5));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.REDSTONE, 5));
					}
				} else if (block == Material.LAPIS_ORE) {

					short damageLapis = 4;
					if (inhand == Material.IRON_PICKAXE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.INK_SACK, 1,
								damageLapis));
					} else if (inhand == Material.GOLD_PICKAXE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.INK_SACK, 1,
								damageLapis));
					} else if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.INK_SACK, 1,
								damageLapis));
					}
				} else if (block == Material.OBSIDIAN) {

					if (inhand == Material.DIAMOND_PICKAXE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.OBSIDIAN, 1));
					}
				}

			}

			// Paysan

			if (permEx.has(player, "jobdrop.farmer")) {

				if (block == Material.MELON_BLOCK) {

					if (inhand == Material.IRON_HOE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.MELON, 5));
					} else if (inhand == Material.GOLD_HOE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.MELON, 5));
					} else if (inhand == Material.DIAMOND_HOE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.MELON, 5));
					}
				} else if (block == Material.CROPS
						&& event.getBlock().getData() == 7) {

					if (inhand == Material.IRON_HOE && on10 == 0) {
						world.dropItem(loc, new ItemStack(Material.WHEAT, 1));
					} else if (inhand == Material.GOLD_HOE && on7 == 0) {
						world.dropItem(loc, new ItemStack(Material.WHEAT, 1));
					} else if (inhand == Material.DIAMOND_HOE && on5 == 0) {
						world.dropItem(loc, new ItemStack(Material.WHEAT, 1));
					}
				}
			}
		}
	}

	public void onBlockPlace(BlockPlaceEvent event) {
	}
}
