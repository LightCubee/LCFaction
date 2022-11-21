package fr.lightcubee.faction;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import org.apache.commons.lang3.tuple.Pair;

@Mod("lcfaction")
public class LCFaction {

    private MinecraftServer minecraftServer;

    public LCFaction() {
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () ->
                Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (key, value) -> true));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    private void onServerStart(final FMLServerStartedEvent event) {
        this.minecraftServer = event.getServer();
    }

    public MinecraftServer getMinecraftServer() {
        return this.minecraftServer;
    }

}