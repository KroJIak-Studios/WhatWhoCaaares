package net.krojiak.whatwhocaaares.fluid;

import net.krojiak.whatwhocaaares.whatwhocaaares;
import net.minecraft.fluid.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid FLOWING_SULPHURIC_ACID = registerFluid("flowing_sulphuric_acid", new SulphuricAcidFluid.Still());
    public static final FlowableFluid SULPHURIC_ACID = registerFluid("sulphuric_acid", new SulphuricAcidFluid.Still());

    private static FlowableFluid registerFluid(String name, FlowableFluid flowableFluid){
        return Registry.register(Registry.FLUID, new Identifier(whatwhocaaares.MOD_ID, name), flowableFluid);
    }

    public static void registerModFluids(){
        whatwhocaaares.LOGGER.debug("Registering Mod Fluids for " + whatwhocaaares.MOD_ID);
    }
}
