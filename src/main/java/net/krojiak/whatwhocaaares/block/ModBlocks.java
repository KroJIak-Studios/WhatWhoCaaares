package net.krojiak.whatwhocaaares.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.krojiak.whatwhocaaares.block.custom.ModFluidBlock;
import net.krojiak.whatwhocaaares.fluid.ModFluids;
import net.krojiak.whatwhocaaares.item.ModItemGroup;
import net.krojiak.whatwhocaaares.item.ModItems;
import net.krojiak.whatwhocaaares.whatwhocaaares;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.minecraft.block.Blocks.*;


public class ModBlocks {
    public static final Block BAUXITE_ORE = registerBlock("bauxite_ore",
            new OreBlock(FabricBlockSettings.copyOf(IRON_ORE).requiresTool()), true, ModItemGroup.ENVIRONMENT);

    public static final Block RAW_BAUXITE_BLOCK = registerBlock("raw_bauxite_block",
            new Block(FabricBlockSettings.copyOf(RAW_IRON_BLOCK).requiresTool()), true, ModItemGroup.ENVIRONMENT);

    public static final Block ALUNITE_ORE = registerBlock("alunite_ore",
            new OreBlock(FabricBlockSettings.copyOf(IRON_ORE).requiresTool()), true, ModItemGroup.ENVIRONMENT);

    public static final Block RAW_ALUNITE_BLOCK = registerBlock("raw_alunite_block",
            new Block(FabricBlockSettings.copyOf(RAW_IRON_BLOCK).requiresTool()), true, ModItemGroup.ENVIRONMENT);

    public static final Block NEPHELINE_SYENITE = registerBlock("nepheline_syenite",
            new OreBlock(FabricBlockSettings.copyOf(IRON_ORE).requiresTool()), true, ModItemGroup.ENVIRONMENT);

    public static final Block NEPHELINE = registerBlock("nepheline",
            new Block(FabricBlockSettings.copyOf(LAPIS_BLOCK).requiresTool()), true, ModItemGroup.ENVIRONMENT);

    public static final Block SYENITE  = registerBlock("syenite",
            new Block(FabricBlockSettings.copyOf(LAPIS_BLOCK).requiresTool()), true, ModItemGroup.ENVIRONMENT);

    public static final Block ALUMINA_BLOCK = registerBlock("alumina_block",
            new FallingBlock(FabricBlockSettings.copyOf(SAND)), true, ModItemGroup.PRODUCTION);

    public static final Block SULPHURIC_ACID = registerBlock("sulphuric_acid",
            new ModFluidBlock(ModFluids.SULPHURIC_ACID_STILL, FabricBlockSettings.of(Material.WATER).noCollision().nonOpaque().dropsNothing()),
            false, ModItemGroup.ENVIRONMENT);


    private static Block registerBlock(String name, Block block, boolean addGroup, ItemGroup group){
        if(addGroup) { registerBlockAsItem(name, block, group); }
        return Registry.register(Registry.BLOCK, new Identifier(whatwhocaaares.MOD_ID, name), block);
    }
    private static Item registerBlockAsItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(whatwhocaaares.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks(){
        whatwhocaaares.LOGGER.debug("Registering Mod Blocks for " + whatwhocaaares.MOD_ID);
    }
}
