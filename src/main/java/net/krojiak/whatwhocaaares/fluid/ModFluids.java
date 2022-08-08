package net.krojiak.whatwhocaaares.fluid;

import net.krojiak.whatwhocaaares.whatwhocaaares;
import net.minecraft.fluid.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {
    public static final FlowableFluid SULPHURIC_ACID_STILL = registerFluid("sulphuric_acid_still", new SulphuricAcidFluid.Still());
    public static final FlowableFluid SULPHURIC_ACID_FLOWING = registerFluid("sulphuric_acid_flowing", new SulphuricAcidFluid.Flowing());

    private static FlowableFluid registerFluid(String name, FlowableFluid flowableFluid){
        return Registry.register(Registry.FLUID, new Identifier(whatwhocaaares.MOD_ID, name), flowableFluid);
    }

}
