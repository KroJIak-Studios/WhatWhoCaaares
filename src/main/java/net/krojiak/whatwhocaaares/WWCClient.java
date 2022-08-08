package net.krojiak.whatwhocaaares;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.krojiak.whatwhocaaares.fluid.ModFluids;

public class WWCClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //Серная кислота
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SULPHURIC_ACID_STILL,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 55291));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SULPHURIC_ACID_FLOWING,
                new SimpleFluidRenderHandler(SimpleFluidRenderHandler.WATER_STILL,
                        SimpleFluidRenderHandler.WATER_FLOWING,
                        SimpleFluidRenderHandler.WATER_OVERLAY, 55291));
    }
}
