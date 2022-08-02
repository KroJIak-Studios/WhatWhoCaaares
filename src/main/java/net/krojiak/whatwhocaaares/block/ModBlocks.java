package net.krojiak.whatwhocaaares.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.krojiak.whatwhocaaares.item.ModItemGroup;
import net.krojiak.whatwhocaaares.whatwhocaaares;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks {
    public static final Block RAW_BAUXITE_BLOCK =
            registerBlock("raw_bauxite_block", new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool()), ModItemGroup.ENVIRONMENT);
    public static final Block RAW_ALUNITE_BLOCK =
            registerBlock("raw_alunite_block", new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool()), ModItemGroup.ENVIRONMENT);
    public static final Block NEPHELINE_BLOCK =
            registerBlock("nepheline_block", new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool()), ModItemGroup.ENVIRONMENT);
    public static final Block SYENITE_BLOCK =
            registerBlock("syenite_block", new Block(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool()), ModItemGroup.ENVIRONMENT);
    public static final Block ALUMINA_BLOCK =
            registerBlock("alumina_block", new Block(FabricBlockSettings.of(Material.AGGREGATE).strength(1f)), ModItemGroup.PRODUCTION);




    private static Block registerBlock(String name, Block block, ItemGroup group){
        registerBlockAsItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(whatwhocaaares.MOD_ID, name), block);
    }
    private static Item registerBlockAsItem(String name, Block block, ItemGroup group){
        return Registry.register(Registry.ITEM, new Identifier(whatwhocaaares.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(group)));
    }
    public static void registerModBlocks(){
        whatwhocaaares.LOGGER.debug("Registering Mod Blocks for " + whatwhocaaares.MOD_ID);
    }
}
