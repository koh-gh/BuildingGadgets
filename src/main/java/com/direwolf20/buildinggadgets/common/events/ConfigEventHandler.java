package com.direwolf20.buildinggadgets.common.events;

import com.direwolf20.buildinggadgets.common.BuildingGadgets;
import com.direwolf20.buildinggadgets.common.config.SyncedConfig;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

@EventBusSubscriber(modid = BuildingGadgets.MODID)
public final class ConfigEventHandler {
    @SubscribeEvent
    public static void onPlayerLogin(PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP) {
            BuildingGadgets.logger.info("Sending SyncedConfig to freshly logged in player {}.",event.player.getName());
            SyncedConfig.sendConfigUpdateTo((EntityPlayerMP) event.player);
        }
    }

    @SubscribeEvent
    public static void onConfigurationChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(BuildingGadgets.MODID)) {
            BuildingGadgets.logger.info("Configuration changed. Syncing config File.");
//            TODO: Reimplement
//            ConfigManager.sync(BuildingGadgets.MODID, Type.INSTANCE);
//            PacketHandler.INSTANCE.sendToServer(new PacketRequestConfigSync());
        }
    }
}
