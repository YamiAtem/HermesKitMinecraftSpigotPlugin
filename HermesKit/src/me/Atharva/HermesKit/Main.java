package me.Atharva.HermesKit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.addRecipe(HermesKitAct());
	}

	@Override
	public void onDisable() {

	}
	
	public ShapedRecipe HermesKitAct() {

		ItemStack item = new ItemStack(Material.IRON_BLOCK);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "HERMES KIT");
		meta.addEnchant(Enchantment.DURABILITY, 1, true);

		item.setItemMeta(meta);

		NamespacedKey key = new NamespacedKey(this, "herems_kit");

		ShapedRecipe recipe = new ShapedRecipe(key, item);

		recipe.shape("   ", "IBI", " I ");

		recipe.setIngredient('B', Material.NETHERITE_BLOCK);
		recipe.setIngredient('I', Material.NETHERITE_INGOT);

		return recipe;
	}
	
	@EventHandler
	public void onClicked(PlayerInteractEvent event) {
		if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.IRON_BLOCK)) {
			if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasDisplayName()) {
				Player player = (Player) event.getPlayer();

				if (event.getAction() == Action.RIGHT_CLICK_AIR) {
					this.dropChest(player, HermesKit());
					player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
				}
			}
		}
	}
	
	private void dropChest(Player player, ItemStack[] items) {
		Location chest = null;
		if (player.getFacing() == BlockFace.NORTH)
			chest = player.getLocation().add(0, 0, -1);

		if (player.getFacing() == BlockFace.SOUTH)
			chest = player.getLocation().add(0, 0, 1);

		if (player.getFacing() == BlockFace.EAST)
			chest = player.getLocation().add(1, 0, 0);

		if (player.getFacing() == BlockFace.WEST)
			chest = player.getLocation().add(-1, 0, 0);

		if (chest.getBlock().getType() != Material.AIR) {
			player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "CANNOT PLACE CHEST HERE");
			return;
		}

		Block block = chest.getBlock();
		block.setType(Material.CHEST);

		Chest c = (Chest) block.getState();
		c.getInventory().addItem(items);
	}
	
	private ItemStack[] HermesKit() {
		ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "HERMES HELMET");
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
		meta.addEnchant(Enchantment.PROTECTION_FIRE, 7, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
		meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 7, true);
		meta.addEnchant(Enchantment.DURABILITY, 7, true);
		meta.addEnchant(Enchantment.WATER_WORKER, 7, true);
		meta.addEnchant(Enchantment.OXYGEN, 7, true);

		item.setItemMeta(meta);

		ItemStack item2 = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta2 = item.getItemMeta();

		meta2.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "HERMES CHESTPLATE");
		meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
		meta2.addEnchant(Enchantment.PROTECTION_FIRE, 7, true);
		meta2.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
		meta2.addEnchant(Enchantment.PROTECTION_PROJECTILE, 7, true);
		meta2.addEnchant(Enchantment.THORNS, 7, true);
		meta2.addEnchant(Enchantment.DURABILITY, 7, true);

		item2.setItemMeta(meta2);

		ItemStack item3 = new ItemStack(Material.NETHERITE_LEGGINGS);
		ItemMeta meta3 = item.getItemMeta();

		meta3.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "HERMES LEGGINGS");
		meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
		meta3.addEnchant(Enchantment.PROTECTION_FIRE, 7, true);
		meta3.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
		meta3.addEnchant(Enchantment.PROTECTION_PROJECTILE, 7, true);
		meta3.addEnchant(Enchantment.THORNS, 7, true);
		meta3.addEnchant(Enchantment.DURABILITY, 7, true);

		item3.setItemMeta(meta3);

		ItemStack item4 = new ItemStack(Material.NETHERITE_BOOTS);
		ItemMeta meta4 = item.getItemMeta();

		meta4.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "HERMES BOOTS");
		meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
		meta4.addEnchant(Enchantment.PROTECTION_FIRE, 7, true);
		meta4.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 7, true);
		meta4.addEnchant(Enchantment.PROTECTION_PROJECTILE, 7, true);
		meta4.addEnchant(Enchantment.DURABILITY, 7, true);
		meta4.addEnchant(Enchantment.DEPTH_STRIDER, 7, true);
		meta4.addEnchant(Enchantment.PROTECTION_FALL, 7, true);

		item4.setItemMeta(meta4);

		ItemStack[] items = { item, item2, item3, item4 };
		return items;
	}
}
