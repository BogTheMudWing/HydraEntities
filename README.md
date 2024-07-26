# HydraEntities
A simple Minecraft Spigot plugin that spawns two entities when you kill one.

All entities will spawn another upon death, but certain conditions will spawn two. This is to prevent situations where entities infinitely duplicate because of entity cramming, lava damage, or other similar causes.

Entities will spawn double on death if killed by:
- Dragon Breath
- Drowning
- Entity Attack
- Entity Explosion
- Entity Sweep Attack
- Fall
- Falling Block
- Lightning
- Magic
- Melting
- Poison
- Projectile
- Sonic Boom
- Thorns

The only cause that will not spawn *any* entities is via the `/kill` command.