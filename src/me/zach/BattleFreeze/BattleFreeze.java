package me.zach.BattleFreeze;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BattleFreeze extends JavaPlugin implements Listener{

	int duration = getConfig().getInt("duration");
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	@Override
	public void onDisable(){
		getLogger().info("BYE BYE!");
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if(!(event instanceof EntityDamageByEntityEvent)) {
			EntityDamageByEntityEvent edbeEvent = (EntityDamageByEntityEvent)event;
			if ((edbeEvent.getDamager() instanceof Snowball)) {
				LivingEntity entity = (LivingEntity) event.getEntity();
				entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, duration), true);
				
			}
		}
	}

}
