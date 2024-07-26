package io.github.stonley890.hydraentities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public final class HydraEntities extends JavaPlugin implements Listener {

    public static final List<EntityDamageEvent.DamageCause> doubleCauses = List.of(
            EntityDamageEvent.DamageCause.DRAGON_BREATH,
            EntityDamageEvent.DamageCause.DROWNING,
            EntityDamageEvent.DamageCause.ENTITY_ATTACK,
            EntityDamageEvent.DamageCause.ENTITY_EXPLOSION,
            EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK,
            EntityDamageEvent.DamageCause.FALL,
            EntityDamageEvent.DamageCause.FALLING_BLOCK,
            EntityDamageEvent.DamageCause.LIGHTNING,
            EntityDamageEvent.DamageCause.MAGIC,
            EntityDamageEvent.DamageCause.MELTING,
            EntityDamageEvent.DamageCause.POISON,
            EntityDamageEvent.DamageCause.PROJECTILE,
            EntityDamageEvent.DamageCause.SONIC_BOOM,
            EntityDamageEvent.DamageCause.THORNS
    );

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onEntityDeath(@NotNull EntityDeathEvent event) {
        Location location = event.getEntity().getLocation();
        Class<? extends Entity> entityClass = event.getEntityType().getEntityClass();
        if (entityClass == Player.class) return;
        if (Objects.requireNonNull(event.getEntity().getLastDamageCause()).getCause() == EntityDamageEvent.DamageCause.KILL) return;
        location.getWorld().spawn(location, Objects.requireNonNull(entityClass));
        if (doubleCauses.contains(Objects.requireNonNull(event.getEntity().getLastDamageCause()).getCause())) location.getWorld().spawn(location, Objects.requireNonNull(entityClass));
    }
}
