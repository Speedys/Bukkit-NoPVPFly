package me.Speedyspro.NoPVPFly;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

//	private static List<String> cooldown = new ArrayList<String>();

	@Override
	public void onEnable() {
		getLogger().info("[NoPVPFly] Enabled!");
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);

	}

	@Override
	public void onDisable() {
		getLogger().info("[NoPVPFly] Disabled");
	}

//	public static void addCooldown(final Player player, int sec,
//			final String incantesimo) {
//
//		cooldown.add(player.getName());
//		Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin(
//				"NoPVPFly"), new Runnable() {
//			@Override
//			public void run() {
//				if (cooldown.contains(player.getName())) {
//					cooldown.remove(player.getName());
//					player.sendMessage("§4§l[MNoPVPFly]§c Now you can fly§c.");
//				}
//			}
//		}, (10 * 20L));
//
//	}

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player player = (Player) e.getDamager();
			if (!player.isOp() && player.isFlying()) {
				e.setCancelled(true);
//				addCooldown(player);
			}
		}
	}
	
	@EventHandler
	public void onBowHit(EntityShootBowEvent e) {
		if (e.getEntity() instanceof Player) {
			Player player = (Player) e.getEntity();
			if (!player.isOp() && player.isFlying()) {
				e.setCancelled(true);
//				addCooldown(player);
			}
		}
		
	}

	@EventHandler
	public void onPotionSplash(PotionSplashEvent e) {
		if (e.getEntity().getShooter() instanceof Player) {
			Player player = (Player) e.getEntity().getShooter();
			if (!player.isOp() && player.isFlying()) {
				e.setCancelled(true);
//				addCooldown(player);
			}
		}
		
	}
}
