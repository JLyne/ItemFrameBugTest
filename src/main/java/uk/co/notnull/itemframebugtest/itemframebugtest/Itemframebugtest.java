package uk.co.notnull.itemframebugtest.itemframebugtest;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ItemFrame;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Itemframebugtest extends JavaPlugin {
	private final List<ItemFrame> itemFrames = new ArrayList<>();
	private World world;

	@Override
	public void onEnable() {
		world = getServer().getWorld("hub");

		//Dirt floor
		world.getBlockAt(new Location(world, 0, 4, 0)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, -1, 4, 0)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, 0, 4, -1)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, -1, 4, -1)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, 1, 4, 0)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, 0, 4, 1)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, 1, 4, 1)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, -1, 4, 1)).setType(Material.DIRT);
		world.getBlockAt(new Location(world, 1, 4, -1)).setType(Material.DIRT);

		//Obsidian wall
		world.getBlockAt(new Location(world, 0, 5, 0)).setType(Material.OBSIDIAN);
		world.getBlockAt(new Location(world, 0,  6, 0)).setType(Material.OBSIDIAN);

		//Item frames on each side
		itemFrames.add(spawnItemFrame(new Location(world, 0, 6, -1)));
		itemFrames.add(spawnItemFrame(new Location(world, -1, 6, 0)));
		itemFrames.add(spawnItemFrame(new Location(world, 0, 6, 1)));
		itemFrames.add(spawnItemFrame(new Location(world, 1, 6, 0)));
	}

	@Override
	public void onDisable() {
		itemFrames.forEach(ItemFrame::remove);

		//Cleanup dirt
		world.getBlockAt(new Location(world, 0, 4, 0)).setType(Material.AIR);
		world.getBlockAt(new Location(world, -1, 4, 0)).setType(Material.AIR);
		world.getBlockAt(new Location(world, 0, 4, -1)).setType(Material.AIR);
		world.getBlockAt(new Location(world, -1, 4, -1)).setType(Material.AIR);
		world.getBlockAt(new Location(world, 1, 4, 0)).setType(Material.AIR);
		world.getBlockAt(new Location(world, 0, 4, 1)).setType(Material.AIR);
		world.getBlockAt(new Location(world, 1, 4, 1)).setType(Material.AIR);
		world.getBlockAt(new Location(world, -1, 4, 1)).setType(Material.AIR);
		world.getBlockAt(new Location(world, 1, 4, -1)).setType(Material.AIR);

		//Cleanup obsidian
		world.getBlockAt(new Location(world, 0, -60, 0)).setType(Material.AIR);
		world.getBlockAt(new Location(world, 0, -59, 0)).setType(Material.AIR);
	}

	private ItemFrame spawnItemFrame(Location location) {
		World world = location.getWorld();
		ItemFrame frame = world.spawn(location, ItemFrame.class);

		frame.setFacingDirection(BlockFace.UP, true);

		return frame;
	}
}
